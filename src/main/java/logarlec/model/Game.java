package logarlec.model;

import logarlec.model.gameobjects.Person;
import logarlec.model.gameobjects.Room;
import logarlec.model.gameobjects.Student;
import logarlec.model.tiles.Tile;
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

    public void moveEntity(Entity entity, Direction direction){
        Position position = entity.getPosition();
        Person person = entity.getPerson();
        Tile newTile = tiles[position.getX() + direction.getX()][position.getY() + direction.getY()];
        
        if(newTile.stepOn(person)){
            tiles[position.getX()][position.getY()].removePerson(person);
        }
    }
}
