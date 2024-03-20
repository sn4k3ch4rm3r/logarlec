package logarlec.skeleton;

import logarlec.gameobjects.Student;
import logarlec.items.Beer;

public class StudentUseBeerTest extends TestCase {
    Student student;
    Beer beer;
    public StudentUseBeerTest() {
        super("Student: use beer");
    }

    @Override
    public void init() {
        student = new Student();
        beer = new Beer();
    }

    @Override
    public void run() {
        beer.use();
    }
}
