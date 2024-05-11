package logarlec.model.gameobjects;

import logarlec.model.effects.CleanEffect;
import logarlec.model.effects.Effect;
import logarlec.model.items.Item;
import logarlec.model.util.Door;
import logarlec.prototype.Prototype;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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

	/**
	 * A szobába elférő emberek száma.
	 */
	private int capacity;

	/**
	 * A szobában ennyi ember fordult meg a takarítás óta.
	 */
	private int visitorsSinceClean;

	/**
	 * Elátkozott-e a szoba.
	 */
	private boolean cursed;
	private boolean hidden;
	private Random random = new Random();

	public Room() {
		this(4);
	}

	public Room(Integer capacity) {
		people = new LinkedList<>();
		doors = new LinkedList<>();
		items = new LinkedList<>();
		this.capacity = capacity;
		visitorsSinceClean = 0;
		cursed = random.nextDouble() < 0.1;
		hidden = false;
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
		this.capacity = capacity;
	}

	/**
	 * Valaki kéri, hogy beléphet-e a szobába. Ha a szoba nincs tele, akkor belépteti a személyt.
	 * 
	 * @param person a személy, aki belépne a szobába
	 */
	public boolean enter(Person person) {
		if (people.size() < capacity) {
			people.add(person);
			person.enterRoom(this);
			return true;
		}
		return false;
	}

	/**
	 * A személy távozik a szobából.
	 * 
	 * @param person a személy, aki távozik
	 */
	public void leave(Person person) {
		people.remove(person);
	}

	/**
	 * Két szoba összevonása.
	 * 
	 * @param room a másik szoba
	 */
	public void merge(Room room) {
		int newCapacity = capacity > room.capacity ? capacity : room.capacity;
		int peopleCount = this.people.size() + room.people.size();
		// Csak akkor tud össze olvadni, ha van közös ajtó, és elegendő kapacitás
		if (doors.stream().noneMatch(door -> room.doors.contains(door))
				|| peopleCount > newCapacity) {
			return;
		}

		room.moveContents(this);
		this.capacity = newCapacity;
	}

	/**
	 * A szoba kettévágása.
	 * 
	 * @return az új szoba
	 */
	public Room split() {
		Room newRoom = new Room();
		String name = Prototype.getObjectName(this.hashCode());
		Prototype.addObject(name + "_S1", newRoom);
		Door door = new Door(this, newRoom);
		StringBuilder doorName = new StringBuilder("door");
		int counter = 0;
		while (Prototype
				.getObject(doorName + (counter == 0 ? "" : Integer.toString(counter))) != null) {
			counter++;
		}
		Prototype.addObject(doorName + (counter == 0 ? "" : Integer.toString(counter)), door);

		for (Effect e : effects) {
			newRoom.applyEffect(e);
		}

		for (Person p : people) {
			if (Prototype.random.nextDouble() < 0.5) {
				newRoom.enter(p);
			}
		}

		for (Item i : items) {
			if (Prototype.random.nextDouble() < 0.5) {
				newRoom.addItem(i);
			}
		}
		return newRoom;
	}

	/**
	 * A szoba tartalmának áthelyezése egy másik szobába.
	 * 
	 * @param room a másik szoba
	 */
	public void moveContents(Room room) {
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
	}

	/**
	 * Ajtó hozzáadása a szobához.
	 * 
	 * @param door az ajtó
	 */
	public void addDoor(Door door) {
		doors.add(door);
	}

	/**
	 * Ajtó eltávolítása a szobából.
	 * 
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
		hidden = true;
	}

	/**
	 * Az összes ajtó megjelenítése.
	 */
	public void showDoors() {
		for (Door door : doors) {
			door.show();
		}
		hidden = false;
	}

	/**
	 * A szoba frissítése.
	 * 
	 * @param deltaTime az eltelt idő
	 */
	@Override
	public void update(double deltaTime) {
		if (cursed && random.nextDouble() < 0.05) {
			if (hidden)
				showDoors();
			else
				hideDoors();
		}
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
	}

	/**
	 * Tárgy hozzáadása a szobához.
	 * 
	 * @param item a hozzáadandó tárgy
	 */
	@Override
	public boolean addItem(Item item) {
		items.add(item);
		item.setRoom(this);
		return true;
	}

	/**
	 * Tárgy eltávolítása a szobából.
	 * 
	 * @param item a eltávolítandó tárgy
	 */
	@Override
	public void removeItem(Item item) {
		items.remove(item);
	}

	/**
	 * Hatás alkalmazása a szobára.
	 * 
	 * @param effect a hatás
	 */
	@Override
	public void applyEffect(Effect effect) {
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
		try {
			Prototype.out.write(
					String.format("<%d> attacked everyone.\n", teacher.hashCode()).getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Person person : people) {
			person.interactTeacher(teacher);
		}
	}

	public void interactCleanEffect(CleanEffect effect) {
		for (Effect e : effects) {
			e.interactCleanEffect(effect);
		}
	}

	public void getOut(Person person) {
		for (Door door : doors) {
			door.use(person);
			if (!people.contains(person)) {
				break;
			}
		}
	}

	public void clean() {
		visitorsSinceClean = 0;
	}

	public boolean isClean() {
		if (visitorsSinceClean > 10) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder doorsString = new StringBuilder();
		for (Door door : this.doors) {
			doorsString.append("<").append(door.hashCode()).append("> ");
		}
		StringBuilder effectsString = new StringBuilder();
		for (Effect effect : this.effects) {
			effectsString.append("<").append(effect.hashCode()).append("> ");
		}
		StringBuilder itemsString = new StringBuilder();
		for (Item item : this.items) {
			itemsString.append("<").append(item.hashCode()).append("> ");
		}
		StringBuilder peopleString = new StringBuilder();
		for (Person person : this.people) {
			peopleString.append("<").append(person.hashCode()).append("> ");
		}
		return String.format(
				"Room <%d>\nCapacity: %d\nDoors: %s\nEffects: %s\nItems: %s\nPeople: %s\n",
				this.hashCode(), capacity, doorsString, effectsString, itemsString, peopleString);
	}
}
