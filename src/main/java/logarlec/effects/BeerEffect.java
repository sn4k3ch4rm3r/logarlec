package logarlec.effects;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;

public class BeerEffect extends Effect {
	public void applyToStudent(Student target) {
		target.setEliminated(false);
	}

	public void applyToTeacher(Teacher target) {}

	@Override
	public void update(double deltaTime) {

	}
}
