package logarlec.skeleton;

import logarlec.gameobjects.*;
import logarlec.util.*;

public class RoomShowDoorsTest extends TestCase {
    Room room;
    Room otherRoom;
    Door door1;
    Door door2;

    public RoomShowDoorsTest() {
        super("Room: show doors");
    }

    @Override
    public void init() {
        room = new Room();
        otherRoom = new Room();
        door1 = new Door(room, otherRoom);
        door2 = new Door(otherRoom, room);
        room.hideDoors();
    }

    @Override
    public void run() {
        room.showDoors();
    }
}
