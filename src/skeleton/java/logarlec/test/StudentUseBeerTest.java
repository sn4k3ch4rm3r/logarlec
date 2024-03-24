package logarlec.test;

import logarlec.gameobjects.Student;
import logarlec.items.Beer;
import logarlec.skeleton.Skeleton;

public class StudentUseBeerTest extends TestCase {
    Student student;
    Beer beer;
    public StudentUseBeerTest() {
        super("Student: use beer");
    }

    @Override
    public void init() {
        student = Skeleton.createObject("student", Student.class);
        beer = Skeleton.createObject("beer", Beer.class);
    }

    @Override
    public void run() {
        beer.use();
    }
}
