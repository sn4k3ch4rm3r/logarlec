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
		target.setKnockOut(5);
	}

	/**
	 * Oktató megbénítása
	 *
	 */
	public void applyToTeacher(Teacher target) {
		target.setKnockOut(5);
	}

	@Override
	public String toString() {
		return "Gas effect";
	}

	@Override
	public void interactCleanEffect(CleanEffect cleanEffect) {
		holder.removeEffect(this);
	}
}
