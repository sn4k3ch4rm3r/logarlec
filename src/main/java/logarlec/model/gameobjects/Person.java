package logarlec.model.gameobjects;

import logarlec.model.effects.Effect;
import logarlec.model.events.DropListener;
import logarlec.model.events.RoomChangedListener;
import logarlec.model.items.Item;
import logarlec.model.util.Inventory;

import java.util.ArrayList;
import java.util.List;

/**
 * A pályán mozogni képes entitások ősosztálya.
 */
public abstract class Person extends GameObject {

	protected double knockOutTime;

	/**
	 * A személy által birtokolt tárgyak.
	 */
	protected Inventory inventory;

	/**
	 * A szoba melyben a személy jelenleg tartózkodik.
	 */
	protected Room currentRoom;

	protected List<DropListener> dropListeners = new ArrayList<>();
	protected List<RoomChangedListener> roomChangedListeners = new ArrayList<>();

	public Person() {
		inventory = new Inventory();
		knockOutTime = -5;
	}

	public void addDropListener(DropListener listener) {
		dropListeners.add(listener);
	}

	public void addRoomChangedListener(RoomChangedListener listener) {
		roomChangedListeners.add(listener);
	}

	/**
	 * Absztrakt osztály, mely a tanárok védelmét valósítja meg.
	 */
	public abstract void protectFromTeacher(Teacher target);

	/**
	 * A személy szobába való beleépeésének adminisztrációját megvalósító metódus.
	 * 
	 * @param room a szoba, melybe a személy belép
	 */
	public void enterRoom(Room room) {
		currentRoom = room;
		inventory.setRoom(room);
	}

	/**
	 * Egy adott tárgy eldobását megvalósító metódus.
	 * 
	 * @param item az eldobandó tárgy
	 */
	public void dropItem(Item item) {
		inventory.remove(item);
		for (DropListener listener : dropListeners) {
			listener.onDrop(item);
		}
		item.drop();
	}

	/**
	 * Ájulást megvalósító metódus.
	 * 
	 * @param value az ájulás ideje
	 */
	public void setKnockOut(double value) {
		knockOutTime = value;
	}

	/**
	 * A személy belső állapotát frissítő metódus.
	 * 
	 * @param deltaTime az eltelt idő
	 */
	@Override
	public void update(double deltaTime) {
		for (Effect effect : effects) {
			effect.update(deltaTime);
			applyEffect(effect);
		}
		if (knockOutTime > 0) {
			knockOutTime -= deltaTime;
			for (Item item : inventory.getItems()) {
				item.usePassive();
			}
		}
	}

	/**
	 * Egy tágy hozzáadása a személyhez.
	 * 
	 * @param item a hozzáadandó tárgy
	 */
	@Override
	public boolean addItem(Item item) {
		if (currentRoom == null || currentRoom.isClean()) {
			if (inventory.add(item)) {
				item.setPerson(this);
				if (currentRoom != null) {
					currentRoom.removeItem(item);
					item.setRoom(currentRoom);
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * Egy tárgy eltávolítása a személytől.
	 * 
	 * @param item a eltávolítandó tárgy
	 */
	@Override
	public void removeItem(Item item) {
		inventory.remove(item);
	}

	/**
	 * A logarléc megtalálást kezelő metódus.
	 */
	public void pickedUpSlideRule() {}

	public void getOut() {
		if (knockOutTime <= 0) {
			currentRoom.getOut(this);
			for (RoomChangedListener listener : roomChangedListeners) {
				listener.onRoomChanged();
			}
		}
	}

	public void dropRandomItem() {
		Item item = inventory.getRandomItem();
		if (item != null) {
			dropItem(item);
		}
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public boolean canMove() {
		return knockOutTime <= 0;
	}
}
