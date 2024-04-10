package logarlec.gameobjects;

import logarlec.effects.Effect;
import logarlec.items.Item;
import logarlec.util.Inventory;

import logarlec.skeleton.Skeleton;


/**
 * A pályán mozogni képes entitások ősosztálya.
 */
public abstract class Person extends GameObject {
	/**
	 * A személy által birtokolt tárgyak.
	 */
	protected Inventory inventory;

	protected double knockOutTime = -5;

	/**
	 * A szoba melyben a személy jelenleg tartózkodik.
	 */
	protected Room currentRoom;

	public Person() {
		inventory = Skeleton.createObject("inventory", Inventory.class);
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
		Skeleton.logFunctionCall(this, "enterRoom", room);
		currentRoom = room;
		inventory.setRoom(room);
		Skeleton.logReturn(void.class);
	}

	/**
	 * Egy adott tárgy eldobását megvalósító metódus.
	 * 
	 * @param item az eldobandó tárgy
	 */
	public void dropItem(Item item) {
		Skeleton.logFunctionCall(this, "dropItem", item);
		inventory.remove(item);
		item.drop();
		Skeleton.logReturn(void.class);
	}

	/**
	 * Ájulást megvalósító metódus.
	 * 
	 * @param value az ájulás ideje
	 */
	public void setKnockOut(double value) {
		Skeleton.logFunctionCall(this, "setKnockOut", value);
		if (value > 0 && knockOutTime <= -5) {
			knockOutTime = value;
		}
		Skeleton.logReturn(void.class);
	}

	/**
	 * A személy belső állapotát frissítő metódus.
	 * 
	 * @param deltaTime az eltelt idő
	 */
	@Override
	public void update(double deltaTime) {
		Skeleton.logFunctionCall(this, "update", deltaTime);
		for (Effect effect : effects) {
			effect.update(deltaTime);
			applyEffect(effect);
		}
		if (knockOutTime > 0) {
			// call usePassive on all items
		}
		Skeleton.logReturn(void.class);
	}

	/**
	 * Egy tágy hozzáadása a személyhez.
	 * 
	 * @param item a hozzáadandó tárgy
	 */
	@Override
	public void addItem(Item item) {
		Skeleton.logFunctionCall(this, "addItem", item);
		if (currentRoom == null || currentRoom.isClean()) {
			if (inventory.add(item)) {
				item.setPerson(this);
				item.setRoom(currentRoom);
			}
		}

		Skeleton.logReturn(void.class);
	}

	/**
	 * Egy tárgy eltávolítása a személytől.
	 * 
	 * @param item a eltávolítandó tárgy
	 */
	@Override
	public void removeItem(Item item) {
		Skeleton.logFunctionCall(this, "removeItem", item);
		inventory.remove(item);
		Skeleton.logReturn(void.class);
	}

	/**
	 * A logarléc megtalálást kezelő metódus.
	 */
	public void pickedUpSlideRule() {
		Skeleton.logFunctionCall(this, "pickedUpSlideRule");
		Skeleton.logReturn(void.class);
	}

	public void getOut() {
		Skeleton.logFunctionCall(this, "getOut");
		// If not knocked out
		boolean isKnockedOut = Skeleton.getInput(Boolean.class, "Is the person knocked out?");
		if (!isKnockedOut) {
			currentRoom.getOut(this);
		}
		Skeleton.logReturn(void.class);
	}

	public void dropRandomItem() {
		Skeleton.logFunctionCall(this, "dropRandomItem");
		inventory.dropRandomItem();
		Skeleton.logReturn(void.class);
	}
}
