package logarlec.model_wrappers;

import logarlec.models.gameobjects.Room;
import logarlec.models.gameobjects.Student;

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
