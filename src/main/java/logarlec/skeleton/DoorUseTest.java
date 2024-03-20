package logarlec.skeleton;

import logarlec.gameobjects.*;
import logarlec.util.*;

public class DoorUseTest extends TestCase {
    private Student student;
    private Room from;
    private Room to;
    private Door door;

    public DoorUseTest() {
        super("Test door use");
    }

    public void init() {
        student = new Student();
        from = new Room();
        to = new Room();
        door = new Door();
    }

    public void run() {
        System.out.println("Test door use");
    }

}
