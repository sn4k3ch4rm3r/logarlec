package logarlec.prototype.testrunner;

import logarlec.prototype.command.Command;
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
		StringBuilder actual = new StringBuilder();
		for (Command command : commands) {
			String result = command.execute();
			if (result != null && result != "") {
				actual.append(result + "\n");
			}
		}
		return actual.toString().equals(expected);
	}

	@Override
	public String toString() {
		return description.name() + "\nLeírás:\n\t" + description.description() + "\nFunkció:\n\t"
				+ description.function();
	}

}
