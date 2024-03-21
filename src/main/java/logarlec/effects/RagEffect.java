package logarlec.effects;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;


public class RagEffect extends Effect {
	private double timeRemaining = 15;

	public void applyToStudent(Student target) {
		Skeleton.logFunctionCall(this,"applyToStudent",target);
		Skeleton.logReturn(void.class);
	}

	/**
	 * Pacify target
	 *
	 * @param target Teacher to be applied to.
	 */
	public void applyToTeacher(Teacher target) {
		Skeleton.logFunctionCall(this,"applyToTeacher",target);
		target.setPeaceful(true);
		Skeleton.logReturn(void.class);
	}

	/**
	 * If time is up, it self destructs
	 *
	 * @param deltaTime
	 */
	@Override
	public void update(double deltaTime) {
		Skeleton.logFunctionCall(this,"update",deltaTime);
		super.update(deltaTime);
		Skeleton.logReturn(void.class);
	}
	@Override
	public String toString() {
		return "Rag effect";
	}
}
