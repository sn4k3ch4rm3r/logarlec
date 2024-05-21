package logarlec.model.tiles;

import logarlec.model.gameobjects.Person;
import logarlec.model.gameobjects.Room;
import logarlec.model.util.Door;
import logarlec.model.util.Position;

public class DoorTile extends Tile {
    private Door door;
    private Tile destination;

    public DoorTile(Position position, Room room, Door door) {
        super(position, room);
        this.door = door;
    }

    /**
     * Az ehhez tartozó ajtón megpróbál átlépni a személy, ha sikerül átkerül egy csempére az ajtó
     * túloldalán
     * 
     * @param person Aki ide próbál lépni
     * @return sikeres-e az ajtón átlépés
     */
    @Override
    public Position stepOn(Person person) {
        if (door.use(person)) {
            return destination.stepOn(person);
        }
        return null;
    }

    public void setDestination(Tile destination) {
        this.destination = destination;
    }

    public Door getDoor() {
        return door;
    }
}
