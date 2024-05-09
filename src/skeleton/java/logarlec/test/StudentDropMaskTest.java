package logarlec.test;

import logarlec.model.gameobjects.Room;
import logarlec.model.gameobjects.Student;
import logarlec.model.items.Mask;
import logarlec.skeleton.Skeleton;

public class StudentDropMaskTest extends TestCase {
    Room room;
    Student student;
    Mask mask;

    public StudentDropMaskTest() {
        super("Student: drop mask");
    }

    @Override
    public void init() {
        room = Skeleton.createObject("room", Room.class);
        student = Skeleton.createObject("student", Student.class);
        mask = Skeleton.createObject("mask", Mask.class);
        room.enter(student);
        mask.setRoom(room);
        student.addItem(mask);
    }

    @Override
    public void run() {
        student.dropItem(mask);
    }
}
