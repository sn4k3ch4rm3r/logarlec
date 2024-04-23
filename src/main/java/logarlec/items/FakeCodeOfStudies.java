package logarlec.items;

import logarlec.gameobjects.Teacher;
import logarlec.skeleton.Skeleton;

public class FakeCodeOfStudies extends CodeOfStudies {
    /**
     * A FakeCodeOfStudies osztály useAgainst metódusa
     * Nem csinál semmit
     * @param target - a teacher, aki ellen a FakeCodeOfStudies-t használjuk
     */
    @Override
    public void useAgainst(Teacher target) {
    }

    @Override
	public String toString() {
		return String.format("FakeCodeOfStudies <%d>\nPerson: %b\nRoom: %b\n",
				this.hashCode(), this.person, this.room);
	}
}
