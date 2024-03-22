package logarlec.skeleton;

import logarlec.gameobjects.Student;
import logarlec.items.Mask;

public class StudentPickupMaskTest extends TestCase {
    Student student;
    Mask mask;
    public StudentPickupMaskTest() {
        super("Student: pickup mask");
    }

    @Override
    public void init() {
        student = new Student();
        mask = new Mask();
    }

    @Override
    public void run() {
        student.addItem(mask);
    }
}
