package logarlec.prototype.testrunner;

import logarlec.prototype.Prototype;
import logarlec.prototype.command.Command;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

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
				String result = replaceObjectNames(command.execute());
				if (result != null && result != "") {
					actual.append(result + "\n");
				}
			}
			String result = actual.toString().strip();
			boolean success = result.equals(expected);
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

	private String replaceObjectNames(String raw) {
		Pattern pattern = Pattern.compile("<([^>]*)>");
		Matcher matcher = pattern.matcher(raw);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			int hashCode = Integer.parseInt(matcher.group(1));
			Object object = Prototype.getObjectName(hashCode);
			if (object != null) {
				matcher.appendReplacement(sb, object.toString());
			}
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	@Override
	public String toString() {
		return description.name() + "\nLeírás:\n\t" + description.description() + "\nFunkció:\n\t"
				+ description.function();
	}
}
