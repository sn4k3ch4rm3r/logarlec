package logarlec.test;

import logarlec.gameobjects.Room;
import logarlec.skeleton.Skeleton;
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
        room = Skeleton.createObject("room", Room.class);
        otherRoom = Skeleton.createObject("otherRoom", Room.class);
        door = Skeleton.createObject("door", Door.class, room, otherRoom);
    }

    @Override
    public void run() {
        room.split();
    }
}
