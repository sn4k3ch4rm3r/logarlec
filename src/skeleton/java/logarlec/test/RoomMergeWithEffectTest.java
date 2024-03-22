package logarlec.test;

import logarlec.effects.GasEffect;
import logarlec.gameobjects.Room;
import logarlec.skeleton.Skeleton;
import logarlec.util.Door;

public class RoomMergeWithEffectTest extends TestCase {
    Room room1;
    Room room2;
    Door door;
    GasEffect gasEffect;
    public RoomMergeWithEffectTest() {
        super("Room: merge with effect");
    }

    @Override
    public void init() {
        room1 = Skeleton.createObject("room1", Room.class);
        room2 = Skeleton.createObject("room2", Room.class);
        door = Skeleton.createObject("door", Door.class, room1, room2);
        gasEffect = Skeleton.createObject("gasEffect", GasEffect.class);
        room2.addEffect(gasEffect);
    }

    @Override
    public void run() {
        room1.merge(room2);
    }
}
