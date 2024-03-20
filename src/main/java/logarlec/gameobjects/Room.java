package logarlec.gameobjects;

import logarlec.effects.Effect;
import logarlec.items.Item;
import logarlec.util.Door;

import java.util.List;

public class Room extends GameObject {

	int capacity;

	int personCount;
	List<Person> people;

	List<Door> doors;
	List<Item> items;

	//Person trying to enter the room. Gets rejected if the room is full.
	public boolean enter(Person person) {
		//if the room is not full, add the person to the room and return true
		if (personCount < capacity) {
			people.add(person);
			personCount++;
			return true;
		}
		return false;
	}

	//Person leaving the room
	public void leave(Person person) {
		people.remove(person);
		personCount--;
	}

	public void merge(Room room) {
	}

	public Room split() {
		return null;
	}

	public void moveContents(Room room) {
		room.people.addAll(people);
		room.personCount += personCount;
	}

	public void addDoor(Door door) {
		doors.add(door);
	}

	public void removeDoor(Door door) {
		doors.remove(door);
	}

	public void hideDoors() {
		for (Door door : doors) {
			door.hide();
		}
	}

	public void showDoors() {
		for (Door door : doors) {
			door.show();
		}
	}

	@Override
	public void update(double deltaTime) {
		for(Person person : people) {
			person.update(deltaTime);
		}

		for(Effect effect : effects) {
			effect.update(deltaTime);
		}
	}

	@Override
	public void addItem(Item item) {
		items.add(item);
	}

	@Override
	public void removeItem(Item item) {
		items.remove(item);
	}

	@Override
	public void applyEffect(Effect effect) {
		effects.add(effect);
	}

	@Override
	public void interactTeacher(Teacher teacher) {
		for(Person person : people) {
			person.interactTeacher(teacher);
		}
	}
}
