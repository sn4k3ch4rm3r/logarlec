package logarlec.items;

import logarlec.effects.BeerEffect;
import logarlec.gameobjects.Teacher;

public class Beer extends Item {
	
	/**
	 * A Beer osztály use metódusa
	 * A metódus a BeerEffect-et adja hozzá a personhoz, majd eltávolítja a person inventory-jából a Beer-t
	 */
	@Override
	public void use() {
		BeerEffect beerEffect = new BeerEffect();
		person.addEffect(beerEffect);
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
