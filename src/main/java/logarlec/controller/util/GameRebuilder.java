package logarlec.controller.util;

import logarlec.controller.TileController;
import logarlec.model.Game;
import logarlec.model.gameobjects.Room;
import logarlec.model.tiles.DoorTile;
import logarlec.model.tiles.FloorTile;
import logarlec.model.tiles.Tile;
import logarlec.model.tiles.WallTile;
import logarlec.model.util.Direction;
import logarlec.model.util.Door;
import logarlec.model.util.Position;
import logarlec.view.Renderer;
import logarlec.view.drawables.*;
import logarlec.view.panels.GamePanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GameRebuilder {
    Game game;
    GameBuilder bg;

    Map<Integer, Room> rooms;

    List<ExtendedRoom> extendedRooms;
    List<ExtendedDoor> extendedDoors;

    private int currentConfig = 0;

    public GameRebuilder(Game game, GameBuilder bg) {
        extendedRooms = new ArrayList<ExtendedRoom>();
        extendedDoors = new ArrayList<ExtendedDoor>();
        this.game = game;
        this.bg = bg;
        rooms = bg.getRooms();
    }

    private void getRoomsFromConfig(int configId) {
        MapDataLoader mdl = new MapDataLoader();
        extendedRooms = mdl.getRoomDatas(configId);

        for (ExtendedRoom newRoom : extendedRooms) {
            if (!rooms.containsKey(newRoom.roomId)) {
                rooms.put(newRoom.roomId, rooms.get(newRoom.roomId - 100).split());
            }
        }
    }

    public void rebuildGame(int configId) {
        getRoomsFromConfig(configId);
        for (ExtendedRoom er : extendedRooms) {
            er.getOwnershipOfTiles(game, rooms);
        }
        buildNewWalls(bg.getPanel(), bg.getRenderer());
        addDoors(configId);
    }

    public void buildNewWalls(GamePanel panel, Renderer renderer) {
        bg.getMapView().clear();
        for (ExtendedRoom e_room : extendedRooms) {
            buildWalls(e_room.position, e_room.width, e_room.height, rooms.get(e_room.roomId));
        }
    }

    private void buildWalls(Position position, int width, int height, Room room) {

        for (int x = position.x; x < width + position.x; x++) {
            for (int y = position.y; y < height + position.y; y++) {
                TileView view;
                Tile tile;
                if (x == position.x || x == position.x + width - 1 || y == position.y
                        || y == position.y + height - 1) {
                    WallTile wallTile = new WallTile(new Position(x, y), room);
                    WallTileView wallView = new WallTileView(wallTile);

                    if (x == position.x && y == position.y) {
                        wallView.setVariation("top-left");
                    }
                    else if (x == position.x + width - 1 && y == position.y) {
                        wallView.setVariation("top-right");
                    }
                    else if (x == position.x && y == position.y + height - 1) {
                        wallView.setVariation("bottom-left");
                    }
                    else if (x == position.x + width - 1 && y == position.y + height - 1) {
                        wallView.setVariation("bottom-right");
                    }
                    else if (y == position.y) {
                        wallView.setVariation("top");
                    }
                    else if (y == position.y + height - 1) {
                        wallView.setVariation("bottom");
                    }
                    else if (x == position.x) {
                        wallView.setVariation("left");
                    }
                    else if (x == position.x + width - 1) {
                        wallView.setVariation("right");
                    }

                    tile = wallTile;
                    view = wallView;
                }
                else {
                    tile = new FloorTile(game.getTile(new Position(x, y)));
                    view = new FloorTileView((FloorTile) tile);
                    new TileController((FloorTile) tile, (FloorTileView) view).initialize();
                }
                addTile(tile, view);
            }
        }
    }

    private void addTile(Tile tile, TileView view) {
        game.putTile(tile);
        bg.getMapView().addTileView(view);
        bg.getModelViews().put(tile, view);
    }

    private void addDoors(int configurationId) {
        MapDataLoader mdl = new MapDataLoader();
        extendedDoors = mdl.getDoorDatas(configurationId);
        for (ExtendedDoor ed : extendedDoors) {
            Room fromRoom = rooms.get(ed.fromID);
            Room toRoom = rooms.get(ed.toID);

            Door door = new Door(fromRoom, toRoom);
            door.setOneWay(ed.oneway);

            DoorTile fromTile = new DoorTile(ed.from, fromRoom, door);
            DoorTile toTile = new DoorTile(ed.to, toRoom, door);

            Direction direction = null;
            for (Direction dir : Direction.values()) {
                if (ed.from.add(dir, 1).equals(ed.to)) {
                    direction = dir;
                }
            }
            if (direction == null) {
                throw new IllegalArgumentException(
                        "The specified to and from tiles are not next to each other.");
            }

            fromTile.setDestination(game.getTile(ed.to.add(direction, 1)));
            toTile.setDestination(game.getTile(ed.from.add(direction.getOpposite(), 1)));

            DoorTileView fromView = new DoorTileView(fromTile, direction);
            DoorTileView toView = new DoorTileView(toTile, direction.getOpposite());

            addTile(fromTile, fromView);
            addTile(toTile, toView);
        }
    }

    Random rand = new Random();

    public int nextConfig() {
        if (currentConfig == 0) {
            currentConfig = rand.nextInt(1, 3);
        }
        else {
            currentConfig = 0;
        }
        return currentConfig;
    }
}
