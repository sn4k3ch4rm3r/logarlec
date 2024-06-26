package logarlec.model.gameobjects;


import java.util.LinkedList;
import java.util.List;
import logarlec.model.effects.Effect;
import logarlec.model.events.GameEndedListener;

/**
 * Egy játékban szereplő diák.
 */
public class Student extends Person {
	private List<GameEndedListener> gameEndedListeners = new LinkedList<>();

	/**
	 * Az oktatók listája akikkel szemben a hallgató védve van.
	 */
	private List<Teacher> immuneToTeacher;

	/**
	 * A vesztés állapotát jelző változó.
	 */
	private boolean eliminated;

	/**
	 * Konstruktor a diák létrehozásához.
	 */
	public Student() {
		immuneToTeacher = new LinkedList<>();
	}

	public void addGameEndedListener(GameEndedListener listener) {
		gameEndedListeners.add(listener);
	}

	/**
	 * A diák vesztés állapotának lekérdezése.
	 *
	 * @return a vesztés állapota
	 */
	public boolean isEliminated() {
		return eliminated;
	}

	/**
	 * Setter a vesztés állapotának beállítására.
	 * 
	 * @param value az elmimnated új értéke
	 */
	public void setEliminated(boolean value) {
		eliminated = value;
	}

	/**
	 * Tanárral szembeni védelem hozzáadása.
	 * 
	 * @param target a tanár, akitől a diák védekezni szeretne
	 */
	@Override
	public void protectFromTeacher(Teacher target) {
		immuneToTeacher.add(target);
	}

	/**
	 * A diák interakciója egy tanárral.
	 * 
	 * @param teacher a tanár, akivel a diák interakcióba lép
	 */
	@Override
	public void interactTeacher(Teacher teacher) {
		eliminated = true;
		if (immuneToTeacher.contains(teacher)) {
			eliminated = false;
		}
		else {
			inventory.protectFrom(teacher);
		}
	}

	@Override
	public void applyEffect(Effect effect) {
		effect.applyToStudent(this);
	}

	/*
	 * A diák felveszi a logarécet, ezzel a játék véget ér.
	 */
	@Override
	public void pickedUpSlideRule() {
		for (GameEndedListener g : gameEndedListeners) {
			g.onGameEnded();
		}
	}

	@Override
	public String toString() {
		StringBuilder effectsString = new StringBuilder();
		for (Effect effect : this.effects) {
			effectsString.append("<").append(effect.hashCode()).append("> ");
		}
		return String.format(
				"Student <%d>\nEffects: %s\nEliminated: %b\nInventory: %s\nKnock-out time: %.0f\nRoom: %s\n",
				this.hashCode(), effectsString, eliminated, inventory.toString(), knockOutTime,
				currentRoom == null ? "" : String.format("<%d>", currentRoom.hashCode()));
	}
}
