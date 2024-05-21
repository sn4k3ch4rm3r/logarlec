package logarlec.model.effects;

import logarlec.model.gameobjects.Student;
import logarlec.model.gameobjects.Teacher;

public class GasEffect extends Effect {
	public GasEffect() {
		timeRemaining = 15;
	}

	/**
	 * Diák megbénítása
	 */
	public void applyToStudent(Student target) {
		target.setKnockOut(5);
	}

	/**
	 * Oktató megbénítása
	 */
	public void applyToTeacher(Teacher target) {
		target.setKnockOut(5);
	}

	@Override
	public void interactCleanEffect(CleanEffect cleanEffect) {
		timeRemaining = 0;
		update(0);
	}

	public String toString() {
		return String.format("GasEffect <%d>\nHolder: <%d>\nTime remaining: %.0f\n",
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
