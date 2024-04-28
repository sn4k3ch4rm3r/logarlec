package logarlec.items;

import logarlec.gameobjects.Teacher;

public class FakeCodeOfStudies extends CodeOfStudies {
    /**
     * A FakeCodeOfStudies osztály useAgainst metódusa Nem csinál semmit
     * 
     * @param target - a teacher, aki ellen a FakeCodeOfStudies-t használjuk
     */
    @Override
    public void useAgainst(Teacher target) {}

    @Override
    public String toString() {
        return String.format("FakeCodeOfStudies <%d>\nPerson: <%d>\nRoom: <%d>\n", this.hashCode(),
                this.person.hashCode(), this.room.hashCode());
    }
}
