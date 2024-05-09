package logarlec.test;

import logarlec.model.gameobjects.Room;
import logarlec.model.gameobjects.Student;
import logarlec.model.items.Camembert;
import logarlec.skeleton.Skeleton;

public class StudentUseCamembertTest extends TestCase {
    Student student;
    Room room;
    Camembert camembert;

    public StudentUseCamembertTest() {
        super("Student: use camembert");
    }

    @Override
    public void init() {
        student = Skeleton.createObject("student", Student.class);
        room = Skeleton.createObject("room", Room.class);
        camembert = Skeleton.createObject("camembert", Camembert.class);
        room.enter(student);
        student.addItem(camembert);
    }

    @Override
    public void run() {
        camembert.use();
    }
}
