package logarlec.skeleton;

import logarlec.effects.RagEffect;
import logarlec.gameobjects.Room;
import logarlec.gameobjects.Teacher;

public class RoomUpdateRagEffectTest extends TestCase {
    Room room;
    Teacher teacher;
    RagEffect ragEffect;
    public RoomUpdateRagEffectTest() {
        super("Room: update rag effect");
    }

    @Override
    public void init() {
        room = new Room();
        teacher = new Teacher();
        ragEffect = new RagEffect();
        room.enter(teacher);
        room.addEffect(ragEffect);
    }

    @Override
    public void run() {
        room.update(1);
    }
}
