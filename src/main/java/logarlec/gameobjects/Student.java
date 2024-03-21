package logarlec.gameobjects;

import logarlec.items.Item;

public class Student extends Person {
	private boolean eliminated;

	private Teacher immuneToTeacher;

	public void setEliminated(boolean value) {
		eliminated = value;
	}

	@Override
	public void protectFromTeacher(Teacher target) {
		immuneToTeacher = target;
	}

	@Override
	public void interactTeacher(Teacher teacher) {
		if (immuneToTeacher == teacher) {
			return;
		}
		inventory.protectFrom(teacher);
	}
}
