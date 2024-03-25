package logarlec.test;

import logarlec.gameobjects.Teacher;
import logarlec.items.SlideRule;
import logarlec.skeleton.Skeleton;

public class TeacherPickupSlideruleTest extends TestCase {
    Teacher teacher;
    SlideRule slideRule;
    public TeacherPickupSlideruleTest() {
        super("Teacher: pickup sliderule");
    }

    @Override
    public void init() {
        teacher = Skeleton.createObject("teacher", Teacher.class);
        slideRule = Skeleton.createObject("slideRule", SlideRule.class);
    }

    @Override
    public void run() {
        teacher.addItem(slideRule);
    }
}
