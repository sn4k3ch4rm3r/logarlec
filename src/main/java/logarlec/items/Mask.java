package logarlec.items;

import logarlec.effects.MaskEffect;
import logarlec.gameobjects.Teacher;
import logarlec.skeleton.Skeleton;

public class Mask extends Item {
	private MaskEffect maskEffect;
	private int uses;

	public Mask(){
		uses = 5;
	}

	/**
	 * A Mask osztály use metódusa A metódus a MaskEffect-et adja hozzá a personhoz
	 */
	@Override
	public void use() {
		// Do nothing
	}

	@Override
	public void useAgainst(Teacher target) {
		// Do nothing
	}

	/**
	 * A Mask osztály usePassive metódusa A metódus a MaskEffect-et adja hozzá a personhoz
	 * 
	 * @return true
	 */
	@Override
	public boolean usePassive() {
		if(uses > 0){
			double time = 5-(5-uses);
			maskEffect = new MaskEffect(time);
			person.addEffect(maskEffect);
			uses--;
		}
		if(uses == 0){
			person.removeItem(this);
		}
		return true;
	}

	@Override
	public void useItem(Item item) {
		// Do nothing
	}

	@Override
	public void link(Transistor other) {
		// Do nothing
	}

	@Override
	public void drop() {
		if (maskEffect != null) {
			person.removeEffect(maskEffect);
		}
		super.drop();
	}

	@Override
	public String toString() {
		return String.format("Mask <%d>\nPerson: <%d>\nRoom: <%d>\nUses: %d\n",
				this.hashCode(), this.person.hashCode(), this.room.hashCode(), this.uses);
	}
}
