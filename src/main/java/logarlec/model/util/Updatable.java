package logarlec.model.util;

public interface Updatable {
	/**
	 * Telt az idő, és erre reagál az objektum.
	 *
	 * @param deltaTime A legutóbbi update óta eltelt idő.
	 */
	public void update(double deltaTime);
}
