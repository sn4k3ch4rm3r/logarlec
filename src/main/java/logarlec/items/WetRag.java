package logarlec.items;

import logarlec.gameobjects.Room;
import logarlec.gameobjects.Teacher;
import logarlec.effects.RagEffect;

public class WetRag extends Item {
	RagEffect ragEffect;

	@Override
	public void use() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'use'");
	}

	@Override
	public void useAgainst(Teacher target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'useAgainst'");
	}

	@Override
	public boolean usePassive() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'usePassive'");
	}

	@Override
	public void useItem(Item item) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'useItem'");
	}

	@Override
	public void link(Transistor other) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'link'");
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
