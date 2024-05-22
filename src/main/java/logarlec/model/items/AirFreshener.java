package logarlec.model.items;

import logarlec.model.effects.CleanEffect;
import logarlec.model.gameobjects.Teacher;

public class AirFreshener extends Item {
    @Override
    public void use() {
        CleanEffect cleanEffect = new CleanEffect();
        room.addEffect(cleanEffect);
        person.removeItem(this);
    }

    @Override
    public void useAgainst(Teacher target) {

    }

    @Override
    public boolean usePassive() {
        return false;
    }

    @Override
    public void useItem(Item item) {

    }

    @Override
    public void link(Transistor other) {

    }

    @Override
    public String toString() {
        return String.format("AirFreshner <%d>\nPerson: <%d>\nRoom: <%d>\n", this.hashCode(),
                this.person.hashCode(), this.room.hashCode());
    }
}
