package logarlec.model;

import logarlec.model.gameobjects.Person;
import logarlec.model.gameobjects.Room;
import logarlec.model.items.Item;
import logarlec.model.tiles.Tile;
import logarlec.model.tiles.FloorTile;
import logarlec.model.util.Direction;
import logarlec.model.util.Entity;
import logarlec.model.util.Position;
import java.util.LinkedList;
import java.util.List;

/**
 * A játékot reprezentáló osztály.
 */
public class Game {
    private List<Room> rooms;
    private Tile[][] tiles;

    public Game(int mapWidth, int mapHeight) {
        tiles = new Tile[mapWidth][mapHeight];
        rooms = new LinkedList<>();
    }

    /**
     * Visszaadja a játékban szereplő szobákat.
     *
     * @return a szobák listája
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * Egy új szobát ad a játékhoz.
     *
     * @param room Az új szoba
     */
    public void addRoom(Room room) {
        rooms.add(room);
    }

    /**
     * Egy entitást mozgat egy adott irányba.
     *
     * @param entity Az entitás, amit mozgatni szeretnénk
     * @param direction Az irány, amerre mozgatni szeretnénk
     */
    public void moveEntity(Entity entity, Direction direction) {
        Position position = entity.getPosition();
        Position destination = position.add(direction, 1);
        Person person = entity.getPerson();
        Tile newTile = tiles[destination.x][destination.y];

        if (newTile.stepOn(person)) {
            entity.setPosition(newTile.getPosition());
            ((FloorTile) tiles[position.x][position.y]).removePerson();
        }
    }

    public void putTile(Tile tile) {
        tiles[tile.getPosition().x][tile.getPosition().y] = tile;
    }

    public Tile getTile(Position position) {
        return tiles[position.x][position.y];
    }

    /**
     * Egy entitást hozzáad a játékhoz.
     *
     * @param entity Az entitás, amit hozzá szeretnénk adni
     */
    public void addEntity(Entity entity) {
        Position position = entity.getPosition();
        Person person = entity.getPerson();
        Tile tile = getTile(position);
        if (!tile.stepOn(person) || !tile.getRoom().enter(person)) {
            throw new IllegalArgumentException(String
                    .format("Entity could not be placed at (%d, %d).", position.x, position.y));
        }
    }

    /**
     * Egy tárgyat rak egy adott pozícióra.
     *
     * @param item A tárgy, amit le szeretnénk rakni
     * @param position A pozíció, ahol hozzá szeretnénk rakni
     */
    public void addItem(Item item, Position position) {
        FloorTile tile = (FloorTile) getTile(position);
        if (tile.getItem() != null) {
            throw new IllegalArgumentException("Tile already has an item on it.");
        }
        tile.setItem(item);
        item.setRoom(tile.getRoom());
    }
}
