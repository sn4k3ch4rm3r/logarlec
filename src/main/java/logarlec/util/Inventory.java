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
	public boolean add(Item item) {
		Skeleton.logFunctionCall(this,"add",item);
		if (itemCount < 5) {
			items.add(item);
			Skeleton.logReturn(true);
			return true;
		}
		Skeleton.logReturn(false);
		return false;
	}

	public void remove(Item item) {
		Skeleton.logFunctionCall(this,"remove",item);
		items.remove(item);
		Skeleton.logReturn(null);
	}

	public void setRoom(Room room) {
		Skeleton.logFunctionCall(this,"setRoom",room);
		items.forEach(i -> i.setRoom(room));
		Skeleton.logReturn(null);
	}

	public void protectFrom(Teacher teacher) {
		Skeleton.logFunctionCall(this,"protectFrom",teacher);
		items.forEach(i -> i.useAgainst(teacher));
		Skeleton.logReturn(null);
	}
}
