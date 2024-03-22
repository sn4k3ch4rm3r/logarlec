package logarlec.skeleton;

import logarlec.items.Transistor;

public class StudentLinkTransistorTest extends TestCase {
    Transistor transistor;
    Transistor other;
    public StudentLinkTransistorTest() {
        super("Student: link transistor");
    }

    @Override
    public void init() {
        transistor = new Transistor();
        other = new Transistor();
    }

    @Override
    public void run() {
        transistor.useItem(other);
    }
}
