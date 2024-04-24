package logarlec.effects;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;


public class RagEffect extends Effect {

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
}
