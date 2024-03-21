package logarlec.effects;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;

public class BeerEffect extends Effect {
	double timeRemaining = 15.0;
	/**
	 * Uneliminate a student.
	 *
	 * @param target Student to be applied to.
	 */
	public void applyToStudent(Student target) {
		Skeleton.logFunctionCall(this,"applyToStudent",target);
		target.setEliminated(false);
		Skeleton.logReturn(void.class);
	}

	public void applyToTeacher(Teacher target) {
		Skeleton.logFunctionCall(this,"applyToTeacher",target);
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
		Skeleton.logReturn(null);
	}
	@Override
	public String toString() {
		return "Beer effect";
	}
}
