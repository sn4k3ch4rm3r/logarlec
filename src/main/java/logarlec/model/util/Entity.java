package logarlec.model.util;

import logarlec.model.gameobjects.Person;

public class Entity {
    private Position position;
    private Person person;

    public Entity(Position position, Person person) {
        this.position = position;
        this.person = person;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Person getPerson() {
        return person;
    }

    public boolean canMove() {
        return person.canMove();
    }
}
