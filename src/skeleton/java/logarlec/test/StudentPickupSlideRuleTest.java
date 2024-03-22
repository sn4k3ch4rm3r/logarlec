package logarlec.skeleton;

import logarlec.gameobjects.Student;
import logarlec.items.SlideRule;

public class StudentPickupSlideRuleTest extends TestCase {
    Student student;
    SlideRule slideRule;
    public StudentPickupSlideRuleTest() {
        super("Student: pickup sliderule");
    }

    @Override
    public void init() {
        student = new Student();
        slideRule = new SlideRule();
    }

    @Override
    public void run() {
        student.addItem(slideRule);
    }
}
