package logarlec.prototype.command;

import logarlec.model.gameobjects.Person;
import logarlec.model.items.Item;
import logarlec.prototype.Prototype;

public class Drop implements Command {

	private String person;
	private String item;

	public Drop(String person, String item) {
		this.person = person;
		this.item = item;
	}

	@Override
	public String execute() throws Exception {
		Person personObject = (Person) Prototype.getObject(person);
		Item itemObject = (Item) Prototype.getObject(item);
		personObject.dropItem(itemObject);
		return null;
	}

}
