package logarlec.test;

import logarlec.gameobjects.*;
import logarlec.skeleton.Skeleton;
import logarlec.util.*;

public class RoomHideDoorsTest extends TestCase {
    private Room room;
    private Room otherRoom;
    private Door door;
    private Door door2;

    public RoomHideDoorsTest() {
        super("Room: hide doors");
    }

    public void init() {
        room = Skeleton.createObject("room", Room.class);
        otherRoom = Skeleton.createObject("otherRoom", Room.class);
        door = Skeleton.createObject("door1", Door.class, room, otherRoom);
        door2 = Skeleton.createObject("door2", Door.class, room, otherRoom);
    }

    public void run() {
        room.hideDoors();
    }

}
