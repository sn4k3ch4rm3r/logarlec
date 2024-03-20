package logarlec.skeleton;

import logarlec.gameobjects.*;
import logarlec.util.*;

/**
 * Test case for the use of a door
 */
public class DoorUseTest extends TestCase {
    private Student student; // The student who will use the door
    private Room from; // The room in which the student currently is
    private Room to; // The room to which the student will go
    private Door door; // The door that the student will use

    /**
     * Constructor for the test case
     */
    public DoorUseTest() {
        super("Door: use");
    }

    /**
     * This method initializes the test case
     * It creates the necessary objects for the test
     */
    public void init() {
        student = new Student();
        from = new Room();
        to = new Room();
        door = new Door(from, to);
    }

    /**
     * This method runs the test case
     * It calls the use method of the door
     */
    public void run() {
        door.use(student, from);
    }

}
