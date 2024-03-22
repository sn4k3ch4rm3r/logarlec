package logarlec.test;

import logarlec.gameobjects.Room;
import logarlec.gameobjects.Student;
import logarlec.items.Transistor;
import logarlec.skeleton.Skeleton;

public class StudentUseTransistorTest extends TestCase {
    Student student;
    Transistor transistor1;
    Transistor transistor2;
    Room room;
    Room targetRoom;
    public StudentUseTransistorTest() {
        super("Student: use transistor");
    }

    @Override
    public void init() {
        student = Skeleton.createObject("student", Student.class);
        transistor1 = Skeleton.createObject("transistor1", Transistor.class);
        transistor2 = Skeleton.createObject("transistor2", Transistor.class);
        room = Skeleton.createObject("room", Room.class);
        targetRoom = Skeleton.createObject("targetRoom", Room.class);
        student.addItem(transistor1);
        student.addItem(transistor2);
    }

    @Override
    public void run() {
        transistor1.use();
    }
}
