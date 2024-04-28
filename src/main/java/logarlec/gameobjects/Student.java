package logarlec.gameobjects;


import java.util.LinkedList;
import java.util.List;
import logarlec.effects.Effect;
import logarlec.prototype.Prototype;

/**
 * Egy játékban szereplő diák.
 */
public class Student extends Person {
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
		if (eliminated && !value) {
			try {
				//Prototype.out.write(String.format("<%d> was revived.\n", this.hashCode()).getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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
		} else {
			try {
				Prototype.out.write(String.format("<%d> was eliminated.\n", this.hashCode()).getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
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
		// A játék véget ér
	}

	@Override
	public String toString() {
		StringBuilder effectsString = new StringBuilder();
		for (Effect effect : this.effects) {
			effectsString.append("<").append(effect.hashCode()).append("> ");
		}
		return String.format("Student <%d>\nEffects: %s\nEliminated: %b\nInventory: %s\nKnock-out time: %.0f\nRoom: %s\n",
				this.hashCode(), effectsString, eliminated, inventory.toString(), knockOutTime, currentRoom == null ? "" : String.format("<%d>", currentRoom.hashCode()));
	}
}
