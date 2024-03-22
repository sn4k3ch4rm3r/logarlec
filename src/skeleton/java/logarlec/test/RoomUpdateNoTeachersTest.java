package logarlec.test;

import logarlec.gameobjects.Room;
import logarlec.gameobjects.Student;
import logarlec.skeleton.Skeleton;

public class RoomUpdateNoTeachersTest extends TestCase {
    Room room;
    Student student1;
    Student student2;
    public RoomUpdateNoTeachersTest() {
        super("Room: update no teachers");
    }

    @Override
    public void init() {
        room = Skeleton.createObject("room", Room.class);
        student1 = Skeleton.createObject("student1", Student.class);
        student2 = Skeleton.createObject("student2", Student.class);
        room.enter(student1);
        room.enter(student2);
    }

    @Override
    public void run() {
        room.update(1);
    }
}
