package logarlec.test;

import logarlec.effects.BeerEffect;
import logarlec.gameobjects.Student;
import logarlec.skeleton.Skeleton;

public class StudentProtectedByBeerTest extends TestCase {
    Student student;
    BeerEffect beerEffect;
    public StudentProtectedByBeerTest() {
        super("Student: protected by beer");
    }

    @Override
    public void init() {
        student = Skeleton.createObject("student", Student.class);
        beerEffect = Skeleton.createObject("beerEffect", BeerEffect.class);
        student.addEffect(beerEffect);
        student.setEliminated(true);
    }

    @Override
    public void run() {
        student.update(1);
    }
}
