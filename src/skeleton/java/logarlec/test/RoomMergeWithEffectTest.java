package logarlec.skeleton;

import logarlec.effects.GasEffect;
import logarlec.gameobjects.Room;
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
        room1 = new Room();
        room2 = new Room();
        door = new Door(room1, room2);
        gasEffect = new GasEffect();
        room2.addEffect(gasEffect);
    }

    @Override
    public void run() {
        room1.merge(room2);
    }
}
