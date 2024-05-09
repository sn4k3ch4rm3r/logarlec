package logarlec.model.tiles;

import logarlec.model.gameobjects.Person;
import logarlec.model.gameobjects.Room;
import logarlec.model.util.Position;

import java.util.List;

public abstract class Tile {
    private Position coord;
    private List<TileChangeListener> onChangeListeners;
    private Room room;

    public abstract boolean stepOn(Person person);
    public void addOnChangeEventListener(TileChangeListener listener) {
        onChangeListeners.add(listener);
    }
    protected void onChanged() {
        for (TileChangeListener listener : onChangeListeners)
            listener.onTileChanged(this);
    }

    public Position getCoord() {
        return coord;
    }

    public Room getRoom() {
        return room;
    }
}
