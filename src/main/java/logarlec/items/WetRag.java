package logarlec.items;

import logarlec.gameobjects.Room;
import logarlec.gameobjects.Teacher;
import logarlec.effects.RagEffect;

public class WetRag extends Item {
	RagEffect ragEffect;

	@Override
	public void use() {
		ragEffect = new RagEffect();
		room.addEffect(ragEffect);
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
		if (ragEffect != null) {
			if (room != null) {
				room.removeEffect(ragEffect);
			}
			newRoom.addEffect(ragEffect);
		}
		room = newRoom;
	}

	@Override
	public String toString() {
		return String.format("WetRag <%d>\nPerson: <%d>\nRoom: <%d>\n",
				this.hashCode(), this.person.hashCode(), this.room.hashCode());
	}
	
}
