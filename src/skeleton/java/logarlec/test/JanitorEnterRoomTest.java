package logarlec.test;

import logarlec.model.gameobjects.Janitor;
import logarlec.model.gameobjects.Room;
import logarlec.skeleton.Skeleton;

public class JanitorEnterRoomTest extends TestCase {
    Room room;
    Janitor janitor;

    /**
     * Konstruktor, amely beállítja a teszteset nevét
     */
    public JanitorEnterRoomTest() {
        super("Janitor: enter room");
    }

    @Override
    public void init() {
        room = Skeleton.createObject("room", Room.class);
        janitor = Skeleton.createObject("janitor", Janitor.class);
    }

    @Override
    public void run() {
        room.enter(janitor);
    }
}
