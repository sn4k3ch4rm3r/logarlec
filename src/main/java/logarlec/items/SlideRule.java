package logarlec.items;

import logarlec.gameobjects.Person;
import logarlec.gameobjects.Teacher;

public class SlideRule extends Item {

	@Override
	public void use() {
		// Do nothing
	}

	@Override
	public void useAgainst(Teacher target) {
		// Do nothing
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
	public void setPerson(Person person) {
		this.person = person;
		person.pickedUpSlideRule();
	}
}
