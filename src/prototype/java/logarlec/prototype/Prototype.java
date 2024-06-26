package logarlec.prototype;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import logarlec.model.gameobjects.Room;
import logarlec.prototype.testrunner.TestBuilder;
import logarlec.prototype.testrunner.TestRunner;

public class Prototype {
	private static Map<String, Object> objects = new HashMap<>();
	public static Random random = new Random();

	public static PipedOutputStream out;
	public static PipedInputStream in;
	static {
		try {
			out = new PipedOutputStream();
			in = new PipedInputStream(out);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * A Prototípus program belépési pontja.
	 * 
	 * @param args Parancssori argumentumok.
	 */
	public static void main(String[] args) {
		String mode = args[0];
		switch (mode) {
			case "run":
				TestRunner.run(TestBuilder.buildSingle(args[1]));
				break;
			case "runall":
				TestRunner.runall(TestBuilder.buildAll(args[1]));
				break;
			case "interactive":
				TestRunner.interactive(TestBuilder.buildAll(args[1]));
				break;
			case "command":
				TestRunner.command();
				break;
			default:
				break;
		}
	}

	/**
	 * Nevesített objektum regisztrálása.
	 * 
	 * @param name Az objektum neve
	 * @param object Maga az objektum
	 */
	public static void addObject(String name, Object object) {
		objects.put(name, object);
	}

	/**
	 * Objektum lekérdezése név alapján
	 * 
	 * @param name Az objektum neve
	 * @return Az objektum
	 */
	public static Object getObject(String name) {
		if (objects.containsKey(name)) {
			return objects.get(name);
		}
		return null;
	}

	/**
	 * Objektum nevének lekérdezése hashCode alapján.
	 * 
	 * @param hashCode Az objektum hashCode-ja
	 * @return Az objektum
	 */
	public static String getObjectName(int hashCode) {
		for (Entry<String, Object> obj : objects.entrySet()) {
			if (obj.getValue().hashCode() == hashCode) {
				return obj.getKey();
			}
		}
		return Integer.toString(hashCode);
	}

	/**
	 * Törli a nyilvántartott objektumokat.
	 */
	public static void clearObjects() {
		objects.clear();
	}

	/**
	 * A nyilvántartott szobák lekérdezése
	 * 
	 * @return A szobák listája
	 */
	public static List<Room> getRooms() {
		return objects.values().stream().filter(o -> o instanceof Room).map(o -> (Room) o).toList();
	}

	/**
	 * Parancsok kimenetében az objektumok az egyszerűbb megvalósítás érdekében csak a hash
	 * code-jukat írják ki, ezt cseréli a Prototípus program által nyilvántartott névre.
	 * 
	 * @param raw Az eredeti kimenet
	 * @return Kimenet az objektumok nevével
	 */
	public static String replaceObjectNames(String raw) {
		Pattern pattern = Pattern.compile("<([^>]*)>");
		Matcher matcher = pattern.matcher(raw);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			int hashCode = Integer.parseInt(matcher.group(1));
			Object object = getObjectName(hashCode);
			if (object != null) {
				matcher.appendReplacement(sb, object.toString());
			}
		}
		matcher.appendTail(sb);
		return sb.toString();
	}
}
