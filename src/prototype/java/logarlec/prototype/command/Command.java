package logarlec.prototype.command;

public interface Command {
	/**
	 * Parancs futtatása
	 * 
	 * @return A parancs kimenete, ha van.
	 */
	public String execute() throws Exception;
}
