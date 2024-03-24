package logarlec.test;

import logarlec.gameobjects.*;
import logarlec.skeleton.Skeleton;
import logarlec.util.*;

public class RoomHideDoorsTest extends TestCase {
    private Room room;
    private Room otherRoom;

    public RoomHideDoorsTest() {
        super("Room: hide doors");
    }

    public void init() {
        room = Skeleton.createObject("room", Room.class);
        otherRoom = Skeleton.createObject("otherRoom", Room.class);
        Skeleton.createObject("door", Door.class, room, otherRoom);
        Skeleton.createObject("door2", Door.class, otherRoom, room);
    }

    public void run() {
        room.hideDoors();
    }

}
