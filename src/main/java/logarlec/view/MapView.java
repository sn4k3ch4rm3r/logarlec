package logarlec.view;

import logarlec.controller.util.TileType;

import java.awt.*;
import java.util.*;
import java.util.List;

public class MapView implements Drawable {
    private Map<RoomView, Rectangle> roomPositions = new HashMap<>();

    /**
     * A térkép nézet konstruktora. Létrehozza a térképen található szobák nézeteit.
     * @param tiles A térkép csempéi.
     */
    public MapView(TileType[][] tiles) {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (tiles[i][j] == TileType.FLOOR) {
                    addRoomViewAt(tiles, i, j);
                }
            }
        }
    }

    /**
     * A térképen található szobák kirajzolása.
     * @param g2d A rajzolásra használt grafikus objektum.
     */
    @Override
    public void draw(Graphics2D g2d) {
        for (RoomView roomView : roomPositions.keySet()) {
            Rectangle position = roomPositions.get(roomView);
            Graphics2D g = (Graphics2D) g2d.create(position.x * 16, position.y * 16, position.width * 16, position.height * 16);
            roomView.draw(g);
        }
    }

    private void addRoomViewAt(TileType[][] tiles, int x, int y) {
        boolean[][] belongsToRoom = new boolean[tiles.length][tiles[0].length];
        belongsToRoom[x][y] = true;
        belongsToRoom = roomDiscoveryFrom(belongsToRoom, tiles, x, y);
        int top = tiles.length;
        int left = 0;
        int bottom = 0;
        int right = tiles[0].length;
        for (int i = 0; i < belongsToRoom.length; i++) {
            for (int j = 0; j < belongsToRoom[i].length; j++) {
                if (belongsToRoom[i][j]) {
                    bottom = i;
                    left = j;
                    if (i < top) {
                        top = i;
                    }
                    if (j < right) {
                        right = j;
                    }
                }
            }
        }
        List<List<TileType>> roomTiles = new ArrayList<>();
        for (int i = top; i <= bottom; i++) {
            List<TileType> row = new ArrayList<>();
            for (int j = right; j <= left; j++) {
                if (belongsToRoom[i][j]) {
                    row.add(tiles[i][j]);
                    tiles[i][j] = TileType.WALL;
                } else {
                    row.add(TileType.INVALID);
                }
            }
            roomTiles.add(row);
        }
        RoomView roomView = new RoomView(roomTiles);
        roomPositions.put(roomView, new Rectangle(right, top, left - right + 1, bottom - top + 1));
    }

    private boolean[][] roomDiscoveryFrom(boolean[][] roomTiles, TileType[][] tiles, int x, int y) {
        if (x < 0 || x >= tiles.length || y < 0 || y >= tiles[0].length) {
            return roomTiles;
        }
        if (roomTiles[x][y] && tiles[x][y] == TileType.FLOOR) {
            if (!roomTiles[x - 1][y]) {
                roomTiles[x - 1][y] = true;
                roomTiles = roomDiscoveryFrom(roomTiles, tiles, x - 1, y);
            }
            if (!roomTiles[x + 1][y]) {
                roomTiles[x + 1][y] = true;
                roomTiles = roomDiscoveryFrom(roomTiles, tiles, x + 1, y);
            }
            if (!roomTiles[x][y - 1]) {
                roomTiles[x][y - 1] = true;
                roomTiles = roomDiscoveryFrom(roomTiles, tiles, x, y - 1);
            }
            if (!roomTiles[x][y + 1]) {
                roomTiles[x][y + 1] = true;
                roomTiles = roomDiscoveryFrom(roomTiles, tiles, x, y + 1);
            }
            if (!roomTiles[x - 1][y - 1]) {
                roomTiles[x - 1][y - 1] = true;
                roomTiles = roomDiscoveryFrom(roomTiles, tiles, x - 1, y - 1);
            }
            if (!roomTiles[x - 1][y + 1]) {
                roomTiles[x - 1][y + 1] = true;
                roomTiles = roomDiscoveryFrom(roomTiles, tiles, x - 1, y + 1);
            }
            if (!roomTiles[x + 1][y - 1]) {
                roomTiles[x + 1][y - 1] = true;
                roomTiles = roomDiscoveryFrom(roomTiles, tiles, x + 1, y - 1);
            }
            if (!roomTiles[x + 1][y + 1]) {
                roomTiles[x + 1][y + 1] = true;
                roomTiles = roomDiscoveryFrom(roomTiles, tiles, x + 1, y + 1);
            }
        }
        return roomTiles;
    }
}
