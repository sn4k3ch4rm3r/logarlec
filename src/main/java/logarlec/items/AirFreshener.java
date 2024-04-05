package logarlec.items;

import logarlec.effects.CleanEffect;
import logarlec.gameobjects.Teacher;
import logarlec.skeleton.Skeleton;

public class AirFreshener extends Item {
    @Override
    public void use() {
        Skeleton.logFunctionCall(this, "use");
        CleanEffect cleanEffect = Skeleton.createObject("cleanEffect", CleanEffect.class);
        room.addEffect(cleanEffect);
        room.removeItem(this);
        Skeleton.logReturn(void.class);
    }

    @Override
    public void useAgainst(Teacher target) {

    }

    @Override
    public boolean usePassive() {
        return false;
    }

    @Override
    public void useItem(Item item) {

    }

    @Override
    public void link(Transistor other) {

    }
}
