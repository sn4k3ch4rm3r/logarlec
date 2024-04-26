package logarlec.items;

import logarlec.effects.BeerEffect;
import logarlec.gameobjects.Teacher;
import logarlec.prototype.Prototype;

public class Beer extends Item {
	/**
	 * A Beer osztály use metódusa A metódus a BeerEffect-et adja hozzá a personhoz, majd
	 * eltávolítja a person inventory-jából a Beer-t
	 */
	@Override
	public void use() {
		useAgainst(null);
	}

	@Override
	public void useAgainst(Teacher target) {
		BeerEffect beerEffect = new BeerEffect();
		String effectName = beerEffect.getClass().getSimpleName();
		effectName = effectName.substring(0, 1).toLowerCase() + effectName.substring(1);
		int i = 0;
		while (Prototype.getObject(effectName + (i == 0 ? "" : i)) != null) {
			i++;
		}
		Prototype.addObject(effectName + (i == 0 ? "" : i), beerEffect);
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
		return String.format("Beer <%d>\nPerson: <%d>\nRoom: <%d>\n",
				this.hashCode(), this.person.hashCode(), this.room.hashCode());
	}
	
}
