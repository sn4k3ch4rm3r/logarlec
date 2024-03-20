package logarlec.effects;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;

public class RagEffect extends Effect {
	public void applyToStudent(Student target) {}

	public void applyToTeacher(Teacher target) {
		target.setPeaceful(true);
	}

	@Override
	public void update(double deltaTime) {

	}
}
