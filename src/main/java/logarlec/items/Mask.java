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
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'useAgainst'");
	}

	@Override
	public boolean usePassive() {
		maskEffect = new MaskEffect();
		person.addEffect(maskEffect);
		return true;
	}

	@Override
	public void useItem(Item item) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'useItem'");
	} 

	@Override
	public void link(Transistor other) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'link'");
	}

	@Override
	public void drop(){
		room.addItem(this);
		person.removeEffect(maskEffect);
	}
}
