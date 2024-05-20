package logarlec.model.util;

import logarlec.model.events.InventoryChangeListener;
import logarlec.model.gameobjects.Room;
import logarlec.model.gameobjects.Teacher;
import logarlec.model.items.Item;
import logarlec.prototype.Prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Inventory {
	private List<Item> items = new ArrayList<>();

	private List<InventoryChangeListener> listeners = new ArrayList<>();

	public void addOnChangeEventListener(InventoryChangeListener listener) {
		listeners.add(listener);
	}

	public void onChanged() {
		for (InventoryChangeListener listener : listeners) {
			listener.onInventoryChange();
		}
	}

	/**
	 * Tárgy hozzáadása a felszereléshez, ha kevesebb, mint 5 van benne.
	 *
	 * @param item Hozzáadandó tárgy.
	 */
	public boolean add(Item item) {
		if (items.size() < 5) {
			items.add(item);
			onChanged();
			return true;
		} else {
			try {
				Prototype.out.write("Inventory is full.\n".getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
	}

	/**
	 * Tárgy eltávolítása a felszerelésből, ha benne van.
	 *
	 * @param item Eltávolítandó tárgy.
	 */
	public void remove(Item item) {
		items.remove(item);
		onChanged();
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
		List<Item> itemsNew = new ArrayList<>(items);
		for (Item item : itemsNew) {
			item.useAgainst(teacher);
		}
	}

	/**
	 * Random tárgy eldobása az eszköztárból.
	 */
	public void dropRandomItem() {
		if (!items.isEmpty()) {
			Random random = new Random();
			Item item = items.get(random.nextInt(items.size()));
			item.drop();
			remove(item);
		}
	}

	/**
	 * Az eszköztárban található tárgyakat lehet lekérdezni vele.
	 * 
	 * @return A tárgyak listája
	 */
	public List<Item> getItems() {
		return items;
	}

	@Override
	public String toString() {
		StringBuilder itemsString = new StringBuilder();
		for (Item item : items) {
			itemsString.append("<").append(item.hashCode()).append("> ");
		}
		return String.format("%s", itemsString);
	}
}
