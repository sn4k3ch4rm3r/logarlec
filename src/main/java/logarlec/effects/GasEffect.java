package logarlec.effects;

import logarlec.skeleton.Skeleton;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;

public class GasEffect extends Effect {
	double timeRemaining = 15.0;

	/**
	 * Diák megbénítása
	 *
	 */
	public void applyToStudent(Student target) {
		Skeleton.logFunctionCall(this, "applyToStudent", target);
		target.setKnockOut(5);
		Skeleton.logReturn(void.class);
	}

	/**
	 * Oktató megbénítása
	 *
	 */
	public void applyToTeacher(Teacher target) {
		Skeleton.logFunctionCall(this, "applyToTeacher", target);
		target.setKnockOut(5);
		Skeleton.logReturn(void.class);
	}

	@Override
	public String toString() {
		return "Gas effect";
	}

	@Override
	public void interactCleanEffect(CleanEffect cleanEffect) {
		Skeleton.logFunctionCall(this, "interactCleanEffect", cleanEffect);
		holder.removeEffect(this);
		Skeleton.logReturn(void.class);
	}
}
