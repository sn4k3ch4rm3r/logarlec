package logarlec.prototype.testrunner;

import java.nio.file.*;
import java.util.List;
import java.util.LinkedList;
import java.util.stream.Stream;
import logarlec.prototype.command.CommandBuilder;
import java.io.IOException;


public class TestBuilder {
	public static Test buildSingle(String path) {
		try {
			List<String> input = Files.readAllLines(Paths.get(path, "in.txt"));
			String output = Files.readString(Paths.get(path, "out.txt"));
			List<String> desc = Files.readAllLines(Paths.get(path, "info.txt"));
			TestDescription testDescription =
					new TestDescription(desc.get(0), desc.get(1), desc.get(2));

			return new Test(CommandBuilder.buildAll(input), output, testDescription);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Test> buildAll(String path) {
		List<Test> tests = new LinkedList<>();
		try (Stream<Path> paths = Files.walk(Paths.get(path), 1)) {
			paths.filter(Files::isDirectory).forEach(t -> {
				if (t.compareTo(Paths.get(path)) != 0) {
					tests.add(buildSingle(t.toString()));
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tests;
	}
}
