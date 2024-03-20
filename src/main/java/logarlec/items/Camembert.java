package logarlec.items;

import logarlec.effects.GasEffect;
import logarlec.gameobjects.Teacher;

public class Camembert extends Item {

	@Override
	public void use() {
		GasEffect gasEffect = new GasEffect();
		room.addEffect(gasEffect);
		person.removeItem(this);
	}

	@Override
	public void useAgainst(Teacher target) {
		// Do nothing
	}

	@Override
	public boolean usePassive() {
		// Do nothing
		return false;
	}

	@Override
	public void useItem(Item item) {
		// Do nothing
	}

	@Override
	public void link(Transistor other) {
		// Do nothing
	}

}
