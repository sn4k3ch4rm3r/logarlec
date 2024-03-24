package logarlec.test;

import logarlec.effects.RagEffect;
import logarlec.gameobjects.Room;
import logarlec.gameobjects.Teacher;
import logarlec.skeleton.Skeleton;

public class RoomUpdateRagEffectTest extends TestCase {
    Room room;
    Teacher teacher;
    RagEffect ragEffect;
    public RoomUpdateRagEffectTest() {
        super("Room: update rag effect");
    }

    @Override
    public void init() {
        room = Skeleton.createObject("room", Room.class);
        teacher = Skeleton.createObject("teacher", Teacher.class);
        ragEffect = Skeleton.createObject("ragEffect", RagEffect.class);
        room.enter(teacher);
        room.addEffect(ragEffect);
    }

    @Override
    public void run() {
        room.update(1);
    }
}
