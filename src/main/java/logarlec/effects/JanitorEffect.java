package logarlec.effects;

import logarlec.gameobjects.Room;
import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;

public class JanitorEffect extends CleanEffect {
    @Override
    public void applyToStudent(Student target) {
        target.getOut();
    }

    @Override
    public void applyToTeacher(Teacher target) {
        target.getOut();
    }

    @Override
    public void applyToRoom(Room target) {
        super.applyToRoom(target);
        target.clean();
    }
}
