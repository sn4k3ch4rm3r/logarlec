package logarlec.items;

import logarlec.effects.MaskEffect;
import logarlec.gameobjects.Teacher;

public class Mask extends Item {
	MaskEffect maskEffect;

	/**
	 * A Mask osztály use metódusa
	 * A metódus a MaskEffect-et adja hozzá a personhoz
	 */
	@Override
	public void use() {
		maskEffect = new MaskEffect();
		person.addEffect(maskEffect);
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
		maskEffect = new MaskEffect();
		person.addEffect(maskEffect);
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
		room.addItem(this);
		person.removeEffect(maskEffect);
	}
}
