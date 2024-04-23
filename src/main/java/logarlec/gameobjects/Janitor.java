package logarlec.gameobjects;

import logarlec.effects.Effect;
import logarlec.effects.JanitorEffect;
import logarlec.skeleton.Skeleton;

public class Janitor extends Person {
    @Override
    public void applyEffect(Effect effect) {

    }

    @Override
    public void interactTeacher(Teacher teacher) {

    }

    @Override
    public void protectFromTeacher(Teacher target) {

    }

    @Override
    public void pickedUpSlideRule(){
    }

    @Override
    public void enterRoom(Room room) {
        super.enterRoom(room);
        JanitorEffect janitorEffect = new JanitorEffect();
        room.addEffect(janitorEffect);
    }

    @Override
	public String toString() {
		return String.format("Janitor <%d>\nEffects: %b\nInventory: %b\nKnock-out time: %b",
				this.hashCode(), effects, inventory.toString(), knockOutTime);
	}
}
