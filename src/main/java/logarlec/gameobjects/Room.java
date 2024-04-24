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

	/**
	 * A szobába elférő emberek száma.
	 */
	private int capacity;

	/**
	 * A szobában ennyi ember fordult meg a takarítás óta.
	 */
	private int visitorsSinceClean;

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
		this.capacity = capacity;
	}

	/**
	 * Valaki kéri, hogy beléphet-e a szobába. Ha a szoba nincs tele, akkor belépteti a személyt.
	 * 
	 * @param person a személy, aki belépne a szobába
	 */
	public boolean enter(Person person) {
		if(people.size() < capacity){
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
		//ha a két szobának niincs közös ajtaja vagy a nagyobbik kevesebb mint a két szoba összes embere
		int capac = this.capacity + room.capacity;
		int peopleCount = this.people.size() + room.people.size();
		if (doors.stream().noneMatch(door -> room.doors.contains(door)) || peopleCount > capac) {
			return;
		}
	
		room.moveContents(this);
		this.capacity = this.capacity > room.capacity ? this.capacity : room.capacity;
	}

	/**
	 * A szoba kettévágása.
	 * 
	 * @return az új szoba
	 */
	public Room split() {
		/*
		Skeleton.logFunctionCall(this, "split");
		Room newRoom = Skeleton.createObject("newRoom", Room.class);
		Skeleton.createObject("door", Door.class, this, newRoom);
		Skeleton.logReturn(newRoom);
		return newRoom;*/

		Room newRoom = new Room();
		Door door = new Door(this, newRoom);
		
		for (Effect e : effects){
			newRoom.applyEffect(e);
		}

		for (Person p : people){
			if(Math.random() < 0.5){
				newRoom.enter(p);
			}
		}

		for (Item i : items){
			if(Math.random() < 0.5){
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
	 * 
	 * @param deltaTime az eltelt idő
	 */
	@Override
	public void update(double deltaTime) {
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
	public void addItem(Item item) {
		items.add(item);
		item.setRoom(this);
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
			door.use(person, this);
			if (!people.contains(person)) {
				break;
			}
		}
	}

	public void clean() {
		visitorsSinceClean = 0;
	}

	public boolean isClean() {
		if (visitorsSinceClean > 10){
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format("Room <%d>\nCapacity: %d\nDoors: <%d>\nEffects: <%d>\nItems: <%d>\nPeople: <%d>\n",
				this.hashCode(), capacity, doors.hashCode(), effects.hashCode(), items.hashCode(), people.hashCode());
	}
}
