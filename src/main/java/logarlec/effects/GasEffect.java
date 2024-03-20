package logarlec.effects;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;
import logarlec.items.Skeleton;

public class GasEffect extends Effect {
	double timeRemaining = 15.0;
	/**
	 * unknockout target
	 *
	 * @param target Student to be applied to.
	 */
	public void applyToStudent(Student target) {
		Skeleton.logFunctionCall(this,"applyToStudent",target);
		target.setKnockOut(5);
		Skeleton.logReturn(null);
	}
	/**
	 * unknockout target
	 *
	 * @param target Teacher to be applied to.
	 */

	public void applyToTeacher(Teacher target) {
		Skeleton.logFunctionCall(this,"applyToTeacher",target);
		target.setKnockOut(5);
		Skeleton.logReturn(null);
	}

	/**
	 * If time is up, it self destructs
	 *
	 * @param deltaTime
	 */
	@Override
	public void update(double deltaTime) {
		Skeleton.logFunctionCall(this,"update",deltaTime);
		timeRemaining -= deltaTime;
		if (timeRemaining <= 0) {
			holder.removeEffect(this);
		}
		Skeleton.logReturn(null);
	}
}
