package logarlec.effects;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;
import logarlec.skeleton.Skeleton;

public class CleanEffect extends Effect {
    @Override
    public void applyToStudent(Student target) {

    }

    @Override
    public void applyToTeacher(Teacher target) {

    }

    @Override
    public void update(double deltaTime) {
        Skeleton.logFunctionCall(this, "update", deltaTime);
        holder.interactCleanEffect(this);
        Skeleton.logReturn(void.class);
    }
}
