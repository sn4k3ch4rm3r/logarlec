package logarlec.effects;

import logarlec.gameobjects.GameObject;
import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;
import logarlec.util.Updatable;

public abstract class Effect implements Updatable {
	private GameObject holder;
	private int timeRemaining;
	public abstract void applyToStudent(Student target);

	public abstract void applyToTeacher(Teacher target);

	public void setHolder(GameObject holder) {
		this.holder = holder;
	}

	@Override
	public void update(double deltaTime) {
		if (timeRemaining <= 0) {
			holder.removeEffect(this);
		}
	}
}
