package logarlec.controller;

import logarlec.model.util.Direction;
import logarlec.model.util.Entity;
import logarlec.view.drawables.PersonView;

public class AiController extends PersonController {

    /**
     * Konstruktor
     *
     * @param entity    Az entitás, amit vezérel
     * @param personView A nézet, amit frissít
     */
    public AiController(Entity entity, PersonView personView) {
        super(entity, personView);
    }

    /**
     * Véletlenszerű irányba mozog
     */
    public void turn() {
        Direction direction = Direction.values()[(int) (Math.random() * Direction.values().length)];
        move(direction);
    }
}
