package logarlec.skeleton;

import logarlec.effects.BeerEffect;
import logarlec.gameobjects.Student;

public class StudentProtectedByBeerTest extends TestCase {
    Student student;
    BeerEffect beerEffect;
    public StudentProtectedByBeerTest() {
        super("Student: protected by beer");
    }

    @Override
    public void init() {
        student = new Student();
        beerEffect = new BeerEffect();
        student.addEffect(beerEffect);
        student.setEliminated(true);
    }

    @Override
    public void run() {
        student.update(1);
    }
}
