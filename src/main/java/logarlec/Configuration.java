package logarlec;

import java.util.Locale;

public final class Configuration {
	/* Configuration variables */
	public static final int WIDTH = 512;
	public static final int HEIGHT = 384;
	public static final float SCALE = 2;
	public static final String SPRITE_PATH = "sprites.xml";
	public static final Locale DEFAULT_LOCALE = new Locale("la");

	/* Calculated values */
	public static final int WINDOW_WIDTH = (int) (WIDTH * SCALE);
	public static final int WINDOW_HEIGHT = (int) (HEIGHT * SCALE);
}
