package logarlec.test;

import logarlec.gameobjects.Student;
import logarlec.items.Mask;
import logarlec.skeleton.Skeleton;

public class StudentPickupMaskTest extends TestCase {
    Student student;
    Mask mask;
    public StudentPickupMaskTest() {
        super("Student: pickup mask");
    }

    @Override
    public void init() {
        student = Skeleton.createObject("student", Student.class);
        mask = Skeleton.createObject("mask", Mask.class);
    }

    @Override
    public void run() {
        student.addItem(mask);
    }
}
