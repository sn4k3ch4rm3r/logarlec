package logarlec.util;

import logarlec.gameobjects.Person;
import logarlec.gameobjects.Room;
import logarlec.skeleton.Skeleton;

public class Door {
	private Room room1, room2; // can be used from room1 if one-way
	private boolean oneWay;

	public Door(Room room1, Room room2) {
		Skeleton.createObject("door",Door.class,room1,room2);
		this.room1 = room1;
		this.room2 = room2;
		Skeleton.logReturn(null);
	}

	public void use(Person person, Room from) {
		Skeleton.logFunctionCall(this,"use",person,from);
		if (!oneWay || from == room1) {
			Room to = from == room1 ? room2 : room1;
			if (to.enter(person)) {
				from.leave(person);
			}
		}
		Skeleton.logReturn(null);
	}

	public void move(Room from, Room to) {
		Skeleton.logFunctionCall(this,"move");
		if (from == room1) {
			room1 = to;
		}
		if (from == room2) {
			room2 = to;
		}
		Skeleton.logReturn(null);
	}

	public void hide() {
		Skeleton.logFunctionCall(this,"hide");
		Skeleton.logReturn(null);
	}

	public void show() {
		Skeleton.logFunctionCall(this,"show");
		Skeleton.logReturn(null);
	}
}
