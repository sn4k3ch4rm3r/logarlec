package logarlec.gameobjects;

import logarlec.effects.Effect;
import logarlec.skeleton.Skeleton;

/**
 * Egy játékban szereplő tanár.
 */
public class Teacher extends Person {

	private boolean peaceful;
	/**
	 * Setter a békés állapot beállítására.
	 * 
	 * @param value az új békés állapot
	 */
	public void setPeaceful(boolean value) {
		peaceful = value;
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
		effect.applyToTeacher(this);
	}

	@Override
	public void update(double deltaTime) {
		super.update(deltaTime);

		if (!peaceful) {
			currentRoom.interactTeacher(this);
		}
	}
}
