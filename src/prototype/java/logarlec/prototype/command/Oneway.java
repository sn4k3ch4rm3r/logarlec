package logarlec.prototype.command;

import logarlec.prototype.Prototype;
import logarlec.util.Door;

public class Oneway implements Command {

	private String door;
	private boolean value;

	public Oneway(String door, boolean value) {
		this.door = door;
		this.value = value;
	}

	@Override
	public String execute() throws Exception {
		Door doorObject = (Door) Prototype.getObject(door);
		doorObject.setOneWay(value);
		return null;
	}

}
