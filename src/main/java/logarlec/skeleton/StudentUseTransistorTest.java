package logarlec.skeleton;

import logarlec.gameobjects.Room;
import logarlec.gameobjects.Student;
import logarlec.items.Transistor;

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
        student = new Student();
        transistor1 = new Transistor();
        transistor2 = new Transistor();
        room = new Room();
        targetRoom = new Room();
        student.addItem(transistor1);
    }

    @Override
    public void run() {
        transistor1.use();
    }
}
