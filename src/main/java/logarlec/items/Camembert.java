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
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'useAgainst'");
	}

	@Override
	public boolean usePassive() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'usePassive'");
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

}
