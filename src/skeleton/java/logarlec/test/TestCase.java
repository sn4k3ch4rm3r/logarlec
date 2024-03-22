package logarlec.skeleton;

/**
 * Abstract class for test cases
 */
public abstract class TestCase {
    /**
     * Name of the test case

     */
    public String name;

    /**
     * Constructor for the test case
     * @param name Name of the test case
     */
    public TestCase(String name) {
        this.name = name;
    }

    /**
     * Abstract method to initialize the test case
     */
    public abstract void init();

    /**
     * Abstract method to run the test case
     */
    public abstract void run();

}
