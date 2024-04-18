package logarlec.util;

import logarlec.skeleton.Skeleton;

import logarlec.gameobjects.Person;
import logarlec.gameobjects.Room;

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
	 * Ajtó használata: a személy átlép a másik szobába, ha teheti.
	 * Ha az ajtó egyirányú, akkor csak az ajtó egyik végénél lehet használni.
	 * Ha az ajtó rejtett, akkor nem lehet használni.
	 * @param person Az ajtót használó személy
	 * @param from A szoba ahol van a személy jelenleg
	 */
	public void use(Person person, Room from) {
		/*
		Skeleton.logFunctionCall(this, "use", person, from);
		if (Skeleton.getInput(Boolean.class, "Is this the correct direction [true|false]: ")) {
			Room to = from == room1 ? room2 : room1;
			if (to.enter(person)) {
				from.leave(person);
			}
		}
		Skeleton.logReturn(void.class);*/

		Skeleton.logFunctionCall(this, "use", person, from);
		if(hidden)
			return;
		else if(oneWay && from != this.from)
			return;
		
		else{
			Room to = from == this.from ? this.to : this.from;
			if(to.enter(person)){
				from.leave(person);
			}
			return;
		}
		Skeleton.logReturn(void.class);
	}

	/**
	 * Az ajtó egy végét egy szobáról egy másikra helyezünk
	 *
	 * @param to A szoba, ahol újonnan megtalálható lesz az ajtó
	 * @param from A szoba, ahol eddig megtalálható volt az ajtó
	 */
	public void move(Room from, Room to) {
		Skeleton.logFunctionCall(this, "move", from, to);
		if (to == this.from || to == this.to) {
			to.removeDoor(this);
		} else {
			from.removeDoor(this);
			if (from == this.from) {
				this.from = to;
				this.to.addDoor(this);
			} else if (from == this.to) {
				this.to = to;
				this.to.addDoor(this);
			}
		}
		Skeleton.logReturn(void.class);
	}

	/**
	 * Az ajtó nem lesz többé látható
	 */
	public void hide() {
		Skeleton.logFunctionCall(this, "hide");
		hidden = true;
		Skeleton.logReturn(void.class);
	}

	/**
	 * Az ajtó újra látható lesz
	 */
	public void show() {
		Skeleton.logFunctionCall(this, "show");
		hidden = false;
		Skeleton.logReturn(void.class);
	}

	/**
	 * Beállítja az ajtót egyirányúnak vagy kétirányúnak
	 * @param oneWay
	 */
	public void setOneWay(boolean oneWay) {
		Skeleton.logFunctionCall(this, "setOneWay", oneWay);
		this.oneWay = oneWay;
		Skeleton.logReturn(void.class);
	}
}
