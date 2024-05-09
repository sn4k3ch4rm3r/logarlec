package logarlec.model.items;

import logarlec.model.gameobjects.Person;
import logarlec.model.gameobjects.Teacher;

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

	/**
	 * A SlideRule osztály setPerson metódusa A metódus beállítja, hogy az adott SlideRule-t melyik
	 * Person inventory-jában tároljuk
	 * 
	 * @param person - a SlideRulet felvevő Person A metódus meghívja a person pickedUpSlideRule
	 *        metódusát
	 */
	@Override
	public void setPerson(Person person) {
		this.person = person;
		person.pickedUpSlideRule();
	}

	@Override
	public String toString() {
		return String.format("SlideRule <%d>\nPerson: <%d>\nRoom: <%d>\n", this.hashCode(),
				this.person.hashCode(), this.room.hashCode());
	}

}
