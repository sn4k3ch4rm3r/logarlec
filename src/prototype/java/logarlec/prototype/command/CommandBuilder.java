package logarlec.prototype.command;

import java.util.List;
import java.util.LinkedList;

public class CommandBuilder {
	/**
	 * Egy parancs létrehozása szövegből.
	 * 
	 * @param command String: <code>&lt;parancs> [&lt;arg1>, &lt;arg2>, ...]</code>
	 * @return Parancs objektum.
	 */
	public static Command buildSingle(String command) {
		// TODO: Parse string to a command
		return null;
	}

	public static List<Command> buildAll(List<String> commands) {
		List<Command> cmds = new LinkedList<>();
		for (String cmd : commands) {
			cmds.add(buildSingle(cmd));
		}
		return cmds;
	}
}
