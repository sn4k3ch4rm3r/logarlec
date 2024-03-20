package logarlec.effects;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;
import logarlec.items.Skeleton;

public class MaskEffect extends Effect {
	private int uses = 5;

	/**
	 * knockout target
	 *
	 * @param target Student to be applied to.
	 */
	public void applyToStudent(Student target) {
		Skeleton.logFunctionCall(this,"applyToStudent",target);
		target.setKnockOut(0);
		Skeleton.logReturn(null);
	}
	/**
	 * knockout target
	 *
	 * @param target Teacher to be applied to.
	 */

	public void applyToTeacher(Teacher target) {
		Skeleton.logFunctionCall(this,"applyToStudent",target);
		target.setKnockOut(0);
		Skeleton.logReturn(null);
	}

	/**
	 * If number of uses up, it self destructs
	 *
	 * @param deltaTime
	 */
	@Override
	public void update(double deltaTime) {
		Skeleton.logFunctionCall(this,"update",deltaTime);
		if (uses < 1) {
			holder.removeEffect(this);
		}
		Skeleton.logReturn(null);
	}
}
