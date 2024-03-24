package logarlec.gameobjects;

import logarlec.effects.Effect;
import logarlec.items.Item;
import logarlec.util.Inventory;

public abstract class Person extends GameObject {
	String name;
	double knockOutTime;
	Inventory inventory = new Inventory();

	Room currentRoom;

	public abstract void protectFromTeacher(Teacher target);

	public void enterRoom(Room room) {
		room.enter(this);
	}

	public void dropItem(Item item) {
		inventory.remove(item);
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
	}

	@Override
	public void removeItem(Item item) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'removeItem'");
	}

	@Override
	public void applyEffect(Effect effect) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'applyEffect'");
	}
	public void pickedUpSlideRule() {
	}
}
