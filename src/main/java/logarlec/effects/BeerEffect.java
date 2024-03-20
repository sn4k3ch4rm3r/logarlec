package logarlec.effects;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;
import logarlec.items.Skeleton;

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
		Skeleton.logReturn(null);
	}

	public void applyToTeacher(Teacher target) {}

	/**
	 * If time is up, it self destructs
	 *
	 * @param deltaTime
	 */
	@Override
	public void update(double deltaTime) {
		Skeleton.logFunctionCall(this,"update",deltaTime);
		timeRemaining -= deltaTime;
		if (timeRemaining <= 0) {
			holder.removeEffect(this);
		}
		Skeleton.logReturn(null);
	}
}
