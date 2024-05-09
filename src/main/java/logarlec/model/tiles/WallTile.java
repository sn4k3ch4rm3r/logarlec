package logarlec.model.tiles;

import logarlec.model.gameobjects.Person;

public class WallTile extends Tile{
    @Override
    public boolean stepOn(Person person) {
        return false;
    }
}
