package logarlec.model.util;

import logarlec.model.gameobjects.Room;
import logarlec.model.gameobjects.Student;
import logarlec.model.tiles.Tile;

import java.util.List;

public class Game {
    private List<Student> players;
    private List<Room> rooms;
    private List<Entity> entities;
    private List<Tile> tiles;

    public List<Student> getPlayers() {
        return players;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
