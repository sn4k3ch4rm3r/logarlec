package logarlec.effects;

import logarlec.gameobjects.Room;
import logarlec.skeleton.Skeleton;

import logarlec.gameobjects.GameObject;
import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;
import logarlec.util.Updatable;

public abstract class Effect implements Updatable {
	protected GameObject holder;

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
		Skeleton.logFunctionCall(this, "setHolder", holder);
		this.holder = holder;
		Skeleton.logReturn(void.class);
	}


	@Override
	public void update(double deltaTime) {
		Skeleton.logFunctionCall(this, "update", deltaTime);
		boolean moreTime = Skeleton.getInput(Boolean.class,
				"Does the " + this + " have more time left [true|false]: ");
		if (!moreTime) {
			holder.removeEffect(this);
		}
		Skeleton.logReturn(void.class);
	}

	public void interactCleanEffect(CleanEffect cleanEffect) {
		Skeleton.logFunctionCall(this, "interactCleanEffect", cleanEffect);
		Skeleton.logReturn(void.class);
	}
}
