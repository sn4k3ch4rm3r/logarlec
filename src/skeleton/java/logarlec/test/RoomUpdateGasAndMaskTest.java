package logarlec.skeleton;

import logarlec.effects.GasEffect;
import logarlec.effects.MaskEffect;
import logarlec.gameobjects.Room;
import logarlec.gameobjects.Student;

public class RoomUpdateGasAndMaskTest extends TestCase {
    Room room;
    Student student;
    GasEffect gasEffect;
    MaskEffect maskEffect;
    public RoomUpdateGasAndMaskTest() {
        super("Room: update gas and mask");
    }

    @Override
    public void init() {
        room = new Room();
        student = new Student();
        gasEffect = new GasEffect();
        maskEffect = new MaskEffect();
        room.enter(student);
        room.addEffect(gasEffect);
        room.addEffect(maskEffect);
    }

    @Override
    public void run() {
        room.update(1);
    }
}
