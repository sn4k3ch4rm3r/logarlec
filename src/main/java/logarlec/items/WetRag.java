package logarlec.items;

import logarlec.gameobjects.Room;
import logarlec.gameobjects.Teacher;
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

	@Override
	public void drop(){
		room.addItem(this);
		person.removeEffect(ragEffect);
	}

	@Override
	public void setRoom(Room newRoom) {
		room.removeEffect(ragEffect);
		newRoom.addEffect(ragEffect);
		room = newRoom;
	}
}
