package logarlec.items;

import logarlec.gameobjects.Person;

public class FakeSlideRule extends SlideRule {
    /**
     * A FakeSlideRule osztály setPerson metódusa A metódus beállítja, hogy az adott FakeSlideRule-t
     * melyik Person inventory-jában tároljuk Ezen kívül nem történik semmi
     * 
     * @param person - a SlideRulet felvevő Person
     */
    @Override
    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
	public String toString() {
		return String.format("FakeSlideRule <%d>\nPerson: <%d>\nRoom: <%d>\n",
				this.hashCode(), this.person.hashCode(), this.room.hashCode());
	}
}
