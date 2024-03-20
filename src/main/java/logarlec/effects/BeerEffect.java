package logarlec.effects;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;
import logarlec.skeleton.Skeleton;

public class BeerEffect extends Effect {
	double timeRemaining = 15.0;
	public void applyToStudent(Student target) {
		Skeleton.logFunctionCall(this,"applyToStudent",target);
		target.setEliminated(false);
		Skeleton.logReturn(null);
	}

	public void applyToTeacher(Teacher target) {}

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
