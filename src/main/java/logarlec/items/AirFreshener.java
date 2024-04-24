package logarlec.items;

import logarlec.effects.CleanEffect;
import logarlec.gameobjects.Teacher;
import logarlec.prototype.Prototype;

public class AirFreshener extends Item {
    @Override
    public void use() {
        CleanEffect cleanEffect = new CleanEffect();
        String effectName = cleanEffect.getClass().getSimpleName();
        effectName = effectName.substring(0, 1).toLowerCase() + effectName.substring(1);
        int i = 0;
        while (Prototype.getObject(effectName + (i == 0 ? "" : i)) != null) {
            i++;
        }
        Prototype.addObject(effectName + (i == 0 ? "" : i), cleanEffect);
        room.addEffect(cleanEffect);
        room.removeItem(this);
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
		return String.format("AirFreshner <%d>\nPerson: <%d>\nRoom: <%d>\n",
				this.hashCode(), this.person.hashCode(), this.room.hashCode());
	}
}
