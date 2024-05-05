package logarlec.items;

import logarlec.gameobjects.Person;
import logarlec.gameobjects.Teacher;
import logarlec.gameobjects.Room;

public class Transistor extends Item {
	Transistor other;
	Room target;

	/**
	 * A Transistor osztály setTarget metódusa A metódus beállítja, hogy az adott Transistor melyik
	 * Room-ba mutasson
	 * 
	 * @param room - a beállítandó Room
	 */
	public void setTarget(Room room) {
		target = room;
	}

	/**
	 * A Transistor osztály use metódusa Ha a Transistor-nak van párja, de mindkettő nála van, akkor
	 * az egyiket leteszi és a másiknak beálítja a targetjét. Ha van már targetje, akkor a person-t
	 * átteszi a target Room-ba Ha sikerült átmenni a Room-ba, akkor a person-t kiveszi a jelenlegi
	 * Room-ból
	 */
	@Override
	public void use() {
		if (this.other == null)
			return;

		if (this.other != null && this.target != null) {
			Person person = this.person;
			person.dropItem(this);
			if (target.enter(person)) {
				room.leave(person);
			}
		} else if (this.other != null && this.target == null) {
			person.dropItem(this);
			other.setTarget(this.room);
		}
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

	/**
	 * A Transistor osztály useItem metódusa A metódus meghívja a link metódust a paraméterként
	 * kapott Item-re
	 * 
	 * @param item - a beállítandó Item
	 */
	@Override
	public void useItem(Item item) {
		item.link(this);
	}

	/**
	 * A Transistor osztály link metódusa A metódus beállítja a Transistor párját a paraméterként
	 * kapott Transistor-ra
	 * 
	 * @param other - a beállítandó Transistor
	 */
	@Override
	public void link(Transistor other) {
		other.setPair(this);
		this.other = other;
	}

	/**
	 * A Transistor osztály setPair metódusa A metódus beállítja a Transistor párját a param
	 * 
	 * @param other - a beállítandó Transistor
	 */
	public void setPair(Transistor other) {
		this.other = other;
	}

	@Override
	public String toString() {
		return String.format("Transistor <%d>\nPair: <%d>\nPerson: <%d>\nRoom: <%d>\nTarget room: <%d>\n",
				this.hashCode(), other.hashCode(), person.hashCode(), room.hashCode(), target.hashCode());
	}
}
