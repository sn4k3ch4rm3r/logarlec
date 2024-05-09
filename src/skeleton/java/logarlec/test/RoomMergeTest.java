package logarlec.test;

import logarlec.model.gameobjects.Room;
import logarlec.model.gameobjects.Teacher;
import logarlec.model.items.Mask;
import logarlec.model.util.Door;
import logarlec.skeleton.Skeleton;

public class RoomMergeTest extends TestCase {
    Room room1;
    Room room2;
    Room room3;
    Door door1;
    Door door2;
    Teacher teacher;
    Mask mask;

    public RoomMergeTest() {
        super("Room: merge");
    }

    @Override
    public void init() {
        room1 = Skeleton.createObject("room1", Room.class);
        room2 = Skeleton.createObject("room2", Room.class);
        room3 = Skeleton.createObject("room3", Room.class);
        door1 = Skeleton.createObject("door1", Door.class, room1, room2);
        door2 = Skeleton.createObject("door2", Door.class, room2, room3);
        teacher = Skeleton.createObject("teacher", Teacher.class);
        room2.enter(teacher);
        mask = Skeleton.createObject("mask", Mask.class);
        room2.addItem(mask);
    }

    @Override
    public void run() {
        room1.merge(room2);
    }
}
