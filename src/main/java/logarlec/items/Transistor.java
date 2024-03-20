package logarlec.items;

import logarlec.gameobjects.Teacher;
import logarlec.gameobjects.Room;

public class Transistor extends Item {
	Transistor other;
	Room target;

	void setTarget(Room room){
		target = room;
	}

	@Override
	public void use() {
		if(other != null){
			person.dropItem(this);
			other.setTarget(room);
		}
		else if(target != null){
			person.dropItem(this);
			boolean entered = target.enter(person);
			if(entered){
				room.leave(person);
			}
		}
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
		other.link(this);
	}

	@Override
	public void link(Transistor other) {
		other.setPair(this);
		this.other = other;
	}

	public void setPair(Transistor other) {
		this.other = other;
	}

	@Override
	public void drop(){
		room.addItem(this);	
	}
}
