package logarlec.prototype.command;

import logarlec.model.gameobjects.Room;
import logarlec.model.util.Updatable;
import logarlec.prototype.Prototype;

public class Update implements Command {

	private double deltaTime;
	private String object;

	public Update(double deltaTime, String object) {
		this.deltaTime = deltaTime;
		this.object = object;
	}

	public Update(double deltaTime) {
		this.deltaTime = deltaTime;
		object = null;
	}

	@Override
	public String execute() throws Exception {
		if (object != null) {
			Updatable updatable = (Updatable) Prototype.getObject(object);
			updatable.update(deltaTime);
		} else {
			for (Room room : Prototype.getRooms()) {
				room.update(deltaTime);
			}
		}
		return null;
	}

}
