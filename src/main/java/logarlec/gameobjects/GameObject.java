package logarlec.gameobjects;

import logarlec.effects.Effect;
import logarlec.items.Item;
import logarlec.util.Updatable;

public abstract class GameObject implements Updatable {
	public abstract void addItem(Item item);

	public abstract void removeItem(Item item);

	public abstract void applyEffect(Effect effect);

	public abstract void interactTeacher(Teacher teacher);

	public void addEffect(Effect effect) {}

	public void removeEffect(Effect effect) {}
}
