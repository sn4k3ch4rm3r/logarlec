package logarlec.gameobjects;


import java.util.LinkedList;
import java.util.List;
import logarlec.effects.Effect;
import logarlec.skeleton.Skeleton;

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
		if (!immuneToTeacher.contains(teacher)) {
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
	public void pickedUpSlideRule(){
		//A játék véget ér
	}

	@Override
	public String toString() {
		StringBuilder effectsSB = new StringBuilder();
		for (Effect e : effects) {
			effectsSB.append(e.toString());
		}

		return String.format("Student <%d>\nEffects: %s\nEliminated: %b\nInventory: %s\nKnock-out time: %f\nRoom: <%d>\n",
				this.hashCode(), effectsSB.toString(), eliminated, inventory.toString(), knockOutTime, this.currentRoom.hashCode());
	}
}
