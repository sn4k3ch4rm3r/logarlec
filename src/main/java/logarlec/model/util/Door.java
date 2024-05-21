package logarlec.model.util;

import logarlec.model.gameobjects.Person;
import logarlec.model.gameobjects.Room;

/**
 * Az ajtókat reprezentáló osztály.
 */
public class Door {
	private Room from, to;
	private boolean oneWay;
	private boolean hidden;

	public Door(Room room1, Room room2) {
		from = room1;
		to = room2;

		room1.addDoor(this);
		room2.addDoor(this);
		oneWay = false;
	}

	/**
	 * Ajtó használata: a személy átlép a másik szobába, ha teheti. Ha az ajtó egyirányú, akkor csak
	 * az ajtó egyik végénél lehet használni. Ha az ajtó rejtett, akkor nem lehet használni.
	 * 
	 * @param person Az ajtót használó személy
	 * @return a személy átlép-e az ajtón
	 */
	public boolean use(Person person) {
		Room from = person.getCurrentRoom();
		if (!hidden && !(oneWay && from != this.from)) {
			Room roomToEnter = from == this.from ? this.to : this.from;
			if (roomToEnter.enter(person)) {
				from.leave(person);
				return true;
			}
		}
		return false;
	}

	/**
	 * Az ajtó egy végét egy szobáról egy másikra helyezünk
	 *
	 * @param to A szoba, ahol újonnan megtalálható lesz az ajtó
	 * @param from A szoba, ahol eddig megtalálható volt az ajtó
	 */
	public void move(Room from, Room to) {
		if (to == this.from || to == this.to) {
			to.removeDoor(this);
		}
		else {
			from.removeDoor(this);
			if (from == this.from) {
				this.from = to;
				this.to.addDoor(this);
			}
			else if (from == this.to) {
				this.to = to;
				this.to.addDoor(this);
			}
		}
	}

	/**
	 * Az ajtó nem lesz többé látható
	 */
	public void hide() {
		hidden = true;
	}

	/**
	 * Az ajtó újra látható lesz
	 */
	public void show() {
		hidden = false;
	}

	/**
	 * Beállítja az ajtót egyirányúnak vagy kétirányúnak
	 * 
	 * @param oneWay
	 */
	public void setOneWay(boolean oneWay) {
		this.oneWay = oneWay;
	}

	public boolean isOneWay() {
		return oneWay;
	}

	public Room getFromRoom() {
		return from;
	}

	public Room getToRoom() {
		return to;
	}

	public boolean isHidden() {
		return hidden;
	}

	@Override
	public String toString() {
		return String.format("Door <%d>\nHidden: %b\nOne-way: %b\nRoom 1: <%d>\nRoom 2: <%d>",
				this.hashCode(), hidden, oneWay, from.hashCode(), to.hashCode());
	}
}
