package logarlec.prototype.testrunner;

import java.util.List;

class Main {
	/**
	 * A Prototípus program belépési pontja.
	 * 
	 * @param args Parancssori argumentumok.
	 */
	public static void main(String[] args) {
		String mode = args[0];
		switch (mode) {
			case "run":
				run(TestBuilder.buildSingle(args[1]));
				break;
			case "runall":
				runall(TestBuilder.buildAll(args[1]));
				break;
			case "interactive":
				interactive(TestBuilder.buildAll(args[1]));
				break;
			case "command":
				command();
				break;
			default:
				break;
		}
	}

	/**
	 * Egyetlen tesztet futtat.
	 * 
	 * @param test A futtatandó teszt.
	 */
	private static void run(Test test) {
		System.out.println(test.toString());
		System.out.println(test.run() ? "[SUCCESS]" : "[FAILED]");
	}

	/**
	 * Az összes tesztet lefuttatja.
	 * 
	 * @param tests A tesztek listája.
	 */
	private static void runall(List<Test> tests) {
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
	private static void interactive(List<Test> tests) {
		// TODO
	}

	/**
	 * Parancsértelmezőt futtat, ahol a felhasználó manuálisan beírhat parancsokat, és láthatja azok
	 * kimenetét.
	 */
	private static void command() {
		// TODO
	}
}
