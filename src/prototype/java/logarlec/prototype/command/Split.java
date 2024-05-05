package logarlec.prototype.command;

import logarlec.prototype.Prototype;
import logarlec.gameobjects.Room;

public class Split implements Command {

	private String room;

	public Split(String room) {
		this.room = room;
	}

	@Override
	public String execute() throws Exception {
		((Room) Prototype.getObject(room)).split();
		return null;
	}

}
