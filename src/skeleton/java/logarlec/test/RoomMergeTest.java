package logarlec.skeleton;

import logarlec.gameobjects.Room;
import logarlec.gameobjects.Teacher;
import logarlec.items.Mask;
import logarlec.util.Door;

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
        room1 = new Room();
        room2 = new Room();
        room3 = new Room();
        door1 = new Door(room1, room2);
        door2 = new Door(room2, room3);
        teacher = new Teacher();
        room2.enter(teacher);
        mask = new Mask();
        room2.addItem(mask);
    }

    @Override
    public void run() {
        room1.merge(room2);
    }
}
