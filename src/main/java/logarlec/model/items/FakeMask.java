package logarlec.model.items;

public class FakeMask extends Mask {
    /**
     * A Mask osztály usePassive metódusa Nem csinál semmit
     * 
     * @return true
     */
    @Override
    public boolean usePassive() {
        return false;
    }

    @Override
    public String toString() {
        return String.format("FakeMask <%d>\nPerson: <%d>\nRoom: <%d>\n", this.hashCode(),
                this.person.hashCode(), this.room.hashCode());
    }
}
