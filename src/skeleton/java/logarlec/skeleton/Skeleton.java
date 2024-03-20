package logarlec.skeleton;

public class Skeleton {

	private static Logger logger;


	public static void main() {
		logger = new Logger();
	}


	/**
	 * Függvény hívások naplózása
	 * 
	 * @param object Az az objektum, amin a függvény hívódik
	 * @param function A függvény neve
	 * @param params A függvény paraméterei, ha vannak.
	 */
	public static void logFunctionCall(Object object, String function, Object... params) {
		logger.logFunctionCall(object, function, params);
	}

	/**
	 * Objektum létrehozása naplózással
	 * 
	 * @param <T> A létrehozandó objektum típusa
	 * @param name Az objektum neve
	 * @param type A létrehozni kívánt objektum típusa
	 * @param params Konstruktor paraméterei, ha vannak.
	 * @return Az elkészült objektum
	 */
	public static <T> T createObject(String name, Class<T> type, Object... params) {
		return logger.createObject(name, type, params);
	}

	/**
	 * Függvény visszatérés naplózása
	 * 
	 * @param value Viszzatérési érték.
	 */
	public static void logReturn(Object value) {
		logger.logReturn(value);
	}

}
