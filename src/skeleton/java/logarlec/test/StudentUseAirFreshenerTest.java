package logarlec.test;

import logarlec.gameobjects.Room;
import logarlec.gameobjects.Student;
import logarlec.items.AirFreshener;
import logarlec.skeleton.Skeleton;

public class StudentUseAirFreshenerTest extends TestCase {
    Room room;
    Student student;
    AirFreshener airFreshener;

    /**
     * Konstruktor, amely beállítja a teszteset nevét
     */
    public StudentUseAirFreshenerTest() {
        super("Student: use air freshener");
    }

    @Override
    public void init() {
        room = Skeleton.createObject("room", Room.class);
        student = Skeleton.createObject("student", Student.class);
        room.enter(student);
        airFreshener = Skeleton.createObject("airFreshener", AirFreshener.class);
        student.addItem(airFreshener);
    }

    @Override
    public void run() {
        airFreshener.use();
    }
}
