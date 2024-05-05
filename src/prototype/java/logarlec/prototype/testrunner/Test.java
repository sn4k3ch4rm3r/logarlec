package logarlec.prototype.testrunner;

import logarlec.prototype.Prototype;
import logarlec.prototype.command.Command;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class Test {
	private List<Command> commands;
	private String expected;
	private TestDescription description;

	public Test(List<Command> in, String expected, TestDescription description) {
		this.commands = in;
		this.expected = expected;
		this.description = description;
	}

	/**
	 * A teszt futtatása
	 * 
	 * @return Igaz, ha sikeres, különben hamis.
	 */
	public boolean run() {
		try {
			StringBuilder actual = new StringBuilder();
			for (Command command : commands) {
				String result = command.execute();
				if (Prototype.in.available() > 0) {
					byte[] buffer = new byte[Prototype.in.available()];
					Prototype.in.read(buffer);
					String output = new String(buffer, StandardCharsets.UTF_8);
					actual.append(Prototype.replaceObjectNames(output));
				}
				if (result != null && result != "") {
					actual.append(Prototype.replaceObjectNames(result) + "\n");
				}
			}
			String result = actual.toString().trim();
			boolean success = result.replaceAll("\\s+", "").equals(expected.replaceAll("\\s+", ""));
			if (!success) {
				System.out.println("Expected:\n" + expected);
				System.out.println("---------\nGot:\n" + result);
			}
			return success;
		} catch (Throwable e) {
			System.err.println("Something went wrong!");
			e.printStackTrace();
			return false;
		}
	}

	public TestDescription getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return description.name() + "\nLeírás:\n\t" + description.description() + "\nFunkció:\n\t"
				+ description.function();
	}
}
