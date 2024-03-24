package logarlec.gameobjects;


import java.util.LinkedList;
import java.util.List;
import logarlec.skeleton.Skeleton;

/**
 * Egy játékban szereplő diák.
 */
public class Student extends Person {

	/**
	 * Igaz ha a diák vesztett.
	 */
	private boolean eliminated;

	/**
	 * Az ignorálható tanárok listája.
	 */
	private List<Teacher> immuneToTeacher;

	public Student() {
		immuneToTeacher = new LinkedList<>();
	}

	/**
	 * Setter a vesztés állapotának beállítására.
	 * 
	 * @param value az elmimnated új értéke
	 */
	public void setEliminated(boolean value) {
		Skeleton.logFunctionCall(this, "setEliminated", value);
		eliminated = value;
		Skeleton.logReturn(void.class);
	}

	/**
	 * Tanárral szembeni védelem hozzáadása.
	 * 
	 * @param target a tanár, akitől a diák védekezni szeretne
	 */
	@Override
	public void protectFromTeacher(Teacher target) {
		Skeleton.logFunctionCall(this, "protectFromTeacher", target);
		immuneToTeacher.add(target);
		Skeleton.logReturn(void.class);
	}

	/**
	 * A diák interakciója egy tanárral.
	 * 
	 * @param teacher a tanár, akivel a diák interakcióba lép
	 */
	@Override
	public void interactTeacher(Teacher teacher) {
		Skeleton.logFunctionCall(this, "interactTeacher", teacher);
		if (immuneToTeacher.contains(teacher)) {
			return;
		}
		inventory.protectFrom(teacher);
		Skeleton.logReturn(void.class);
	}
}
