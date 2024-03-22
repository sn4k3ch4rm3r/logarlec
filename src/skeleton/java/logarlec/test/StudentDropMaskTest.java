package logarlec.test;

import logarlec.gameobjects.Room;
import logarlec.gameobjects.Student;
import logarlec.items.Mask;
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
        room.enter(student);
        mask = Skeleton.createObject("mask", Mask.class);
        student.addItem(mask);
    }

    @Override
    public void run() {
        student.dropItem(mask);
    }
}
