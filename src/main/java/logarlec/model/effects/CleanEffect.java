package logarlec.model.effects;

import logarlec.model.gameobjects.Room;
import logarlec.model.gameobjects.Student;
import logarlec.model.gameobjects.Teacher;

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

    @Override
    public void update(double deltaTime) {
        super.update(deltaTime);
        if (timeRemaining <= 0) {
            holder.removeEffect(this);
        }
    }

    @Override
    public String toString() {
        return String.format("CleanEffect <%d>\nHolder: <%d>\n", this.hashCode(),
                this.holder.hashCode());
    }
}
