package logarlec.skeleton;

import logarlec.gameobjects.Room;
import logarlec.util.Door;

public class RoomSplitTest extends TestCase {
    Room room;
    Room otherRoom;
    Door door;
    public RoomSplitTest() {
        super("Room: split");
    }

    @Override
    public void init() {
        room = new Room();
        otherRoom = new Room();
        Door door = new Door(room, otherRoom);
    }

    @Override
    public void run() {
        room.split();
    }
}
