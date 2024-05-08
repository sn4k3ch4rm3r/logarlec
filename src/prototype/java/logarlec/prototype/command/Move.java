package logarlec.prototype.command;

import logarlec.model.gameobjects.Person;
import logarlec.model.util.Door;
import logarlec.prototype.Prototype;

public class Move implements Command {

	private String person;
	private String door;

	public Move(String person, String door) {
		this.person = person;
		this.door = door;
	}

	@Override
	public String execute() throws Exception {
		Person personObject = (Person) Prototype.getObject(person);
		Door doorObject = (Door) Prototype.getObject(door);

		doorObject.use(personObject);
		return null;
	}

}
