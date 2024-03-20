package logarlec.skeleton;

public abstract class TestCase {
    public String name;

    public TestCase(String name) {
        this.name = name;
    }

    public abstract void init();
    
    public abstract void run();

}
