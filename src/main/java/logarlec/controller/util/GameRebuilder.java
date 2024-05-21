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



    public GameRebuilder(Game game, GameBuilder bg) {
        this.game = game;
        rooms = bg.getRooms();
    }

    private void getRoomsFromConfig(int configId){
    }



    public void refreshRooms(int newConfigId){
        MapDataLoader mdl = new MapDataLoader();
        List<ExtendedRoom> newRooms = mdl.getRoomDatas(newConfigId);

        for(ExtendedRoom newRoom: newRooms){
            if(!rooms.containsKey(newRoom.roomId)){
                rooms.put(newRoom.roomId, rooms.get(newRoom.roomId-100).split());
            }
        }

    }
}
