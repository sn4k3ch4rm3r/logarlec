package logarlec.items;

import logarlec.gameobjects.Room;
import logarlec.gameobjects.Teacher;
import logarlec.skeleton.Skeleton;
import logarlec.effects.RagEffect;

public class WetRag extends Item {
	RagEffect ragEffect;

	@Override
	public void use() {
		// Do nothing
	}

	@Override
	public void useAgainst(Teacher target) {
		// Do nothing
	}

	@Override
	public boolean usePassive() {
		// Do nothing
		return false;
	}

	@Override
	public void useItem(Item item) {
		// Do nothing
	}

	@Override
	public void link(Transistor other) {
		// Do nothing
	}

	/**
	 * A WetRag osztály setRoom metódusa A metódus eltávolítja a ragEffectet a régi szobáról és
	 * hozzáadja az újhoz
	 * 
	 * @param newRoom - az új Room
	 */
	@Override
	public void setRoom(Room newRoom) {
		Skeleton.logFunctionCall(this, "setRoom", newRoom);
		room.removeEffect(ragEffect);
		newRoom.addEffect(ragEffect);
		room = newRoom;
		Skeleton.logReturn(void.class);
	}
}
