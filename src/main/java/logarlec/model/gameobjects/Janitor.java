package logarlec.model.gameobjects;

import logarlec.model.effects.Effect;
import logarlec.model.effects.JanitorEffect;
import logarlec.prototype.Prototype;

/**
 * Osztály a takarító személyek reprezentálására

 */
public class Janitor extends Person {
    @Override
    public void applyEffect(Effect effect) {

    }

    /**
     * A takarító személy interakciójának kezelése
     *
     * @param teacher a tanár, akivel a takarító személy interakcióba lép
     */
    @Override
    public void interactTeacher(Teacher teacher) {

    }

    /**
     * A takarító tanárral való interakciójának kezelése
     *
     * @param teacher a tanár, akivel a takarító személy interakcióba lép
     */
    @Override
    public void protectFromTeacher(Teacher target) {

    }

    /**
     * A takarító személy logarléc felvételének kezelése
     */
    @Override
    public void pickedUpSlideRule() {}

    /**
     * A takarító személy belép egy szobába
     *
     * @param room a szoba, melybe a takarító belép
     */
    @Override
    public void enterRoom(Room room) {
        super.enterRoom(room);
        JanitorEffect janitorEffect = new JanitorEffect();
        String effectName = janitorEffect.getClass().getSimpleName();
        effectName = effectName.substring(0, 1).toLowerCase() + effectName.substring(1);
        int i = 0;
        while (Prototype.getObject(effectName + (i == 0 ? "" : i)) != null) {
            i++;
        }
        Prototype.addObject(effectName + (i == 0 ? "" : i), janitorEffect);
        room.addEffect(janitorEffect);
    }

    /**
     * Az osztály string reprezentációját adja vissza
     * @return
     */
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
