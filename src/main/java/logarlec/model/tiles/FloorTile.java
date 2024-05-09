package logarlec.model.tiles;

import logarlec.model.gameobjects.Person;
import logarlec.model.items.Item;

public class FloorTile extends Tile {
    private Person person;
    private Item item;
    @Override
    public boolean stepOn(Person person) {
        if (this.person != null)
            return false;
        this.person = person;
        person.addItem(item);
        if (item.getPerson() == person) {
            this.item = null;
        }
        onChanged();
        return true;
    }
}
