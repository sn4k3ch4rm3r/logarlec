package logarlec.util;

public interface Updatable {
	/**
	 * Times has passed and the object reacts to that.
	 *
	 * @param deltaTime The time passed since the last update.
	 */
	public void update(double deltaTime);
}
