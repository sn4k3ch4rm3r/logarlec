package logarlec.prototype.testrunner;

import java.util.List;

public class TestRunner {
	/**
	 * Egyetlen tesztet futtat.
	 * 
	 * @param test A futtatandó teszt.
	 */
	public static void run(Test test) {
		System.out.println(test.toString());
		System.out.println(test.run() ? "[SUCCESS]" : "[FAILED]");
	}

	/**
	 * Az összes tesztet lefuttatja.
	 * 
	 * @param tests A tesztek listája.
	 */
	public static void runall(List<Test> tests) {
		for (Test test : tests) {
			run(test);
		}
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
