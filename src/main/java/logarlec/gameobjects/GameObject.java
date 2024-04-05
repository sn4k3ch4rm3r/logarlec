package logarlec.gameobjects;

import logarlec.effects.CleanEffect;
import logarlec.effects.Effect;
import logarlec.items.Item;
import logarlec.skeleton.Skeleton;
import logarlec.util.Updatable;
import java.util.LinkedList;
import java.util.List;

/**
 * Ősosztály a játékban szereplő objektumoknak.
 */
public abstract class GameObject implements Updatable {
	/**
	 * Az objektumon lévő hatások listája.
	 */
	List<Effect> effects;

	public GameObject() {
		effects = new LinkedList<>();
	}

	/**
	 * Az tárgy hozzáadása az objektumhoz.
	 * 
	 * @param item a hozzáadandó tárgy
	 */
	public abstract void addItem(Item item);

	/**
	 * A tárgy eltávolítása az objektumról.
	 * 
	 * @param item a eltávolítandó tárgy
	 */
	public abstract void removeItem(Item item);

	/**
	 * Az objektumon lévő hatások alkalmazása.
	 * 
	 * @param effect a hatás
	 */
	public abstract void applyEffect(Effect effect);

	/**
	 * Az objektum interakciója egy tanárral.
	 * 
	 * @param teacher a tanár
	 */
	public abstract void interactTeacher(Teacher teacher);

	public void interactCleanEffect(CleanEffect cleanEffect) {
		Skeleton.logFunctionCall(this, "interactCleanEffect", cleanEffect);
		Skeleton.logReturn(void.class);
	}

	/**
	 * Effect hozzáadása az objektumhoz.
	 * 
	 * @param effect a hozzáadandó effect
	 */
	public void addEffect(Effect effect) {
		Skeleton.logFunctionCall(this, "addEffect", effect);
		effects.add(effect);
		effect.setHolder(this);
		Skeleton.logReturn(void.class);
	}

	/**
	 * Effect eltávolítása az objektumról.
	 * 
	 * @param effect a eltávolítandó effect
	 */
	public void removeEffect(Effect effect) {
		Skeleton.logFunctionCall(this, "removeEffect", effect);
		effects.remove(effect);
		Skeleton.logReturn(void.class);
	}
}
