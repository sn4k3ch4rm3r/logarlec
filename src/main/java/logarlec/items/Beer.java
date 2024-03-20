package logarlec.items;

import logarlec.effects.BeerEffect;
import logarlec.gameobjects.Teacher;

public class Beer extends Item {
	BeerEffect beerEffect;

	@Override
	public void use() {
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

	@Override
	public void drop(){
		room.addItem(this);
		person.removeEffect(beerEffect);
	}
}
