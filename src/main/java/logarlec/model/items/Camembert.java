package logarlec.model.items;

import logarlec.model.effects.GasEffect;
import logarlec.model.gameobjects.Teacher;

/**
 * A Camembert osztály reprezentálja a játékban a Camembert-t
 */
public class Camembert extends Item {
	/**
	 * A Camembert osztály use metódusa A metódus a GasEffect-et adja hozzá a room-hoz, majd
	 * eltávolítja a person inventory-jából a Camembert-t
	 */
	@Override
	public void use() {
		GasEffect gasEffect = new GasEffect();
		room.addEffect(gasEffect);
		person.removeItem(this);
		room.removeItem(this);
	}

	/**
	 * A Camembert osztály useAgainst metódusa A metódus a GasEffect-et adja hozzá a room-hoz, majd
	 * eltávolítja a person inventory-jából a Camembert-t
	 *
	 * @param target a tanár, aki ellen a Camembert-t használják
	 */
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

	@Override
	public String toString() {
		return String.format("Camembert <%d>\nPerson: <%d>\nRoom: <%d>\n", this.hashCode(),
				this.person.hashCode(), this.room.hashCode());
	}

}
