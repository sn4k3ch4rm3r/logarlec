package logarlec.effects;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;
import logarlec.prototype.Prototype;

public class GasEffect extends Effect {
	public GasEffect() {
		timeRemaining = 15;
	}

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
	public void interactCleanEffect(CleanEffect cleanEffect) {
		timeRemaining = 0;
		update(0);
		try {
			Prototype.out.write(String.format("<%d> removed <%d>.\n", cleanEffect.hashCode(), this.hashCode()).getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String toString() {
		return String.format("GasEffect <%d>\nHolder: <%d>\nTime remaining: %.0f\n", this.hashCode(),
				this.holder.hashCode(), timeRemaining);
	}
}
