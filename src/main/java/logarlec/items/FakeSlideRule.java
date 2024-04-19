package logarlec.items;

import logarlec.gameobjects.Person;
import logarlec.skeleton.Skeleton;

public class FakeSlideRule extends SlideRule {
    /**
     * A FakeSlideRule osztály setPerson metódusa
     * A metódus beállítja, hogy az adott FakeSlideRule-t melyik Person inventory-jában tároljuk
     * Ezen kívül nem történik semmi
     * @param person - a SlideRulet felvevő Person
     */
    @Override
    public void setPerson(Person person) {
        this.person = person;
    }
}
