package logarlec.skeleton;

import logarlec.gameobjects.Teacher;
import logarlec.items.SlideRule;

public class TeacherPickupSlideruleTest extends TestCase {
    Teacher teacher;
    SlideRule slideRule;
    public TeacherPickupSlideruleTest() {
        super("Teacher: pickup sliderule");
    }

    @Override
    public void init() {
        teacher = new Teacher();
        slideRule = new SlideRule();
    }

    @Override
    public void run() {
        teacher.addItem(slideRule);
    }
}
