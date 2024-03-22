package logarlec.skeleton;

import logarlec.gameobjects.*;
import logarlec.util.*;

public class RoomHideDoorsTest extends TestCase {
    private Room room;
    private Room otherRoom;
    private Door door1;
    private Door door2;

    public RoomHideDoorsTest() {
        super("Room: hide doors");
    }

    public void init() {
        room = new Room();
        otherRoom = new Room();
        door1 = new Door(room, otherRoom);
        door2 = new Door(otherRoom, room);
    }

    public void run() {
        room.hideDoors();
    }

}
