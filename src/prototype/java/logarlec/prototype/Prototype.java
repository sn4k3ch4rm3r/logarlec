package logarlec.prototype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import logarlec.prototype.testrunner.TestBuilder;
import logarlec.prototype.testrunner.TestRunner;

import logarlec.gameobjects.Room;

public class Prototype {
	private static Map<String, Object> objects = new HashMap<>();

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

	public static void addObject(String name, Object object) {
		objects.put(name, object);
	}

	public static Object getObject(String name) {
		if (objects.containsKey(name)) {
			return objects.get(name);
		}
		return null;
	}

	public static String getObjectName(int hashCode) {
		for (Entry<String, Object> obj : objects.entrySet()) {
			if (obj.getValue().hashCode() == hashCode) {
				return obj.getKey();
			}
		}
		return Integer.toString(hashCode);
	}

	public static void clearObjects() {
		objects.clear();
	}

	public static List<Room> getRooms() {
		return objects.values().stream().filter(o -> o instanceof Room).map(o -> (Room) o).toList();
	}
}
