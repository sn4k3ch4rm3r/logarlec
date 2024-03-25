package logarlec.items;

import logarlec.gameobjects.Teacher;
import logarlec.skeleton.Skeleton;
import logarlec.gameobjects.Person;
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
		Skeleton.logFunctionCall(this, "setTarget", room);
		target = room;
		Skeleton.logReturn(void.class);
	}

	/**
	 * A Transistor osztály use metódusa Ha a Transistor-nak van párja, de mindkettő nála van, akkor
	 * az egyiket leteszi és a másiknak beálítja a targetjét. Ha van már targetje, akkor a person-t
	 * átteszi a target Room-ba Ha sikerült átmenni a Room-ba, akkor a person-t kiveszi a jelenlegi
	 * Room-ból
	 */
	@Override
	public void use() {
		Skeleton.logFunctionCall(this, "use");
		if (Skeleton.getInput(Boolean.class, "Is the transistor active [true|false]: ")) {
			Person p = person;
			person.dropItem(this);
			boolean entered = target.enter(p);
			if (entered) {
				room.leave(p);
			}
		} else if (Skeleton.getInput(Boolean.class,
				"Does the transistor have a pair [true|false]: ")) {
			person.dropItem(this);
			other.setTarget(room);
		}
		Skeleton.logReturn(void.class);
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
		Skeleton.logFunctionCall(this, "useItem", item);
		item.link(this);
		Skeleton.logReturn(void.class);
	}

	/**
	 * A Transistor osztály link metódusa A metódus beállítja a Transistor párját a paraméterként
	 * kapott Transistor-ra
	 * 
	 * @param other - a beállítandó Transistor
	 */
	@Override
	public void link(Transistor other) {
		Skeleton.logFunctionCall(this, "link", other);
		other.setPair(this);
		this.other = other;
		Skeleton.logReturn(void.class);
	}

	/**
	 * A Transistor osztály setPair metódusa A metódus beállítja a Transistor párját a param
	 * 
	 * @param other - a beállítandó Transistor
	 */
	public void setPair(Transistor other) {
		Skeleton.logFunctionCall(this, "setPair", other);
		this.other = other;
		Skeleton.logReturn(void.class);
	}
}
