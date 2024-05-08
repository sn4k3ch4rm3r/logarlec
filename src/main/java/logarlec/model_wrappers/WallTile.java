package logarlec.model_wrappers;

import logarlec.models.gameobjects.Person;

public class WallTile extends Tile{
    @Override
    public boolean stepOn(Person person) {
        return false;
    }
}
