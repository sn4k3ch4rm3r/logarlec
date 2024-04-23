package logarlec.items;

import logarlec.skeleton.Skeleton;

public class FakeMask extends Mask {
    /**
     * A Mask osztály usePassive metódusa
     * Nem csinál semmit
     * @return true
     */
    @Override
    public boolean usePassive() {
        return false;
    }

    @Override
	public String toString() {
		return String.format("FakeMask <%d>\nPerson: %b\nRoom: %b\n",
				this.hashCode(), this.person, this.room);
	}
}
