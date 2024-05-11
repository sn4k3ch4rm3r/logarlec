package logarlec.model.tiles;

import logarlec.model.gameobjects.Person;
import logarlec.model.gameobjects.Room;
import logarlec.model.util.Door;
import logarlec.model.util.Position;

public class WallTile extends Tile{
    public WallTile(Position position, Room room) {
        super(position, room);
    }

    /**
     * @return false, mert falra nem lehet lépni
     */
    @Override
    public boolean stepOn(Person person) {
        return false;
    }
}
