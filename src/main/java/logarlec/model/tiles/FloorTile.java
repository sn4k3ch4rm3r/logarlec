package logarlec.model.tiles;

import logarlec.model.gameobjects.Person;
import logarlec.model.gameobjects.Room;
import logarlec.model.items.Item;
import logarlec.model.util.Position;

public class FloorTile extends Tile {
    private Person person;
    private Item item;

    public FloorTile(Position position, Room room) {
        super(position, room);
    }

    /**
     * Egy személy erre a tile-ra lép, ha nincs még rajta személy. Ha sikereses a rálépés felveszi
     * az itt található tárgyat
     * 
     * @param person Aki ide próbál lépni
     */
    @Override
    public Position stepOn(Person person) {
        if (this.person != null) {
            return null;
        }
        this.person = person;
        if (this.item != null && person.addItem(item)) {
            this.item = null;
        }
        onChanged();
        return getPosition();
    }

    public void setItem(Item item) {
        this.item = item;
        onChanged();
    }

    public Item getItem() {
        return item;
    }

    public Person getPerson() {
        return person;
    }

    public void removePerson() {
        this.person = null;
        onChanged();
    }
}
