package logarlec.items;

import logarlec.gameobjects.Person;
import logarlec.gameobjects.Teacher;

public class SlideRule extends Item {

	@Override
	public void use() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'use'");
	}

	@Override
	public void useAgainst(Teacher target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'useAgainst'");
	}

	@Override
	public boolean usePassive() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'usePassive'");
	}

	@Override
	public void useItem(Item item) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'useItem'");
	}

	@Override
	public void link(Transistor other) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'link'");
	}

	@Override
	public void setPerson(Person person) {
		this.person = person;
		person.pickedUpSlideRule();
	}
}
