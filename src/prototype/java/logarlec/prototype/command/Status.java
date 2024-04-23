package logarlec.prototype.command;

import logarlec.prototype.Prototype;

public class Status implements Command {

	private String object;

	public Status(String object) {
		this.object = object;
	}

	@Override
	public String execute() {
		return Prototype.getObject(object).toString();
	}

}
