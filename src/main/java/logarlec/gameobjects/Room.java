package logarlec.gameobjects;

import logarlec.effects.Effect;
import logarlec.items.Item;
import logarlec.util.Door;

public class Room extends GameObject {
	public boolean enter(Person person) {
		return false;
	}

	public void leave(Person person) {}

	public void merge(Room room) {}

	public Room split() {
		return null;
	}

	public void moveContents(Room room) {}

	public void addDoor(Door door) {}

	public void removeDoor(Door door) {}

	public void hideDoors() {}

	public void showDoors() {}

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

	@Override
	public void interactTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'interactTeacher'");
	}
}
