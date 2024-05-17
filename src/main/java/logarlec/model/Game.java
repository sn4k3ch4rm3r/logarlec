package logarlec.model;

import logarlec.model.gameobjects.Person;
import logarlec.model.gameobjects.Room;
import logarlec.model.gameobjects.Student;
import logarlec.model.tiles.Tile;
import logarlec.model.tiles.FloorTile;
import logarlec.model.util.Direction;
import logarlec.model.util.Entity;
import logarlec.model.util.Position;

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

    public void moveEntity(Entity entity, Direction direction) {
        Position position = entity.getPosition();
        Position destination = position.add(direction, 1);
        Person person = entity.getPerson();
        Tile newTile = tiles[destination.x][destination.y];

        if (newTile.stepOn(person)) {
            ((FloorTile) tiles[position.x][position.y]).removePerson(person);
        }
    }

    public void setTile(Tile tile, Position position) {
        // TODO: Set tile and update controller/view
        throw new UnsupportedOperationException("Unimplemented method 'setTile'");
    }

    public Tile getTile(Position position) {
        return tiles[position.x][position.y];
    }
}
