package logarlec.items;

import logarlec.gameobjects.Person;
import logarlec.gameobjects.Room;
import logarlec.gameobjects.Teacher;

public abstract class Item {
	
	protected
		Room room;
		Person person;

	/**
	 * Az Item osztály konstruktora
	 */
	public Item(){}
	
	public abstract void use();

	public abstract void useAgainst(Teacher target);

	public abstract boolean usePassive();

	public abstract void useItem(Item item);

	public abstract void link(Transistor other);

	/**
	 * Az Item osztály drop metódusa
	 * A metódus a room addItem metódusát hívja meg a paraméterként kapott Item-mel
	 */
	public void drop() {
		room.addItem(this);
	}

	/**
	 * Az Item osztály setRoom metódusa
	 * A metódus beállítja, hogy az adott Item melyik Room-ban található
	 * @param room - a beállítandó Room
	 */

	public void setRoom(Room room) {
		this.room = room;
	}

	/**
	 * Az Item osztály setPerson metódusa
	 * A metódus beállítja, hogy az adott Item-et melyik Person inventory-jában tároljuk	
	 * @param person - a beállítandó Person
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
}
