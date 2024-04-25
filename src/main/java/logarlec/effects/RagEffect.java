package logarlec.effects;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;
import logarlec.prototype.Prototype;


public class RagEffect extends Effect {
	public RagEffect() {
		super();
		timeRemaining = 15;
	}

	public void applyToStudent(Student target) {}

	/**
	 * Oktató megbékítése.
	 *
	 */
	public void applyToTeacher(Teacher target) {
		target.setPeaceful(true);
	}

	@Override
	public String toString() {
		return String.format("RagEffect <%d>\nHolder: <%d>\nTime remaining: %f\n", this.hashCode(),
				this.holder.hashCode(), timeRemaining);
	}
	@Override
	public void update(double deltaTime) {
		super.update(deltaTime);
		if (timeRemaining <= 0) {
			holder.removeEffect(this);
			try {
				Prototype.out.write(String.format("<%d> ran out of time.\n", hashCode()).getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
