package logarlec.util;

import logarlec.gameobjects.Teacher;
import logarlec.items.Item;
import logarlec.gameobjects.Room;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	private List<Item> items = new ArrayList<>();
	private int itemCount = 0;
	public boolean add(Item item) {
		if (itemCount < 5) {
			items.add(item);
			return true;
		}
		return false;
	}

	public void remove(Item item) {
		items.remove(item);
	}

	public void setRoom(Room room) {
		items.forEach(i -> i.setRoom(room));
	}

	public void protectFrom(Teacher teacher) {
		items.forEach(i -> i.useAgainst(teacher));
	}
}
