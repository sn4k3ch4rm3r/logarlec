package logarlec.effects;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;

public class GasEffect extends Effect {
	double timeRemaining = 15.0;
	/**
	 * Diák bénított állapotának megszüntetése.
	 *
	 */
	public void applyToStudent(Student target) {
		Skeleton.logFunctionCall(this,"applyToStudent",target);
		target.setKnockOut(5);
		Skeleton.logReturn(void.class);
	}

	/**
	 * Oktató bénított állapotának megszüntetése.
	 *
	 */
	public void applyToTeacher(Teacher target) {
		Skeleton.logFunctionCall(this,"applyToTeacher",target);
		target.setKnockOut(5);
		Skeleton.logReturn(void.class);
	}


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
