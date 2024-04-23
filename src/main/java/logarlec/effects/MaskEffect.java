package logarlec.effects;

import logarlec.skeleton.Skeleton;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;

public class MaskEffect extends Effect {

	public MaskEffect(double time) {
		timeRemaining = time;
	}
	/**
	 * Diák bénított állapotának megszüntetése.
	 *
	 */
	public void applyToStudent(Student target) {
		target.setKnockOut(-5);
	}

	/**
	 * Oktató bénított állapotának megszüntetése.
	 */

	public void applyToTeacher(Teacher target) {
		target.setKnockOut(-5);
	}

	@Override
	public String toString() {
		return String.format("MaskEffect <%d>\nHolder: %b\nTime remaining: %b\n",
				this.hashCode(), holder, timeRemaining);
	}
}
