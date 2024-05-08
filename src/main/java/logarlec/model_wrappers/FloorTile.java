package logarlec.model_wrappers;

import logarlec.models.gameobjects.Person;
import logarlec.models.items.Item;

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
