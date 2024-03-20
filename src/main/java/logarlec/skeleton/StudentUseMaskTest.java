package logarlec.skeleton;

import logarlec.gameobjects.Student;
import logarlec.items.Mask;

public class StudentUseMaskTest extends TestCase {
    Student student;
    Mask mask;
    public StudentUseMaskTest() {
        super("Student: use mask");
    }

    @Override
    public void init() {
        student = new Student();
        mask = new Mask();
        student.addItem(mask);
    }

    @Override
    public void run() {
        mask.usePassive();
    }
}
