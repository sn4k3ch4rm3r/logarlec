package logarlec.effects;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;
import logarlec.skeleton.Skeleton;

public class GasEffect extends Effect {
	double timeRemaining = 15.0;
	public void applyToStudent(Student target) {
		Skeleton.logFunctionCall(this,"applyToStudent",target);
		target.setKnockOut(5);
		Skeleton.logReturn(null);
	}

	public void applyToTeacher(Teacher target) {
		Skeleton.logFunctionCall(this,"applyToTeacher",target);
		target.setKnockOut(5);
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
