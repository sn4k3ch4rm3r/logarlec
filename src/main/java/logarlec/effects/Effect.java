package logarlec.effects;

import logarlec.gameobjects.Room;

import logarlec.gameobjects.GameObject;
import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;
import logarlec.prototype.Prototype;
import logarlec.util.Updatable;

public abstract class Effect implements Updatable {
	protected GameObject holder;
	protected double timeRemaining;

	Effect() {}

	Effect(double time) {}

	/**
	 * A hatás diákra alkalmazódik
	 *
	 * @param target A diák, akire alkalmazódik a hatás.
	 */
	public abstract void applyToStudent(Student target);

	/**
	 * A hatás oktatóra alkalmazódik
	 *
	 * @param target Az oktató, akire alkalmazódik a hatás.
	 */
	public abstract void applyToTeacher(Teacher target);

	public void applyToRoom(Room target) {

	}

	/**
	 * Ezen hatás tulajdonosának megváltoztatása.
	 *
	 * @param holder Az új tulajdonos.
	 */

	public void setHolder(GameObject holder) {
		this.holder = holder;
	}


	@Override
	public void update(double deltaTime) {
		if (timeRemaining > 0) {
			timeRemaining -= deltaTime;
		}
	}

	public void interactCleanEffect(CleanEffect cleanEffect) {}
}
