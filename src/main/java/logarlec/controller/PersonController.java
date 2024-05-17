package logarlec.controller;

import logarlec.model.util.Direction;
import logarlec.model.util.Entity;

public class PersonController {
    protected Entity entity;
    protected PersonView personView;

    public void move(Direction direction){
        GameController.getInstance().moveEntity(entity, direction);
    }
}
