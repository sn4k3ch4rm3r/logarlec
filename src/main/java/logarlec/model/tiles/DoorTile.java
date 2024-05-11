package logarlec.model.tiles;

import logarlec.model.gameobjects.Person;
import logarlec.model.gameobjects.Room;
import logarlec.model.util.Door;
import logarlec.model.util.Position;

public class DoorTile extends Tile {
    private Door door;

    public DoorTile(Position position, Room room, Door door) {
        super(position, room);
        this.door = door;
    }

    /**
     * Az ehhez tartozó ajtón megpróbál átlépni a személy, ha sikerül átkerül egy csempére az ajtó túloldalán
     * @param person Aki ide próbál lépni
     * @return sikeres-e az ajtón átlépés
     */
    @Override
    public boolean stepOn(Person person) {
        if (door.use(person)) {
            return false;
        }
        /* TODO: átrakni valahogy egy túloldali flooar tile-ra*/
        return true;
    }
}
