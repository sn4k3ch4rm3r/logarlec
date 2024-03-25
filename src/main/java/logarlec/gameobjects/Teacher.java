package logarlec.gameobjects;

import logarlec.effects.Effect;
import logarlec.skeleton.Skeleton;

/**
 * Egy játékban szereplő tanár.
 */
public class Teacher extends Person {
	/**
	 * Setter a békés állapot beállítására.
	 * 
	 * @param value az új békés állapot
	 */
	public void setPeaceful(boolean value) {
		logarlec.skeleton.Skeleton.logFunctionCall(this, "setPeaceful", value);
		// Set peaceful value
		logarlec.skeleton.Skeleton.logReturn(void.class);
	}

	/**
	 * Üres metódus, a tanárnak nincs szüksége védelemre.
	 */
	@Override
	public void protectFromTeacher(Teacher target) {

	}

	/**
	 * Üres metódus, a tanár nem interakcióba lép más tanárokkal.
	 */
	@Override
	public void interactTeacher(Teacher teacher) {

	}

	@Override
	public void applyEffect(Effect effect) {
		Skeleton.logFunctionCall(this, "applyEffect", effect);
		effect.applyToTeacher(this);
		Skeleton.logReturn(void.class);
	}

	@Override
	public void update(double deltaTime) {
		Skeleton.logFunctionCall(this, "update", deltaTime);

		Skeleton.setLogging(false);
		super.update(deltaTime);
		Skeleton.setLogging(true);

		if (!Skeleton.getInput(Boolean.class, "Is the teacher peaceful [true|false]: ")) {
			currentRoom.interactTeacher(this);
		}

		Skeleton.logReturn(void.class);
	}
}
