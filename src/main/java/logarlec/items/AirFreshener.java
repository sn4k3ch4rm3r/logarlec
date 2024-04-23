package logarlec.items;

import logarlec.effects.CleanEffect;
import logarlec.gameobjects.Teacher;
import logarlec.skeleton.Skeleton;

public class AirFreshener extends Item {
    @Override
    public void use() {
        CleanEffect cleanEffect = new CleanEffect();
        room.addEffect(cleanEffect);
        room.removeItem(this);
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

    @Override
	public String toString() {
		return String.format("AirFreshner <%d>\nPerson: %b\nRoom: %b\n",
				this.hashCode(), this.person, this.room);
	}
}
