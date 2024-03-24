package logarlec.effects;

import logarlec.skeleton.Skeleton;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;


public class RagEffect extends Effect {
	private double timeRemaining = 15;

	public void applyToStudent(Student target) {
		Skeleton.logFunctionCall(this, "applyToStudent", target);
		Skeleton.logReturn(void.class);
	}

	/**
	 * Oktató megbékítése.
	 *
	 */
	public void applyToTeacher(Teacher target) {
		Skeleton.logFunctionCall(this, "applyToTeacher", target);
		target.setPeaceful(true);
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
		return "Rag effect";
	}
}
