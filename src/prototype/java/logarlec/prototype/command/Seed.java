package logarlec.prototype.command;

import java.util.Random;
import logarlec.prototype.Prototype;

public class Seed implements Command {

	private int seed;

	public Seed(int seed) {
		this.seed = seed;
	}

	@Override
	public String execute() throws Exception {
		Prototype.random = new Random(seed);
		return null;
	}

}
