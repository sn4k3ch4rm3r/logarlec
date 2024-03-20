package logarlec.items;

import logarlec.effects.MaskEffect;
import logarlec.gameobjects.Teacher;

public class Mask extends Item {
	MaskEffect maskEffect;

	@Override
	public void use() {
		maskEffect = new MaskEffect();
		person.addEffect(maskEffect);
	}

	@Override
	public void useAgainst(Teacher target) {
		// Do nothing
	}

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
