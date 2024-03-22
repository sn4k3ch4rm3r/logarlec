package logarlec.skeleton;

import logarlec.gameobjects.Room;
import logarlec.gameobjects.Student;

public class RoomUpdateNoTeachersTest extends TestCase {
    Room room;
    Student student1;
    Student student2;
    public RoomUpdateNoTeachersTest() {
        super("Room: update no teachers");
    }

    @Override
    public void init() {
        room = new Room();
        student1 = new Student();
        student2 = new Student();
        room.enter(student1);
        room.enter(student2);
    }

    @Override
    public void run() {
        room.update(1);
    }
}
