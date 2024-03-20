package logarlec.skeleton;

import java.util.Map;
import java.lang.reflect.Constructor;
import java.util.HashMap;

public class Logger {
	private int indentationLevel;
	private Map<Object, String> objectNames;

	private void indent(StringBuilder stringBuilder) {
		for (int i = 0; i < indentationLevel; i++) {
			stringBuilder.insert(0, "│  ");
		}
	}

	private void addParams(StringBuilder stringBuilder, Object... params) {
		stringBuilder.append("(");
		for (int i = 0; i < params.length; i++) {
			stringBuilder.append(getObjectName(params[i]));
			if (i < params.length - 1) {
				stringBuilder.append(", ");
			}
		}
		stringBuilder.append(")");
	}

	private String getObjectName(Object object) {
		if (objectNames.containsKey(object)) {
			return objectNames.get(object);
		}
		return object.toString();
	}

	public Logger() {
		indentationLevel = 0;
		objectNames = new HashMap<Object, String>();
	}

	/**
	 * Függvény hívások naplózása
	 * 
	 * @param object Az az objektum, amin a függvény hívódik
	 * @param function A függvény neve
	 * @param params A függvény paraméterei, ha vannak.
	 */
	public void logFunctionCall(Object object, String function, Object... params) {
		StringBuilder message = new StringBuilder();
		message.append("┌ ");
		message.append(getObjectName(object));
		message.append(".");
		message.append(function);
		addParams(message, params);
		indent(message);
		indentationLevel++;
		System.out.println(message.toString());
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
	public <T> T createObject(String name, Class<T> type, Object... params) {
		StringBuilder message = new StringBuilder();
		message.append("┌ ");
		message.append(type.getSimpleName());
		addParams(message, params);
		System.out.println(message.toString());
		indentationLevel++;

		try {
			Class<?>[] paramTypes = new Class<?>[params.length];
			for (int i = 0; i < params.length; i++) {
				paramTypes[i] = params[i].getClass();
			}
			Constructor<?> constructor = type.getDeclaredConstructor(paramTypes);

			// Make constructor accessible if private
			if (!constructor.canAccess(null)) {
				constructor.setAccessible(true);
			}

			// Create the object using reflection
			T object = type.cast(constructor.newInstance(params));
			objectNames.put(object, name);
			logReturn(object);
			return object;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	/**
	 * Függvény visszatérés naplózása
	 * 
	 * @param value Viszzatérési érték.
	 */
	public void logReturn(Object value) {
		indentationLevel--;
		StringBuilder message = new StringBuilder();
		message.append("└ ");
		message.append(getObjectName(value));
		indent(message);
		System.out.println(message.toString());
	}

}
