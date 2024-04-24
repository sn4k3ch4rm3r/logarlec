package logarlec.gameobjects;

import logarlec.effects.Effect;
import logarlec.items.Item;
import logarlec.util.Inventory;

import logarlec.skeleton.Skeleton;


/**
 * A pályán mozogni képes entitások ősosztálya.
 */
public abstract class Person extends GameObject {

	private String name;
	protected double knockOutTime;

	/**
	 * A személy által birtokolt tárgyak.
	 */
	protected Inventory inventory;

	/**
	 * A szoba melyben a személy jelenleg tartózkodik.
	 */
	protected Room currentRoom;

	public Person() {
		inventory = new Inventory();
		knockOutTime = -5;
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
	}

	/**
	 * Egy tágy hozzáadása a személyhez.
	 * 
	 * @param item a hozzáadandó tárgy
	 */
	@Override
	public void addItem(Item item) {
		if (currentRoom == null || currentRoom.isClean()) {
			if (inventory.add(item)) {
				item.setPerson(this);
				item.setRoom(currentRoom);
			}
		}
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
	public void pickedUpSlideRule() {
	}

	public void getOut() {
		if (knockOutTime <= 0) {
			currentRoom.getOut(this);
		}
	}

	public void dropRandomItem() {
		inventory.dropRandomItem();
	}
}
