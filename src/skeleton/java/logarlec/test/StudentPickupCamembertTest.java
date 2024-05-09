package logarlec.test;

import logarlec.model.gameobjects.Room;
import logarlec.model.gameobjects.Student;
import logarlec.model.items.Camembert;
import logarlec.skeleton.Skeleton;

public class StudentPickupCamembertTest extends TestCase {
    Room room;
    Student student;
    Camembert camembert;

    /**
     * Konstruktor, amely beállítja a teszteset nevét
     */
    public StudentPickupCamembertTest() {
        super("Student: pickup camembert");
    }

    @Override
    public void init() {
        room = Skeleton.createObject("room", Room.class);
        student = Skeleton.createObject("student", Student.class);
        room.enter(student);
        camembert = Skeleton.createObject("camembert", Camembert.class);
    }

    @Override
    public void run() {
        student.addItem(camembert);
    }
}
