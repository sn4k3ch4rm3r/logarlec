package logarlec.test;

import logarlec.model.gameobjects.*;
import logarlec.model.util.*;
import logarlec.skeleton.Skeleton;

public class DoorUseTest extends TestCase {
    private Student student;
    private Room from;
    private Room next;
    private Door door;

    public DoorUseTest() {
        super("Door: use");
    }

    public void init() {
        student = Skeleton.createObject("student", Student.class);
        from = Skeleton.createObject("from", Room.class);
        next = Skeleton.createObject("next", Room.class);
        door = Skeleton.createObject("door", Door.class, from, next);

        from.enter(student);
    }

    public void run() {
        door.use(student);
    }

}
