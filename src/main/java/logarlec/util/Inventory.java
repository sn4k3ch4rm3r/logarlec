package logarlec.util;

import logarlec.skeleton.Skeleton;

import logarlec.gameobjects.Teacher;
import logarlec.items.Item;
import logarlec.gameobjects.Room;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	private List<Item> items = new ArrayList<>();

	/**
	 * Tárgy hozzáadása a felszereléshez, ha kevesebb, mint 5 van benne.
	 *
	 * @param item Hozzáadandó tárgy.
	 */
	public boolean add(Item item) {
		Skeleton.logFunctionCall(this, "add", item);
		if (Skeleton.getInput(Boolean.class, "Can more items fit the inventory [true|false]: ")) {
			items.add(item);
			Skeleton.logReturn(true);
			return true;
		}
		Skeleton.logReturn(false);
		return false;
	}

	/**
	 * Tárgy eltávolítása a felszerelésből, ha benne van.
	 *
	 * @param item Eltávolítandó tárgy.
	 */
	public void remove(Item item) {
		Skeleton.logFunctionCall(this, "remove", item);
		items.remove(item);
		Skeleton.logReturn(void.class);
	}

	/**
	 * A tárgyak értesítése, hogy más szobába kerültek.
	 *
	 * @param room A szoba, ahova kerültek.
	 */
	public void setRoom(Room room) {
		Skeleton.logFunctionCall(this, "setRoom", room);
		items.forEach(i -> i.setRoom(room));
		Skeleton.logReturn(void.class);
	}

	/**
	 * A tárgyak értesítése, hogy a felszerelés tulajdonosát megtámadta egy oktató.
	 *
	 * @param teacher A támadó oktató.
	 */
	public void protectFrom(Teacher teacher) {
		Skeleton.logFunctionCall(this, "protectFrom", teacher);
		items.forEach(i -> i.useAgainst(teacher));
		Skeleton.logReturn(void.class);
	}
}
