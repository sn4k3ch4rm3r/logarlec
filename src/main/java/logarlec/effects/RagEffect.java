package logarlec.effects;

import logarlec.skeleton.Skeleton;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;


public class RagEffect extends Effect {

	public void applyToStudent(Student target) {
	}

	/**
	 * Oktató megbékítése.
	 *
	 */
	public void applyToTeacher(Teacher target) {
		target.setPeaceful(true);
	}

	@Override
	public String toString() {
		return String.format("RagEffect <%d>\nHolder: %b\nTime remaining: %b\n",
				this.hashCode(), holder, timeRemaining);
	}
}
