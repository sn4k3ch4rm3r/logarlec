package logarlec.model.effects;

import logarlec.model.gameobjects.Student;
import logarlec.model.gameobjects.Teacher;

public class BeerEffect extends Effect {


	public BeerEffect() {
		super();
		timeRemaining = 15.0;
	}

	/**
	 * Egy diák játékból kiejtett állapotát megszünteti, és eldobatja
	 */
	public void applyToStudent(Student target) {
		if (target.isEliminated()) {
			target.setEliminated(false);
		}
	}

	public void applyToTeacher(Teacher target) {}

	@Override
	public String toString() {
		return String.format("BeerEffect <%d>\nHolder: <%d>\nTime remaining: %.0f\n",
				this.hashCode(), this.holder.hashCode(), timeRemaining);
	}

	@Override
	public void update(double deltaTime) {
		super.update(deltaTime);
		if (timeRemaining <= 0) {
			holder.removeEffect(this);
		}
	}
}
