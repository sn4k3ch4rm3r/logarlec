package logarlec.items;

import logarlec.gameobjects.Person;
import logarlec.gameobjects.Room;
import logarlec.gameobjects.Teacher;

public abstract class Item {
	Room room;
	Person person;

	Item(){}
	
	public abstract void use();

	public abstract void useAgainst(Teacher target);

	public abstract boolean usePassive();

	public abstract void useItem(Item item);

	public abstract void link(Transistor other);

	public void drop() {
		room.addItem(this);
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
