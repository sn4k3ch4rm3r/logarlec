package logarlec.util;

import logarlec.gameobjects.Teacher;
import logarlec.items.Item;
import logarlec.gameobjects.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Inventory {
	private List<Item> items = new ArrayList<>();

	/**
	 * Tárgy hozzáadása a felszereléshez, ha kevesebb, mint 5 van benne.
	 *
	 * @param item Hozzáadandó tárgy.
	 */
	public boolean add(Item item) {
		if (items.size() < 5) {
			items.add(item);
			return true;
		}
		return false;
	}

	/**
	 * Tárgy eltávolítása a felszerelésből, ha benne van.
	 *
	 * @param item Eltávolítandó tárgy.
	 */
	public void remove(Item item) {
		items.remove(item);
	}

	/**
	 * A tárgyak értesítése, hogy más szobába kerültek.
	 *
	 * @param room A szoba, ahova kerültek.
	 */
	public void setRoom(Room room) {
		items.forEach(i -> i.setRoom(room));
	}

	/**
	 * A tárgyak értesítése, hogy a felszerelés tulajdonosát megtámadta egy oktató.
	 *
	 * @param teacher A támadó oktató.
	 */
	public void protectFrom(Teacher teacher) {
		items.forEach(i -> i.useAgainst(teacher));
	}

	public void dropRandomItem() {
		if (!items.isEmpty()) {
			Random random = new Random();
			Item item = items.get(random.nextInt(items.size()));
			item.drop();
			remove(item);
		}
	}
}
