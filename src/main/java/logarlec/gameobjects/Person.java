package logarlec.gameobjects;

import logarlec.effects.Effect;
import logarlec.items.Item;
import logarlec.util.Inventory;

public abstract class Person extends GameObject {
	private String name;
	private double knockOutTime;
	Inventory inventory = new Inventory();

	Room currentRoom;

	public abstract void protectFromTeacher(Teacher target);

	public void enterRoom(Room room) {
		room.enter(this);
		inventory.setRoom(room);
	}

	public void dropItem(Item item) {
		inventory.remove(item);
		item.drop();
	}

	public void setKnockOut(double value) {
		knockOutTime = value;
	}

	@Override
	public void update(double deltaTime) {
		if (knockOutTime > 0) {
			knockOutTime -= deltaTime;
		}
	}

	@Override
	public void addItem(Item item) {
		inventory.add(item);
		item.setPerson(this);
	}

	@Override
	public void removeItem(Item item) {
		inventory.remove(item);
	}

	@Override
	public void applyEffect(Effect effect) {
		effects.add(effect);
		effect.setHolder(this);
	}
	public void pickedUpSlideRule() {

	}
}
