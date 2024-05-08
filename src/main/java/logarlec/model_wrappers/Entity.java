package logarlec.model_wrappers;

import logarlec.models.gameobjects.Person;

public class Entity {
    private Position position;
    private Person person;
    public Entity(Position position, Person person) {}

    public Position getPosition() {
        return position;
    }

    public Person getPerson() {
        return person;
    }
}
