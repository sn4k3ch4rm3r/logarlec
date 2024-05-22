package logarlec.model.tiles;

import logarlec.model.events.TileChangeListener;
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

    public FloorTile(Tile oldTile) {
        super(oldTile.getPosition(), oldTile.getRoom());
        if (oldTile instanceof FloorTile) {
            person = ((FloorTile) oldTile).getPerson();
            item = ((FloorTile) oldTile).getItem();
        }
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
        item.setRoom(getRoom());
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

    @Override
    public void clearEffects() {
        for (TileChangeListener listener : onChangeListeners) {
            listener.onClearTile();
        }
    }
}
