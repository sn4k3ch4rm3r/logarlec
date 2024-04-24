package logarlec.prototype.command;

import logarlec.effects.Effect;
import logarlec.gameobjects.GameObject;
import logarlec.gameobjects.Person;
import logarlec.gameobjects.Room;
import logarlec.items.Item;
import logarlec.prototype.Prototype;

public class Add implements Command {

	private String holder;
	private String object;

	public Add(String holder, String object) {
		this.holder = holder;
		this.object = object;
	}

	@Override
	public String execute() throws Exception {
		GameObject gameObject = (GameObject) Prototype.getObject(holder);
		Object target = Prototype.getObject(object);
		if (target instanceof Item) {
			gameObject.addItem((Item) target);
		} else if (target instanceof Effect) {
			gameObject.addEffect((Effect) target);
		} else if (target instanceof Person && gameObject instanceof Room) {
			((Room) gameObject).enter((Person) target);
		}
		return "";
	}

}
