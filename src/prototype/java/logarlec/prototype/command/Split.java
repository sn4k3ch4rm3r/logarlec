package logarlec.prototype.command;

import logarlec.model.gameobjects.Room;
import logarlec.prototype.Prototype;

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
