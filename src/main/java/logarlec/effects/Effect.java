package logarlec.effects;

import logarlec.gameobjects.GameObject;
import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;
import logarlec.skeleton.Skeleton;
import logarlec.util.Updatable;

public abstract class Effect implements Updatable {
	protected GameObject holder;
	public abstract void applyToStudent(Student target);

	public abstract void applyToTeacher(Teacher target);

	public void setHolder(GameObject holder) {
		Skeleton.logFunctionCall(this,"setHolder",holder);
		this.holder = holder;
		Skeleton.logReturn(null);
	}

	@Override
	public void update(double deltaTime) {}
}
