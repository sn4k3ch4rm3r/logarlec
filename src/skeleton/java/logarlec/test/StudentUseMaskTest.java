package logarlec.test;

import logarlec.gameobjects.Student;
import logarlec.items.Mask;
import logarlec.skeleton.Skeleton;

public class StudentUseMaskTest extends TestCase {
    Student student;
    Mask mask;
    public StudentUseMaskTest() {
        super("Student: use mask");
    }

    @Override
    public void init() {
        student = Skeleton.createObject("student", Student.class);
        mask = Skeleton.createObject("mask", Mask.class);
        student.addItem(mask);
    }

    @Override
    public void run() {
        mask.usePassive();
    }
}
