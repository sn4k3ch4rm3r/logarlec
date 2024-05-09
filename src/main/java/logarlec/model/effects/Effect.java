package logarlec.model.effects;

import logarlec.model.gameobjects.GameObject;
import logarlec.model.gameobjects.Room;
import logarlec.model.gameobjects.Student;
import logarlec.model.gameobjects.Teacher;
import logarlec.model.util.Updatable;

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

	/**
	 * A hatás szobára való alkalmazása
	 * 
	 * @param target A szoba, amire alkalmazódik a hatás
	 */
	public void applyToRoom(Room target) {}

	/**
	 * A hatás interakciója CleanEffect-el.
	 * 
	 * @param cleanEffect a CleanEffect, amivel interakciót végez
	 */
	public void interactCleanEffect(CleanEffect cleanEffect) {}

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
}
