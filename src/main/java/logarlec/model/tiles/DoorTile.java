package logarlec.model.tiles;

import logarlec.model.gameobjects.Person;
import logarlec.model.util.Door;

public class DoorTile extends Tile {
    private Door door;
    @Override
    public boolean stepOn(Person person) {
        door.use(person);
        if (person.getCurrentRoom() == getRoom())
            return false;

        /* TODO: átrakni valahogy egy túloldali flooar tile-ra*/
        return true;
    }
}
