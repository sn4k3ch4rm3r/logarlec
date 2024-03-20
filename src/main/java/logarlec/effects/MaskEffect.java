package logarlec.effects;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;

public class MaskEffect extends Effect {
	public void applyToStudent(Student target) {
		target.setKnockOut(0);
	}

	public void applyToTeacher(Teacher target) {
		target.setKnockOut(0);
	}

	@Override
	public void update(double deltaTime) {

	}
}
