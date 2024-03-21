package logarlec.items;

import logarlec.gameobjects.Teacher;

public class CodeOfStudies extends Item {
	@Override
	public void use() {
		// Do nothing
	}

	/**
	 * A CodeOfStudies osztály useAgainst metódusa
	 * A metódus a person (student) protectFromTeacher metódusát hívja meg a paraméterként kapott target-el (teacher)
	 * @param target - a teacher, aki ellen a CodeOfStudies-t használjuk
	 */
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
