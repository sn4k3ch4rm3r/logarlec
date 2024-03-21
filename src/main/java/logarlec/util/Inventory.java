package logarlec.util;

import logarlec.gameobjects.Teacher;
import logarlec.items.Item;
import logarlec.gameobjects.Room;
import logarlec.skeleton.Skeleton;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	private List<Item> items = new ArrayList<>();
	private int itemCount = 0;
	/**
	 * If there are less than 5 items in the inventory add item.
	 *
	 * @param item Item to add.
	 */
	public boolean add(Item item) {
		Skeleton.logFunctionCall(this,"add",item);
		if (Skeleton.getInput(Boolean.class, "Can more items fit the inventory? Enter a boolean: ")) {
			items.add(item);
			Skeleton.logReturn(true);
			return true;
		}
		Skeleton.logReturn(false);
		return false;
	}

	/**
	 * Remove item from inventory if it is in there.
	 *
	 * @param item Item to remove.
	 */
	public void remove(Item item) {
		Skeleton.logFunctionCall(this,"remove",item);
		items.remove(item);
		Skeleton.logReturn(void.class);
	}

	/**
	 * Telling the items, that they have moved to a new room
	 *
	 * @param room The room they moved to.
	 */
	public void setRoom(Room room) {
		Skeleton.logFunctionCall(this,"setRoom",room);
		items.forEach(i -> i.setRoom(room));
		Skeleton.logReturn(void.class);
	}

	/**
	 * Telling the items, that the holder of this inventory needs to be protected against a teacher
	 *
	 * @param teacher The teacher they need to protect against.
	 */
	public void protectFrom(Teacher teacher) {
		Skeleton.logFunctionCall(this,"protectFrom",teacher);
		items.forEach(i -> i.useAgainst(teacher));
		Skeleton.logReturn(void.class);
	}
}
