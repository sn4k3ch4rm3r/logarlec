package logarlec.items;

import logarlec.effects.BeerEffect;
import logarlec.gameobjects.Teacher;

public class Beer extends Item {

	@Override
	public void use() {
		BeerEffect beerEffect = new BeerEffect();
		person.addEffect(beerEffect);
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
