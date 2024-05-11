package logarlec.model.tiles;

import logarlec.model.events.TileChangeListener;
import logarlec.model.gameobjects.Person;
import logarlec.model.gameobjects.Room;
import logarlec.model.util.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class Tile {
    private Position position;
    private List<TileChangeListener> onChangeListeners = new ArrayList<>();
    private Room room;

    public Tile(Position position, Room room) {
        this.position = position;
        this.room = room;
    }

    /**
     * Egy személy rá próbál lépni erre a csempére
     * 
     * @param person Aki ide próbál lépni
     * @return sikeres-e a rálépés
     */
    public abstract boolean stepOn(Person person);

    public void addOnChangeEventListener(TileChangeListener listener) {
        onChangeListeners.add(listener);
    }

    /**
     * Valami változott a csempe állapotán, erről értesül, akit érint
     */
    protected void onChanged() {
        for (TileChangeListener listener : onChangeListeners) {
            listener.onTileChanged(this);
        }
    }

    public Position getPosition() {
        return position;
    }

    public Room getRoom() {
        return room;
    }
}
