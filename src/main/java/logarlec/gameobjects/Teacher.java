package logarlec.gameobjects;

import logarlec.effects.Effect;

/**
 * Egy játékban szereplő tanár.
 */
public class Teacher extends Person {

	private boolean peaceful = false;

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
			// TODO Prototype print: teacher attacked everyone.
			currentRoom.interactTeacher(this);
		}
	}

	@Override
	public String toString() {
		StringBuilder effectsSB = new StringBuilder();
		for (Effect e : effects) {
			effectsSB.append("<").append(e.hashCode()).append("> ");
		}
		return String.format("Teacher <%d>\nEffects: %s\nInventory: %s\nKnock-out time: %.0f\nRoom: <%d>\n",
				this.hashCode(), effectsSB, inventory.toString(), knockOutTime, this.currentRoom.hashCode());
	}
}
