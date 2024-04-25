package logarlec.effects;

import logarlec.gameobjects.Teacher;
import logarlec.gameobjects.Student;
import logarlec.prototype.Prototype;

public class BeerEffect extends Effect {


	public BeerEffect(){
		super();
		timeRemaining = 15.0;
	}

	/**
	 * Egy diák játékból kiejtett állapotát megszünteti, és eldobatja
	 *
	 */
	public void applyToStudent(Student target) {
		target.setEliminated(false);
		try {
			Prototype.out.write(String.format("<%d> was saved by beer.\n", target.hashCode()).getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		target.dropRandomItem();
	}

	public void applyToTeacher(Teacher target) {}

	@Override
	public String toString() {
		return String.format("BeerEffect <%d>\nHolder: <%d>\nTime remaining: %f\n",
				this.hashCode(), this.holder.hashCode(), timeRemaining);
	}

	@Override
	public void update(double deltaTime) {
		super.update(deltaTime);
		if (timeRemaining <= 0) {
			holder.removeEffect(this);
			try {
				Prototype.out.write(String.format("<%d> ran out of time.\n", hashCode()).getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
