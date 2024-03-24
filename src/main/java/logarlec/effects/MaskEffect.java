package logarlec.effects;

import logarlec.skeleton.Skeleton;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;

public class MaskEffect extends Effect {
	private int uses = 5;

	/**
	 * Diák megbénítása
	 *
	 */
	public void applyToStudent(Student target) {
		Skeleton.logFunctionCall(this, "applyToStudent", target);
		target.setKnockOut(0);
		Skeleton.logReturn(void.class);
	}

	/**
	 * Oktató megbénítása
	 *
	 */

	public void applyToTeacher(Teacher target) {
		Skeleton.logFunctionCall(this, "applyToTeacher", target);
		target.setKnockOut(0);
		Skeleton.logReturn(void.class);
	}

	@Override
	public void update(double deltaTime) {
		Skeleton.logFunctionCall(this, "update", deltaTime);
		super.update(deltaTime);
		Skeleton.logReturn(void.class);
	}

	@Override
	public String toString() {
		return "Mask effect";
	}
}
