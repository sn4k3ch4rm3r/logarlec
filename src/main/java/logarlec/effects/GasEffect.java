package logarlec.effects;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;

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
		Skeleton.logReturn(void.class);
	}
	/**
	 * unknockout target
	 *
	 * @param target Teacher to be applied to.
	 */

	public void applyToTeacher(Teacher target) {
		Skeleton.logFunctionCall(this,"applyToTeacher",target);
		target.setKnockOut(5);
		Skeleton.logReturn(void.class);
	}

	/**
	 * If time is up, it self destructs
	 *
	 * @param deltaTime
	 */
	@Override
	public void update(double deltaTime) {
		Skeleton.logFunctionCall(this,"update",deltaTime);
		super.update(deltaTime);
		Skeleton.logReturn(void.class);
	}
	@Override
	public String toString() {
		return "Gas effect";
	}
}
