package logarlec.items;

import logarlec.gameobjects.Teacher;
import logarlec.skeleton.Skeleton;

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
		Skeleton.logFunctionCall(this, "useAgainst", target);
		person.protectFromTeacher(target);
		Skeleton.logReturn(void.class);
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
