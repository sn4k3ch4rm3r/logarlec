package logarlec.effects;

import logarlec.gameobjects.GameObject;
import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;
import logarlec.util.Updatable;

public abstract class Effect implements Updatable {
	public abstract void applyToStudent(Student target);

	public abstract void applyToTeacher(Teacher target);

	public void setHolder(GameObject holder) {}
}
