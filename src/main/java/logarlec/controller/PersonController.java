package logarlec.controller;

import logarlec.model.util.Direction;
import logarlec.model.util.Entity;
import logarlec.view.drawables.PersonView;

/**
 * Az entitás vezérlője
 */
public class PersonController {
    /**
     * Az entitás, amit vezérel
     */
    protected Entity entity;
    /**
     * Az entitás nézete
     */
    protected PersonView personView;

    /**
     * Konstruktor
     *
     * @param entity    Az entitás, amit vezérel
     * @param personView A nézet, amit frissít
     */
    public PersonController(Entity entity, PersonView personView) {
        this.entity = entity;
        this.personView = personView;
    }

    /**
     * Az entitás mozgatása egy irányba
     * @param direction: Az irány, amerre mozog
     */
    public void move(Direction direction) {
        GameController.getInstance().moveEntity(entity, direction);
    }
}
