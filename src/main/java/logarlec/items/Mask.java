package logarlec.items;

import logarlec.effects.MaskEffect;
import logarlec.gameobjects.Teacher;
import logarlec.skeleton.Skeleton;

public class Mask extends Item {
	MaskEffect maskEffect;

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
		Skeleton.logFunctionCall(this, "usePassive");
		maskEffect = Skeleton.createObject("maskEffect", MaskEffect.class);
		person.addEffect(maskEffect);

		Skeleton.logReturn(true);
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
		Skeleton.logFunctionCall(this, "drop");


		if (Skeleton.getInput(Boolean.class,
				"Is there an active effect caused by this item [true|false]: ")) {
			person.removeEffect(maskEffect);
		}
		Skeleton.setLogging(false);
		super.drop();
		Skeleton.setLogging(true);
		Skeleton.logReturn(void.class);
	}
}
