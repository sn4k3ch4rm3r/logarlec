package logarlec.prototype.command;

import logarlec.items.Transistor;
import logarlec.prototype.Prototype;

public class Link implements Command {

	private String transistor1;
	private String transistor2;

	public Link(String transistor1, String transistor2) {
		this.transistor1 = transistor1;
		this.transistor2 = transistor2;
	}

	@Override
	public String execute() throws Exception {
		Transistor t1 = (Transistor) Prototype.getObject(transistor1);
		Transistor t2 = (Transistor) Prototype.getObject(transistor2);
		t1.link(t2);
		return null;
	}

}
