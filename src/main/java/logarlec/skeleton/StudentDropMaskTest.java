package logarlec.skeleton;

import logarlec.gameobjects.Room;
import logarlec.gameobjects.Student;
import logarlec.items.Mask;

public class StudentDropMaskTest extends TestCase {
    Room room;
    Student student;
    Mask mask;

    public StudentDropMaskTest() {
        super("Student: drop mask");
    }

    @Override
    public void init() {
        room = new Room();
        student = new Student();
        room.enter(student);
        mask = new Mask();
        student.addItem(mask);
    }

    @Override
    public void run() {
        student.dropItem(mask);
    }
}
