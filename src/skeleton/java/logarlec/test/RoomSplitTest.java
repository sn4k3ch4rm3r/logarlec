package logarlec.test;

import logarlec.model.gameobjects.Room;
import logarlec.model.util.Door;
import logarlec.skeleton.Skeleton;

public class RoomSplitTest extends TestCase {
    Room room;
    Room otherRoom;
    Door door;

    public RoomSplitTest() {
        super("Room: split");
    }

    @Override
    public void init() {
        room = Skeleton.createObject("room", Room.class);
        otherRoom = Skeleton.createObject("otherRoom", Room.class);
        door = Skeleton.createObject("door", Door.class, room, otherRoom);
    }

    @Override
    public void run() {
        room.split();
    }
}
