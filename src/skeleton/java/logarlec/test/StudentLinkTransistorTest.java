package logarlec.test;

import logarlec.items.Transistor;
import logarlec.skeleton.Skeleton;

public class StudentLinkTransistorTest extends TestCase {
    Transistor transistor1;
    Transistor transistor2;
    public StudentLinkTransistorTest() {
        super("Student: link transistor");
    }

    @Override
    public void init() {
        transistor1 = Skeleton.createObject("transistor1", Transistor.class);
        transistor2 = Skeleton.createObject("transistor2", Transistor.class);
    }

    @Override
    public void run() {
        transistor1.useItem(transistor2);
    }
}
