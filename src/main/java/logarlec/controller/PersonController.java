package logarlec.controller;

import logarlec.model.util.Direction;
import logarlec.model.util.Entity;
import logarlec.view.drawables.PersonView;

public abstract class PersonController {
    protected Entity entity;
    protected PersonView personView;

    public PersonController(Entity entity, PersonView personView) {
        this.entity = entity;
        this.personView = personView;
    }

    public void move(Direction direction) {
        GameController.getInstance().moveEntity(entity, direction);
    }

    public abstract void turn();
}
