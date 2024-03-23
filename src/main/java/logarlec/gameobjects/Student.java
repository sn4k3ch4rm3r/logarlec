package logarlec.gameobjects;


import java.util.List;

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

	/**
	 * Setter a vesztés állapotának beállítására.
	 * @param value az elmimnated új értéke
	 */
	public void setEliminated(boolean value) {
		eliminated = value;
	}

	/**
	 * Tanárral szembeni védelem hozzáadása.
	 * @param target a tanár, akitől a diák védekezni szeretne
	 */
	@Override
	public void protectFromTeacher(Teacher target) {
		immuneToTeacher.add(target);
	}

	/**
	 * A diák interakciója egy tanárral.
	 * @param teacher a tanár, akivel a diák interakcióba lép
	 */
	@Override
	public void interactTeacher(Teacher teacher) {
		if (immuneToTeacher.contains(teacher)) {
			return;
		}
		inventory.protectFrom(teacher);
	}
}
