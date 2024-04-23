package logarlec.effects;

import logarlec.skeleton.Skeleton;

import logarlec.gameobjects.Teacher;
import logarlec.gameobjects.Student;

public class BeerEffect extends Effect {
	double timeRemaining = 15.0;

	/**
	 * Egy diák játékból kiejtett állapotát megszünteti, és eldobatja
	 *
	 */
	public void applyToStudent(Student target) {
		target.setEliminated(false);
		target.dropRandomItem();
	}

	public void applyToTeacher(Teacher target) {
	}

	@Override
	public String toString() {
		return String.format("BeerEffect <%d>\nHolder: %b\nTime remaining: %b\n",
				this.hashCode(), holder, timeRemaining);
	}
}
