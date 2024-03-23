package logarlec.util;

import logarlec.gameobjects.Person;
import logarlec.gameobjects.Room;

public class Door {
	private Room room1, room2; // can be used from room1 if one-way
	private boolean oneWay;

	public Door(Room room1, Room room2) {
		Skeleton.createObject("door",Door.class,room1,room2);
		this.room1 = room1;
		this.room2 = room2;
		Skeleton.logReturn(void.class);
	}

	/**
	 * Ajtó használata: a személy átlép a másik szobába, ha teheti.
	 *
	 * @param person Az ajtót használó személy
	 * @param from A szoba ahol van a személy jelenleg
	 */
	public void use(Person person, Room from) {
		Skeleton.logFunctionCall(this,"use",person,from);
		if (!oneWay || from == room1) {
			Room to = from == room1 ? room2 : room1;
			if (to.enter(person)) {
				from.leave(person);
			}
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
		Skeleton.logFunctionCall(this,"move");
		if (from == room1) {
			room1 = to;
		}
		if (from == room2) {
			room2 = to;
		}
		Skeleton.logReturn(void.class);
	}

	/**
	 * Az ajtó nem lesz többé látható
	 */
	public void hide() {
		Skeleton.logFunctionCall(this,"hide");
		Skeleton.logReturn(void.class);
	}

	/**
	 * Az ajtó újra látható lesz
	 */
	public void show() {
		Skeleton.logFunctionCall(this,"show");
		Skeleton.logReturn(void.class);
	}
}
