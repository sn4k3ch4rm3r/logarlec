package logarlec.items;

import logarlec.effects.MaskEffect;
import logarlec.gameobjects.Teacher;
import logarlec.skeleton.Skeleton;

public class Mask extends Item {
	MaskEffect maskEffect;

	/**
	 * A Mask osztály use metódusa
	 * A metódus a MaskEffect-et adja hozzá a personhoz
	 */
	@Override
	public void use() {
		Skeleton.logFunctionCall(this, "use");
		maskEffect = new MaskEffect();
		person.addEffect(maskEffect);
		Skeleton.logReturn(void.class);
	}

	@Override
	public void useAgainst(Teacher target) {
		// Do nothing
	}

	/**
	 * A Mask osztály usePassive metódusa
	 * A metódus a MaskEffect-et adja hozzá a personhoz
	 * @return true
	 */
	@Override
	public boolean usePassive() {
		Skeleton.logFunctionCall(this, "usePassive");
		maskEffect = new MaskEffect();
		person.addEffect(maskEffect);
		
		Skeleton.logReturn(true);
		return true;
	}

	@Override
	public void useItem(Item item) {
		// Do nothing
	} 

	@Override
	public void link(Transistor other) {
		// Do nothing
	}

	@Override
	public void drop(){
		Skeleton.logFunctionCall(this, "drop");
		room.addItem(this);
		person.removeEffect(maskEffect);
		setPerson(null);
		Skeleton.logReturn(void.class);
	}
}
