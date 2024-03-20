package logarlec.items;

import logarlec.gameobjects.Teacher;

public class CodeOfStudies extends Item {
	@Override
	public void use() {
		// Do nothing
	}

	@Override
	public void useAgainst(Teacher target) {
		person.protectFromTeacher(target);
	}

	@Override
	public boolean usePassive() {
		//Do nothing
		return false;
	}

	@Override
	public void useItem(Item item) {
		//Do nothing
	}

	@Override
	public void link(Transistor other) {
		//Do nothing
	}

}
