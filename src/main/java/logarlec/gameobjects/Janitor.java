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
        StringBuilder effectsSB = new StringBuilder();
		for (Effect e : effects) {
            effectsSB.append("<").append(e.hashCode()).append("> ");
        }
        return String.format("Janitor <%d>\nEffects: %s\nInventory: %s\nKnock-out time: %.0f",
                    this.hashCode(), effectsSB, inventory.toString(), knockOutTime);
	}
}
