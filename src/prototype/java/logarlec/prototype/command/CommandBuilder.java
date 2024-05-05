package logarlec.prototype.command;

import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class CommandBuilder {
	/**
	 * Egy parancs létrehozása szövegből.
	 * 
	 * @param command String: <code>&lt;parancs> [&lt;arg1>, &lt;arg2>, ...]</code>
	 * @return Parancs objektum.
	 */
	public static Command buildSingle(String command) {
		String args[] = command.split(" ");
		String cmd = args[0].toLowerCase();
		switch (cmd) {
			case "add":
				return new Add(args[1], args[2]);
			case "create":
				String type = args[1];
				String name = args[2];
				String[] cmdArgs = new String[0];
				if (args.length > 3) {
					cmdArgs = Arrays.copyOfRange(args, 3, args.length);
				}
				return new Create(type, name, cmdArgs);
			case "drop":
				return new Drop(args[1], args[2]);
			case "link":
				return new Link(args[1], args[2]);
			case "merge":
				return new Merge(args[1], args[2]);
			case "move":
				return new Move(args[1], args[2]);
			case "oneway":
				return new Oneway(args[1], Boolean.parseBoolean(args[2]));
			case "pickup":
				return new Pickup(args[1], args[2]);
			case "seed":
				return new Seed(Integer.parseInt(args[1]));
			case "split":
				return new Split(args[1]);
			case "status":
				return new Status(args[1]);
			case "use":
				return new Use(args[1], args[2]);
			case "update":
				if (args.length == 3) {
					return new Update(Double.parseDouble(args[1]), args[2]);
				} else {
					return new Update(Double.parseDouble(args[1]));
				}
			default:
				return null;
		}
	}

	/**
	 * Parancsok létrehozása.
	 * 
	 * @param commands String lista, amiben a parancsok vannak szövegként tárolva
	 * @return Parancs objektumok listája
	 */
	public static List<Command> buildAll(List<String> commands) {
		List<Command> cmds = new LinkedList<>();
		for (String cmd : commands) {
			cmds.add(buildSingle(cmd));
		}
		return cmds;
	}
}
