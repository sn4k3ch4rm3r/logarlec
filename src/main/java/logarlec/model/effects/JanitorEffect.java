package logarlec.model.effects;

import logarlec.model.gameobjects.Room;
import logarlec.model.gameobjects.Student;
import logarlec.model.gameobjects.Teacher;

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

    @Override
    public String toString() {
        return String.format("JanitorEffect <%d>\nHolder: <%d>\n", this.hashCode(),
                this.holder.hashCode());
    }
}
