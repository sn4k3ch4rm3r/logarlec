package logarlec.controller.util;

import logarlec.controller.PersonController;
import logarlec.controller.TileController;
import logarlec.model.Game;
import logarlec.model.gameobjects.Room;
import logarlec.model.util.Position;
import logarlec.view.Renderer;
import logarlec.view.drawables.Drawable;
import logarlec.view.drawables.MapView;
import logarlec.view.drawables.SideBarView;
import logarlec.view.panels.GamePanel;

import java.util.List;
import java.util.Map;

public class GameRebuilder {
    Game game;

    Map<Integer, Room> rooms;

    class ExtendedRoom{
        int roomId;
        int capacity;
        Position position;
        int width;
        int height;
        public ExtendedRoom(int roomId, int capacity, Position position, int width, int height){
            this.roomId = roomId;
            this.capacity = capacity;
            this.position = position;
            this.width = width;
            this.height = height;
        }

        public void getOwnershipOfTiles(){
            for(int i = position.x; i < position.x + width; i++){
                for(int j = position.y; j < position.y + height; j++){
                    game.getTile(new Position(i,j)).setRoom(rooms.get(roomId));
                }
            }
        }
    }

    public GameRebuilder(Game game, GameBuilder bg) {
        this.game = game;
        rooms = bg.getRooms();
    }



    public void refreshRooms(int newConfigId){
        MapDataLoader mdl = new MapDataLoader();
        List<Integer> roomIds = mdl.getRoomIds(newConfigId);

        for(int roomId : roomIds){
            if(!rooms.containsKey(roomId)){
                rooms.put(roomId, new Room());
            }
        }

    }
}
