package logarlec.effects;

import logarlec.gameobjects.Room;
import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;

public class CleanEffect extends Effect {
    @Override
    public void applyToStudent(Student target) {

    }

    @Override
    public void applyToTeacher(Teacher target) {

    }

    @Override
    public void applyToRoom(Room target) {
        target.interactCleanEffect(this);
    }
}
