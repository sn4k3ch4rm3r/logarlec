package logarlec.gameobjects;

import logarlec.items.Item;

public class Student extends Person {
	boolean eliminated;
	public void setEliminated(boolean value) {
		eliminated = value;
	}

	@Override
	public void protectFromTeacher(Teacher target) {
		inventory.protectFrom(target);
	}

	@Override
	public void interactTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'interactTeacher'");
	}
}
