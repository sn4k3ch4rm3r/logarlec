package logarlec.effects;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;
import logarlec.skeleton.Skeleton;

public class MaskEffect extends Effect {
	private int uses = 5;
	public void applyToStudent(Student target) {
		Skeleton.logFunctionCall(this,"applyToStudent",target);
		target.setKnockOut(0);
		Skeleton.logReturn(null);
	}

	public void applyToTeacher(Teacher target) {
		Skeleton.logFunctionCall(this,"applyToStudent",target);
		target.setKnockOut(0);
		Skeleton.logReturn(null);
	}

	@Override
	public void update(double deltaTime) {
		Skeleton.logFunctionCall(this,"update",deltaTime);
		if (uses < 1) {
			holder.removeEffect(this);
		}
		Skeleton.logReturn(null);
	}
}
