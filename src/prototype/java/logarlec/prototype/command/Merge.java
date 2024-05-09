package logarlec.prototype.command;

import logarlec.model.gameobjects.Room;
import logarlec.prototype.Prototype;

public class Merge implements Command {

	private String room1;
	private String room2;

	public Merge(String room1, String room2) {
		this.room1 = room1;
		this.room2 = room2;
	}

	@Override
	public String execute() throws Exception {
		Room r1 = (Room) Prototype.getObject(room1);
		Room r2 = (Room) Prototype.getObject(room2);
		r1.merge(r2);
		return null;
	}
}
