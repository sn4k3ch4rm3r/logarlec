package logarlec.test;

import logarlec.model.gameobjects.*;
import logarlec.model.util.*;
import logarlec.skeleton.Skeleton;

public class RoomShowDoorsTest extends TestCase {
    Room room;
    Room otherRoom;
    Door door;
    Door door2;

    public RoomShowDoorsTest() {
        super("Room: show doors");
    }

    @Override
    public void init() {
        room = Skeleton.createObject("room", Room.class);
        otherRoom = Skeleton.createObject("otherRoom", Room.class);
        door = Skeleton.createObject("door", Door.class, room, otherRoom);
        door2 = Skeleton.createObject("door2", Door.class, otherRoom, room);
        room.hideDoors();
    }

    @Override
    public void run() {
        room.showDoors();
    }
}
