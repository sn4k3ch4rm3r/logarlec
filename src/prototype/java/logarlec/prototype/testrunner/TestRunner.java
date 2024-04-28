package logarlec.prototype.testrunner;

import logarlec.prototype.Prototype;
import logarlec.prototype.command.Command;
import logarlec.prototype.command.CommandBuilder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class TestRunner {
	/**
	 * Egyetlen tesztet futtat.
	 * 
	 * @param test A futtatandó teszt.
	 */
	public static boolean run(Test test) {
		Prototype.clearObjects();
		System.out.println(test.toString());
		boolean success = test.run();
		System.out.println(success ? "[SUCCESS]" : "[FAILED]");
		System.out.println();
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
			if (run(test)) {
				successful++;
			}
		}
		System.out.printf("Tests: %d | SUCCESSFUL: %d | FAILED: %d\n", tests.size(), successful,
				tests.size() - successful);
	}

	/**
	 * Interaktív tesztelő környezetet futtat. Megjelenik az összes teszt egy listában, ezek közül a
	 * felhasználó kiválaszthatja, hogy melyeket akarja futtatni.
	 * 
	 * @param tests A tesztek listája.
	 */
	public static void interactive(List<Test> tests) {
		Scanner scanner = new Scanner(System.in);
		listTests(tests);
		String input = "";
		do {
			System.out.print(
					"Enter a number to run a test, \"a\" to run all tests, \"l\" to list the tests or \"q\" to quit:\n> ");
			input = scanner.nextLine().strip();
			switch (input) {
				case "a":
					runall(tests);
					break;
				case "q":
					break;
				case "l":
					listTests(tests);
				default:
					try {
						int testId = Integer.parseInt(input);
						run(tests.get(testId - 1));
					} catch (Exception e) {
						System.out.println("Invalid input");
					}
					break;
			}
		} while (!input.equals("q"));
		scanner.close();
	}

	/**
	 * Parancsértelmezőt futtat, ahol a felhasználó manuálisan beírhat parancsokat, és láthatja azok
	 * kimenetét.
	 */
	public static void command() {
		Scanner scanner = new Scanner(System.in);
		String input = "";
		do {
			input = scanner.nextLine().strip();
			if (!input.equals("exit")) {
				Command cmd = CommandBuilder.buildSingle(input);
				try {
					String result = cmd.execute();
					if (result == null) {
						result = "";
					}
					if (Prototype.in.available() > 0) {
						byte[] buffer = new byte[Prototype.in.available()];
						Prototype.in.read(buffer);
						String output = new String(buffer, StandardCharsets.UTF_8);
						result += Prototype.replaceObjectNames(output);
					}
					if (result != null && result != "") {
						System.out.println(Prototype.replaceObjectNames(result));
					}
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		} while (!input.equals("exit"));
		scanner.close();
	}

	/**
	 * Tesztesetek kilistázása az interaktív teszt futtatóhoz.
	 * 
	 * @param tests Tesztek listája
	 */
	private static void listTests(List<Test> tests) {
		for (int i = 0; i < tests.size(); i++) {
			System.out.printf("%2d %s\n", i + 1, tests.get(i).getDescription().name());
		}
	}
}
