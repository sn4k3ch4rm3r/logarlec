package logarlec.test;

import logarlec.model.effects.CleanEffect;
import logarlec.model.effects.GasEffect;
import logarlec.model.gameobjects.Room;
import logarlec.skeleton.Skeleton;

public class RoomUpdateCleanEffectTest extends TestCase {
    Room room;
    CleanEffect cleanEffect;
    GasEffect gasEffect;

    /**
     * Konstruktor, amely beállítja a teszteset nevét
     */
    public RoomUpdateCleanEffectTest() {
        super("Room: update clean effect");
    }

    @Override
    public void init() {
        room = Skeleton.createObject("room", Room.class);
        cleanEffect = Skeleton.createObject("cleanEffect", CleanEffect.class);
        room.addEffect(cleanEffect);
        gasEffect = Skeleton.createObject("gasEffect", GasEffect.class);
        room.addEffect(gasEffect);
    }

    @Override
    public void run() {
        room.update(1);
    }
}
