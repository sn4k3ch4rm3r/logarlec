package logarlec.effects;

import logarlec.skeleton.Skeleton;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;

public class MaskEffect extends Effect {

	/**
	 * Diák bénított állapotának megszüntetése.
	 *
	 */
	public void applyToStudent(Student target) {
		Skeleton.logFunctionCall(this, "applyToStudent", target);
		target.setKnockOut(-5);
		Skeleton.logReturn(void.class);
	}

	/**
	 * Oktató bénított állapotának megszüntetése.
	 */

	public void applyToTeacher(Teacher target) {
		Skeleton.logFunctionCall(this, "applyToTeacher", target);
		target.setKnockOut(-5);
		Skeleton.logReturn(void.class);
	}

	@Override
	public String toString() {
		return "Mask effect";
	}
}
