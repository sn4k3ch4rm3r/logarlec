package logarlec.prototype.command;

import logarlec.gameobjects.Person;
import logarlec.items.Item;
import logarlec.prototype.Prototype;

public class Use implements Command {

	private String person;
	private String item;

	public Use(String person, String item) {
		this.person = person;
		this.item = item;
	}

	@Override
	public String execute() throws Exception {
		Person personObject = (Person) Prototype.getObject(person);
		Item itemObject = (Item) Prototype.getObject(item);

		itemObject.setPerson(personObject);
		itemObject.use();
		return null;
	}

}
