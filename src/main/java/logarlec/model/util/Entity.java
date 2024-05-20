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

    public Person getPerson() {
        return person;
    }
}
