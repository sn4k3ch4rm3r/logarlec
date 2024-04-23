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
				// TODO
				return null;
			case "create":
				String type = args[1];
				String name = args[2];
				String[] cmdArgs = new String[0];
				if (args.length > 3) {
					cmdArgs = Arrays.copyOfRange(args, 3, args.length);
				}
				return new Create(type, name, cmdArgs);
			case "drop":
				// TODO
				return null;
			case "link":
				// TODO
				return null;
			case "merge":
				// TODO
				return null;
			case "move":
				// TODO
				return null;
			case "oneway":
				// TODO
				return null;
			case "pickup":
				// TODO
				return null;
			case "seed":
				// TODO
				return null;
			case "split":
				// TODO
				return null;
			case "status":
				return new Status(args[1]);
			case "use":
				// TODO
				return null;
			case "update":
				// TODO
				return null;
			default:
				return null;
		}
	}

	public static List<Command> buildAll(List<String> commands) {
		List<Command> cmds = new LinkedList<>();
		for (String cmd : commands) {
			cmds.add(buildSingle(cmd));
		}
		return cmds;
	}
}
