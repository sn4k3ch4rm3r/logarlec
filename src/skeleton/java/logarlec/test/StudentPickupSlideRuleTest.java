package logarlec.test;

import logarlec.model.gameobjects.Student;
import logarlec.model.items.SlideRule;
import logarlec.skeleton.Skeleton;

public class StudentPickupSlideRuleTest extends TestCase {
    Student student;
    SlideRule slideRule;

    public StudentPickupSlideRuleTest() {
        super("Student: pickup sliderule");
    }

    @Override
    public void init() {
        student = Skeleton.createObject("student", Student.class);
        slideRule = Skeleton.createObject("slideRule", SlideRule.class);
    }

    @Override
    public void run() {
        student.addItem(slideRule);
    }
}
