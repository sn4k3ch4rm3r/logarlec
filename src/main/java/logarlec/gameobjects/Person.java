package logarlec.gameobjects;

import logarlec.effects.Effect;
import logarlec.items.Item;

public abstract class Person extends GameObject {

	public abstract void protectFromTeacher(Teacher target);

	public void enterRoom(Room room) {}

	public void dropItem(Item item) {}

	public void setKnockOut(double value) {}

	@Override
	public void update(double deltaTime) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'update'");
	}

	@Override
	public void addItem(Item item) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'addItem'");
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
}
