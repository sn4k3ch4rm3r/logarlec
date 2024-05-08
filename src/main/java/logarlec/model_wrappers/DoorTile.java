package logarlec.model_wrappers;

import logarlec.models.gameobjects.Person;
import logarlec.models.util.Door;

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
