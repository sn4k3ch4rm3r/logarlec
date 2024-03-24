package logarlec.effects;

import logarlec.gameobjects.GameObject;
import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;
import logarlec.util.Updatable;

public abstract class Effect implements Updatable {
	protected GameObject holder;

	/**
	 * A hatás diákra alkalmazódik
	 *
	 * @param target A diák, akire alkalmazódik a hatás.
	 */
	public abstract void applyToStudent(Student target);

	/**
	 * A hatás oktatóra alkalmazódik
	 *
	 * @param target Az oktató, akire alkalmazódik a hatás.
	 */
	public abstract void applyToTeacher(Teacher target);
	/**
	 * Ezen hatás tulajdonosának megváltoztatása.
	 *
	 * @param holder Az új tulajdonos.
	 */

	public void setHolder(GameObject holder) {
		Skeleton.logFunctionCall(this,"setHolder",holder);
		this.holder = holder;
		Skeleton.logReturn(void.class);
	}

	/**
	 * Ha lejárt az idő, önmegsemmisít az objektum.
	 *
	 * @param deltaTime Lásd: Updatable.
	 */
	@Override
	public void update(double deltaTime) {
		boolean moreTime = Skeleton.getInput(Boolean.class, "Does the " + this + " have more time left? Enter a boolean: ");
		if (!moreTime)
			holder.removeEffect(this);
	}
}
