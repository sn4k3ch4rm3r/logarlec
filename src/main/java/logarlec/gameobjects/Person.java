package logarlec.gameobjects;

import logarlec.effects.Effect;
import logarlec.items.Item;
import logarlec.util.Inventory;

/**
 * A pályán mozogni képes entitások ősosztálya.
 */
public abstract class Person extends GameObject {
	/**
	 * A személy neve.
	 */
	private String name;
	/**
	 * A személy ájulásban töltendő ideje.
	 */
	private double knockOutTime;
	/**
	 * A személy által birtokolt tárgyak.
	 */
	Inventory inventory = new Inventory();

	/**
	 * A szoba melyben a személy jelenleg tartózkodik.
	 */
	Room currentRoom;

	/**
	 * Absztrakt osztály, mely a tanárok védelmét valósítja meg.
	 */
	public abstract void protectFromTeacher(Teacher target);

	/**
	 * A személy szobába való beleépeésének adminisztrációját megvalósító metódus.
	 * @param room a szoba, melybe a személy belép
	 */
	public void enterRoom(Room room) {
		room.enter(this);
		inventory.setRoom(room);
	}

	/**
	 * Egy adott tárgy eldobását megvalósító metódus.
	 * @param item az eldobandó tárgy
	 */
	public void dropItem(Item item) {
		inventory.remove(item);
		item.drop();
	}

	/**
	 * Ájulást megvalósító metódus.
	 * @param value az ájulás ideje
	 */
	public void setKnockOut(double value) {
		knockOutTime = value;
	}

	/**
	 * A személy belső állapotát frissítő metódus.
	 * @param deltaTime
	 */
	@Override
	public void update(double deltaTime) {
		if (knockOutTime > 0) {
			knockOutTime -= deltaTime;
		}
	}

	/**
	 * Egy tágy hozzáadása a személyhez.
	 * @param item a hozzáadandó tárgy
	 */
	@Override
	public void addItem(Item item) {
		if(inventory.add(item)) {
			item.setPerson(this);
		}
	}

	/**
	 * Egy tárgy eltávolítása a személytől.
	 * @param item a eltávolítandó tárgy
	 */
	@Override
	public void removeItem(Item item) {
		inventory.remove(item);
		item.drop();
	}

	/**
	 * Egy hatás alkalmazása a személyre.
	 * @param effect a hatás
	 */
	@Override
	public void applyEffect(Effect effect) {
		effects.add(effect);
		effect.setHolder(this);
	}

	/**
	 * A logarléc megtalálást kezelő metódus.
	 */
	public void pickedUpSlideRule() {

	}
}
