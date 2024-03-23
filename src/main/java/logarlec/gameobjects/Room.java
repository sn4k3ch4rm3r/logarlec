package logarlec.gameobjects;

import logarlec.effects.Effect;
import logarlec.items.Item;
import logarlec.util.Door;

import java.util.List;

/**
 * Egy játékban szereplő szoba.
 */
public class Room extends GameObject {

	/**
	 * A szoba kapacitása.
	 */
	private int capacity;

	/**
	 * A szoba jelenlegi lakói.
	 */
	private List<Person> people;

	/**
	 * A szoba ajtói.
	 */
	private List<Door> doors;

	/**
	 * A szobában lévő tárgyak.
	 */
	private List<Item> items;

	/**
	 * Valaki kéri, hogy beléphet-e a szobába. Ha a szoba nincs tele, akkor belépteti a személyt.
	 * @param person a személy, aki belépne a szobába
	 */
	public boolean enter(Person person) {
		//if the room is not full, add the person to the room and return true
		if (people.size() < capacity) {
			people.add(person);
			person.enterRoom(this);
			return true;
		}
		return false;
	}

	/**
	 * A személy távozik a szobából.
	 * @param person a személy, aki távozik
	 */
	public void leave(Person person) {
		people.remove(person);
	}

	/**
	 * Két szoba összevonása.
	 * @param room a másik szoba
	 */
	public void merge(Room room) {
	}

	/**
	 * A szoba kettévágása.
	 * @return az új szoba
	 */
	public Room split() {
		return null;
	}

	/**
	 * A szoba tartalmának áthelyezése egy másik szobába.
	 * @param room a másik szoba
	 */
	public void moveContents(Room room) {
		for(Person person : people) {
			room.enter(person);
		}
	}

	/**
	 * Ajtó hozzáadása a szobához.
	 * @param door az ajtó
	 */
	public void addDoor(Door door) {
		doors.add(door);
	}

	/**
	 * Ajtó eltávolítása a szobából.
	 * @param door az ajtó
	 */
	public void removeDoor(Door door) {
		doors.remove(door);
	}

	/**
	 * Az összes ajtó elrejtése.
	 */
	public void hideDoors() {
		for (Door door : doors) {
			door.hide();
		}
	}

	/**
	 * Az összes ajtó megjelenítése.
	 */
	public void showDoors() {
		for (Door door : doors) {
			door.show();
		}
	}

	/**
	 * A szoba frissítése.
	 * @param deltaTime az eltelt idő
	 */
	@Override
	public void update(double deltaTime) {
		for(Effect effect : effects) {
			effect.update(deltaTime);
		}
		for(Person person : people) {
			for(Effect effect : this.effects) {
				person.applyEffect(effect);
			}
			person.update(deltaTime);
		}
	}

	/**
	 * Tárgy hozzáadása a szobához.
	 * @param item a hozzáadandó tárgy
	 */
	@Override
	public void addItem(Item item) {
		items.add(item);
	}

	/**
	 * Tárgy eltávolítása a szobából.
	 * @param item a eltávolítandó tárgy
	 */
	@Override
	public void removeItem(Item item) {
		items.remove(item);
	}

	/**
	 * Hatás alkalmazása a szobára.
	 * @param effect a hatás
	 */
	@Override
	public void applyEffect(Effect effect) {
		effect.setHolder(this);
	}

	/**
	 * A szoba interakciója egy tanárral.
	 * @param teacher a tanár
	 */
	@Override
	public void interactTeacher(Teacher teacher) {
		for(Person person : people) {
			person.interactTeacher(teacher);
		}
	}
}
