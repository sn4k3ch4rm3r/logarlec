package logarlec.items;

import logarlec.effects.GasEffect;
import logarlec.gameobjects.Teacher;
import logarlec.skeleton.Skeleton;

public class Camembert extends Item {
	/**
	 * A Camembert osztály use metódusa A metódus a GasEffect-et adja hozzá a room-hoz, majd
	 * eltávolítja a person inventory-jából a Camembert-t
	 */
	@Override
	public void use() {
		Skeleton.logFunctionCall(this, "use");
		GasEffect gasEffect = Skeleton.createObject("gasEffect", GasEffect.class);
		room.addEffect(gasEffect);
		person.removeItem(this);
		Skeleton.logReturn(void.class);
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
