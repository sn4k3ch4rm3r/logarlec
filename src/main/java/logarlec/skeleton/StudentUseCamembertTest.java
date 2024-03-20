package logarlec.skeleton;

import logarlec.gameobjects.Room;
import logarlec.gameobjects.Student;
import logarlec.items.Camembert;

public class StudentUseCamembertTest extends TestCase {
    Student student;
    Room room;
    Camembert camembert;
    public StudentUseCamembertTest() {
        super("Student: use camembert");
    }

    @Override
    public void init() {
        student = new Student();
        room = new Room();
        camembert = new Camembert();
        student.addItem(camembert);
        room.enter(student);
    }

    @Override
    public void run() {
        camembert.use();
    }
}
