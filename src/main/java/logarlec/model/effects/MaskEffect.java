package logarlec.model.effects;

import logarlec.model.gameobjects.Student;
import logarlec.model.gameobjects.Teacher;

public class MaskEffect extends Effect {

	public MaskEffect(double time) {
		timeRemaining = time;
	}

	public MaskEffect() {
		this(5.0);
	}

	/**
	 * Diák bénított állapotának megszüntetése.
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
		return String.format("MaskEffect <%d>\nHolder: <%d>\nTime remaining: %.0f\n",
				this.hashCode(), this.holder.hashCode(), timeRemaining);
	}

	@Override
	public void update(double deltaTime) {
		super.update(deltaTime);
		if (timeRemaining <= 0) {
			holder.removeEffect(this);
		}
	}
}
