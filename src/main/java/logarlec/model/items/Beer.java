package logarlec.model.items;

import logarlec.model.effects.BeerEffect;
import logarlec.model.gameobjects.Teacher;

public class Beer extends Item {
	/**
	 * A Beer osztály use metódusa A metódus a BeerEffect-et adja hozzá a personhoz, majd
	 * eltávolítja a person inventory-jából a Beer-t
	 */
	@Override
	public void use() {
		useAgainst(null);
	}

	/**
	 * A Beer osztály useAgainst metódusa A metódus a BeerEffect-et adja hozzá a personhoz, majd
	 * eltávolítja a person inventory-jából a Sört-t
	 *
	 * @param target a tanár, aki ellen a Beer-t használják
	 */
	@Override
	public void useAgainst(Teacher target) {
		BeerEffect beerEffect = new BeerEffect();
		person.addEffect(beerEffect);
		person.removeItem(this);
		person.dropRandomItem();
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

	@Override
	public String toString() {
		return String.format("Beer <%d>\nPerson: <%d>\nRoom: <%d>\n", this.hashCode(),
				this.person.hashCode(), this.room.hashCode());
	}

}
