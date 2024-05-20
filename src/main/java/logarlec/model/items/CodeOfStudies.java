package logarlec.model.items;

import logarlec.model.gameobjects.Teacher;

public class CodeOfStudies extends Item {

	/**
	 * Az osztályban a uses változó tárolja, hogy a CodeOfStudies-t hányszor használhatják még
	 */
	private int uses;

	public CodeOfStudies() {
		uses = 3;
	}

	@Override
	public void use() {
		// Do nothing
	}

	/**
	 * A CodeOfStudies osztály useAgainst metódusa A metódus a person (student) protectFromTeacher
	 * metódusát hívja meg a paraméterként kapott target-el (teacher)
	 * 
	 * @param target - a teacher, aki ellen a CodeOfStudies-t használjuk A tárgy 3 használat után
	 *        megsemmisül
	 */
	@Override
	public void useAgainst(Teacher target) {
		if (uses > 0) {
			person.protectFromTeacher(target);
			uses--;
		}
		if (uses == 0) {
			person.removeItem(this);
		}
	}

	@Override
	public boolean usePassive() {
		// Do nothing
		return false;
	}

	@Override
	public void useItem(Item item) {
		// Do nothing
	}

	@Override
	public void link(Transistor other) {
		// Do nothing
	}

	@Override
	public String toString() {
		return String.format("CodeOfStudies <%d>\nPerson: <%d>\nRoom: <%d>\nUses: %d\n",
				this.hashCode(), this.person.hashCode(), this.room.hashCode(), this.uses);
	}

}
