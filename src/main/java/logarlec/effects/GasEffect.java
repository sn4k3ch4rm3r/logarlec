package logarlec.effects;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;

public class GasEffect extends Effect {
	public void applyToStudent(Student target) {
		target.setKnockOut(5);
	}

	public void applyToTeacher(Teacher target) {
		target.setKnockOut(5);
	}

	@Override
	public void update(double deltaTime) {
	}
}
