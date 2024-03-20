package logarlec.effects;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;
import logarlec.skeleton.Skeleton;

public class RagEffect extends Effect {
	private double timeRemaining;

	public void applyToStudent(Student target) {}

	public void applyToTeacher(Teacher target) {
		Skeleton.logFunctionCall(this,"applyToStudent",target);
		target.setPeaceful(true);
		Skeleton.logReturn(null);
	}

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
