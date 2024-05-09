package logarlec.test;

import logarlec.model.effects.JanitorEffect;
import logarlec.model.gameobjects.Room;
import logarlec.model.gameobjects.Student;
import logarlec.model.util.Door;
import logarlec.skeleton.Skeleton;

public class RoomUpdateJanitorEffectTest extends TestCase {
    Room room;
    Room room2;
    Door door;
    Student student;
    JanitorEffect janitorEffect;

    /**
     * Konstruktor, amely beállítja a teszteset nevét
     */
    public RoomUpdateJanitorEffectTest() {
        super("Room: update with janitor effect");
    }

    @Override
    public void init() {
        room = Skeleton.createObject("room", Room.class);
        room2 = Skeleton.createObject("room2", Room.class);
        door = Skeleton.createObject("door", Door.class, room, room2);
        student = Skeleton.createObject("student", Student.class);
        room.enter(student);
        janitorEffect = Skeleton.createObject("janitorEffect", JanitorEffect.class);
        room.addEffect(janitorEffect);
    }

    @Override
    public void run() {
        room.update(1);
    }
}
