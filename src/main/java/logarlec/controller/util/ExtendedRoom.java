package logarlec.controller.util;

import logarlec.model.Game;
import logarlec.model.gameobjects.Room;
import logarlec.model.util.Position;

import java.util.Map;

public class ExtendedRoom{
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

    public void getOwnershipOfTiles(Game game, Map<Integer, Room> rooms){
        for(int i = position.x; i < position.x + width; i++){
            for(int j = position.y; j < position.y + height; j++){
                game.getTile(new Position(i,j)).setRoom(rooms.get(roomId));
            }
        }
    }
}