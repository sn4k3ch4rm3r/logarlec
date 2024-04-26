package logarlec.prototype.testrunner;

import logarlec.prototype.Prototype;

import java.util.List;

public class TestRunner {
	/**
	 * Egyetlen tesztet futtat.
	 * 
	 * @param test A futtatandó teszt.
	 */
	public static boolean run(Test test) {
		System.out.println(test.toString());
		boolean success = test.run();
		System.out.println(success ? "[SUCCESS]" : "[FAILED]");
		return success;
	}

	/**
	 * Az összes tesztet lefuttatja.
	 * 
	 * @param tests A tesztek listája.
	 */
	public static void runall(List<Test> tests) {
		int successful = 0;
		for (Test test : tests) {
			Prototype.clearObjects();
			if (run(test)) {
				successful++;
			}
		}
		System.out.printf("Successful: %d/%d%n", successful, tests.size());
	}

	/**
	 * Interaktív tesztelő környezetet futtat. Megjelenik az összes teszt egy listában, ezek közül a
	 * felhasználó kiválaszthatja, hogy melyeket akarja futtatni.
	 * 
	 * @param tests A tesztek listája.
	 */
	public static void interactive(List<Test> tests) {
		// TODO
	}

	/**
	 * Parancsértelmezőt futtat, ahol a felhasználó manuálisan beírhat parancsokat, és láthatja azok
	 * kimenetét.
	 */
	public static void command() {
		// TODO
	}
}
