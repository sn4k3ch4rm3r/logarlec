package logarlec.gameobjects;

import logarlec.effects.CleanEffect;
import logarlec.effects.Effect;
import logarlec.items.Item;
import logarlec.util.Door;
import java.util.LinkedList;
import java.util.List;
import logarlec.skeleton.Skeleton;

/**
 * Egy játékban szereplő szoba.
 */
public class Room extends GameObject {

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

	public Room() {
		people = new LinkedList<>();
		doors = new LinkedList<>();
		items = new LinkedList<>();
	}

	/**
	 * Konstruktor a szoba létrehozásához.
	 * 
	 * @param effects a szoba hatásai
	 * @param capacity a szoba kapacitása
	 */
	public Room(List<Effect> effects, int capacity) {
		for (Effect effect : effects) {
			this.effects.add(effect);
		}
		doors = new LinkedList<>();
		items = new LinkedList<>();
		people = new LinkedList<>();
	}

	/**
	 * Valaki kéri, hogy beléphet-e a szobába. Ha a szoba nincs tele, akkor belépteti a személyt.
	 * 
	 * @param person a személy, aki belépne a szobába
	 */
	public boolean enter(Person person) {
		Skeleton.logFunctionCall(this, "enter", person);
		if (Skeleton.getInput(Boolean.class, "Is there enough space in the room [true|false]: ")) {
			people.add(person);
			person.enterRoom(this);
			Skeleton.logReturn(true);
			return true;
		}
		Skeleton.logReturn(false);
		return false;
	}

	/**
	 * A személy távozik a szobából.
	 * 
	 * @param person a személy, aki távozik
	 */
	public void leave(Person person) {
		Skeleton.logFunctionCall(this, "leave", person);
		people.remove(person);
		Skeleton.logReturn(void.class);
	}

	/**
	 * Két szoba összevonása.
	 * 
	 * @param room a másik szoba
	 */
	public void merge(Room room) {
		Skeleton.logFunctionCall(this, "merge", room);
		room.moveContents(this);
		Skeleton.logReturn(void.class);
	}

	/**
	 * A szoba kettévágása.
	 * 
	 * @return az új szoba
	 */
	public Room split() {
		Skeleton.logFunctionCall(this, "split");
		Room newRoom = Skeleton.createObject("newRoom", Room.class);
		Skeleton.createObject("door", Door.class, this, newRoom);
		Skeleton.logReturn(newRoom);
		return newRoom;
	}

	/**
	 * A szoba tartalmának áthelyezése egy másik szobába.
	 * 
	 * @param room a másik szoba
	 */
	public void moveContents(Room room) {
		Skeleton.logFunctionCall(this, "moveContents", room);
		for (Person person : people) {
			room.enter(person);
		}
		for (Item item : items) {
			room.addItem(item);
		}
		for (Effect effect : effects) {
			room.addEffect(effect);
		}
		for (Door door : doors) {
			door.move(this, room);
		}
		Skeleton.logReturn(void.class);
	}

	/**
	 * Ajtó hozzáadása a szobához.
	 * 
	 * @param door az ajtó
	 */
	public void addDoor(Door door) {
		Skeleton.logFunctionCall(this, "addDoor", door);
		doors.add(door);
		Skeleton.logReturn(void.class);
	}

	/**
	 * Ajtó eltávolítása a szobából.
	 * 
	 * @param door az ajtó
	 */
	public void removeDoor(Door door) {
		Skeleton.logFunctionCall(this, "removeDoor", door);
		doors.remove(door);
		Skeleton.logReturn(void.class);
	}

	/**
	 * Az összes ajtó elrejtése.
	 */
	public void hideDoors() {
		Skeleton.logFunctionCall(this, "hideDoors");
		for (Door door : doors) {
			door.hide();
		}
		Skeleton.logReturn(void.class);
	}

	/**
	 * Az összes ajtó megjelenítése.
	 */
	public void showDoors() {
		Skeleton.logFunctionCall(this, "showDoors");
		for (Door door : doors) {
			door.show();
		}
		Skeleton.logReturn(void.class);
	}

	/**
	 * A szoba frissítése.
	 * 
	 * @param deltaTime az eltelt idő
	 */
	@Override
	public void update(double deltaTime) {
		Skeleton.logFunctionCall(this, "update", deltaTime);
		for (Effect effect : effects) {
			effect.update(deltaTime);
			effect.applyToRoom(this);
		}
		for (Person person : people) {
			for (Effect effect : this.effects) {
				person.applyEffect(effect);
			}
			person.update(deltaTime);
		}
		Skeleton.logReturn(void.class);
	}

	/**
	 * Tárgy hozzáadása a szobához.
	 * 
	 * @param item a hozzáadandó tárgy
	 */
	@Override
	public void addItem(Item item) {
		Skeleton.logFunctionCall(this, "addItem", item);
		items.add(item);
		item.setRoom(this);
		Skeleton.logReturn(void.class);
	}

	/**
	 * Tárgy eltávolítása a szobából.
	 * 
	 * @param item a eltávolítandó tárgy
	 */
	@Override
	public void removeItem(Item item) {
		Skeleton.logFunctionCall(this, "removeItem", item);
		items.remove(item);
		Skeleton.logReturn(void.class);
	}

	/**
	 * Hatás alkalmazása a szobára.
	 * 
	 * @param effect a hatás
	 */
	@Override
	public void applyEffect(Effect effect) {
		Skeleton.logFunctionCall(this, "applyEffect", effect);
		effect.setHolder(this);
		effects.add(effect);
	}

	/**
	 * A szoba interakciója egy tanárral.
	 * 
	 * @param teacher a tanár
	 */
	@Override
	public void interactTeacher(Teacher teacher) {
		Skeleton.logFunctionCall(this, "interactTeacher", teacher);
		for (Person person : people) {
			person.interactTeacher(teacher);
		}
		Skeleton.logReturn(void.class);
	}

	public void interactCleanEffect(CleanEffect effect) {
		Skeleton.logFunctionCall(this, "interactCleanEffect", effect);
		for (Effect e : effects) {
			e.interactCleanEffect(effect);
		}
		Skeleton.logReturn(void.class);
	}

	public void getOut(Person person) {
		Skeleton.logFunctionCall(this, "getOut", person);
		for (Door door : doors) {
			door.use(person, this);
			if (!people.contains(person)) {
				break;
			}
		}
		Skeleton.logReturn(void.class);
	}

	public void clean() {
		Skeleton.logFunctionCall(this, "clean");
		// Reset visitorsSinceClean
		Skeleton.logReturn(void.class);
	}

	public boolean isClean() {
		Skeleton.logFunctionCall(this, "isClean");
		boolean clean = Skeleton.getInput(Boolean.class, "Is the room clean [true|false]: ");
		Skeleton.logReturn(clean);
		return clean;
	}
}
