package logarlec.items;

import logarlec.gameobjects.Teacher;
import logarlec.gameobjects.Room;

public class Transistor extends Item {
	Transistor other;
	Room target;

	/**
	 * A Transistor osztály setTarget metódusa
	 * A metódus beállítja, hogy az adott Transistor melyik Room-ba mutasson
	 * @param room - a beállítandó Room
	 */
	void setTarget(Room room){
		target = room;
	}

	/**
	 * A Transistor osztály use metódusa
	 * Ha a Transistor-nak van párja, de mindkettő nála van, akkor az egyiket leteszi és a másiknak beálítja a targetjét.
	 * Ha van már targetje, akkor a person-t átteszi a target Room-ba
	 * Ha sikerült átmenni a Room-ba, akkor a person-t kiveszi a jelenlegi Room-ból
	 */	
	@Override
	public void use() {
		if(other != null){
			person.dropItem(this);
			other.setTarget(room);
		}
		else if(target != null){
			person.dropItem(this);
			boolean entered = target.enter(person);
			if(entered){
				room.leave(person);
			}
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
	 * A Transistor osztály useItem metódusa
	 * A metódus meghívja a link metódust a paraméterként kapott Item-re
	 * @param item - a beállítandó Item
	 */
	@Override
	public void useItem(Item item) {
		other.link(this);
	}

	/**
	 * A Transistor osztály link metódusa
	 * A metódus beállítja a Transistor párját a paraméterként kapott Transistor-ra
	 * @param other - a beállítandó Transistor
	 */
	@Override
	public void link(Transistor other) {
		other.setPair(this);
		this.other = other;
	}

	/**
	 * A Transistor osztály setPair metódusa
	 * A metódus beállítja a Transistor párját a param
	 * @param other - a beállítandó Transistor
	 */
	public void setPair(Transistor other) {
		this.other = other;
	}

	/**
	 * A Transistor osztály drop metódusa
	 * A metódus a room addItem metódusát hívja meg a paraméterként kapott Item-mel
	 */
	@Override
	public void drop(){
		room.addItem(this);	
	}
}
