package logarlec.util;

import logarlec.gameobjects.Person;
import logarlec.gameobjects.Room;

public class Door {
	private Room room1, room2; // can be used from room1 if one-way
	private boolean oneWay;
	public void use(Person person, Room from) {
		if (!oneWay || from == room1) {
			Room to = from == room1 ? room2 : room1;
			if (to.enter(person)) {
				from.leave(person);
			}
		}
	}

	public void move(Room from, Room to) {
		if (from == room1) {
			room1 = to;
		}
		if (from == room2) {
			room2 = to;
		}
	}

	public void hide() {}

	public void show() {}
}
