package logarlec.test;

import logarlec.model.effects.GasEffect;
import logarlec.model.effects.MaskEffect;
import logarlec.model.gameobjects.Room;
import logarlec.model.gameobjects.Student;
import logarlec.skeleton.Skeleton;

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
        room = Skeleton.createObject("room", Room.class);
        student = Skeleton.createObject("student", Student.class);
        gasEffect = Skeleton.createObject("gasEffect", GasEffect.class);
        maskEffect = Skeleton.createObject("maskEffect", MaskEffect.class);
        room.enter(student);
        room.addEffect(gasEffect);
        student.addEffect(maskEffect);
    }

    @Override
    public void run() {
        room.update(1);
    }
}
