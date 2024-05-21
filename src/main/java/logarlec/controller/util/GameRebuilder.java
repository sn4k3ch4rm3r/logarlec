package logarlec.controller.util;

import logarlec.controller.PersonController;
import logarlec.controller.TileController;
import logarlec.model.Game;
import logarlec.model.gameobjects.Room;
import logarlec.model.tiles.FloorTile;
import logarlec.model.tiles.Tile;
import logarlec.model.tiles.WallTile;
import logarlec.model.util.Position;
import logarlec.view.Renderer;
import logarlec.view.drawables.*;
import logarlec.view.panels.GamePanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameRebuilder {
    Game game;
    GameBuilder bg;

    Map<Integer, Room> rooms;

    List<ExtendedRoom> extendedRooms;



    public GameRebuilder(Game game, GameBuilder bg) {
        extendedRooms = new ArrayList<ExtendedRoom>();
        this.game = game;
        this.bg = bg;
        rooms = bg.getRooms();
    }

    private void getRoomsFromConfig(int configId){
        MapDataLoader mdl = new MapDataLoader();
        List<ExtendedRoom> newRooms = mdl.getRoomDatas(configId);

        for(ExtendedRoom newRoom: newRooms){
            if(!rooms.containsKey(newRoom.roomId)){
                rooms.put(newRoom.roomId, rooms.get(newRoom.roomId-100).split());
            }
        }
    }

    public void rebuildGame(int configId){
        getRoomsFromConfig(configId);
        for(ExtendedRoom er: extendedRooms){
            er.getOwnershipOfTiles(game, rooms);
        }
        buildNewWalls(bg.getPanel(), bg.getRenderer());
    }

    public void buildNewWalls(GamePanel panel, Renderer renderer){

        for(ExtendedRoom e_room: extendedRooms){
            buildWalls(e_room.position, e_room.width, e_room.height, rooms.get(e_room.roomId));
        }
    }

    private void buildWalls(Position position, int width, int height, Room room){

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
                    addTile(tile, view);
                }
            }
        }
    }

    private void addTile(Tile tile, TileView view) {
        game.putTile(tile);
        bg.getMapView().addTileView(view);
        bg.getModelViews().put(tile, view);
    }
}
