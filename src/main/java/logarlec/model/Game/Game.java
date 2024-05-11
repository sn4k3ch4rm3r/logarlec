package logarlec.model.Game;

import logarlec.model.gameobjects.Room;
import logarlec.model.gameobjects.Student;
import logarlec.model.tiles.Tile;
import logarlec.model.util.Entity;

import java.util.List;

public class Game {
    private List<Student> players;
    private List<Room> rooms;
    private List<Entity> entities;
    private Tile[][] tiles;

    public List<Student> getPlayers() {
        return players;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
