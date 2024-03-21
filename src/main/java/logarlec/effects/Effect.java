package logarlec.effects;

import logarlec.gameobjects.GameObject;
import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;
import logarlec.util.Updatable;

public abstract class Effect implements Updatable {
	protected GameObject holder;

	/**
	 * The effect is applied to a student
	 *
	 * @param target Student to be applied to.
	 */
	public abstract void applyToStudent(Student target);
	/**
	 * The effect is applied to a teacher
	 *
	 * @param target Teacher to be applied to.
	 */

	public abstract void applyToTeacher(Teacher target);
	/**
	 * Change the holder of this effect
	 *
	 * @param holder The new holder.
	 */

	public void setHolder(GameObject holder) {
		Skeleton.logFunctionCall(this,"setHolder",holder);
		this.holder = holder;
		Skeleton.logReturn(void.class);
	}

	@Override
	public void update(double deltaTime) {
		boolean moreTime = Skeleton.getInput(Boolean.class, "Does the " + this + " have more time left? Enter a boolean: ");
		if (!moreTime)
			holder.removeEffect(this);
	}
}
