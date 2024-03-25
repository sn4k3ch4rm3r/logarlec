package logarlec.effects;

import logarlec.skeleton.Skeleton;

import logarlec.gameobjects.Teacher;
import logarlec.gameobjects.Student;

public class BeerEffect extends Effect {
	double timeRemaining = 15.0;

	/**
	 * Egy diák játékból kiejtett állapotát megszünteti.
	 *
	 */
	public void applyToStudent(Student target) {
		Skeleton.logFunctionCall(this, "applyToStudent", target);
		target.setEliminated(false);
		Skeleton.logReturn(void.class);
	}

	public void applyToTeacher(Teacher target) {
		Skeleton.logFunctionCall(this, "applyToTeacher", target);
		Skeleton.logReturn(void.class);
	}

	@Override
	public String toString() {
		return "Beer effect";
	}
}
