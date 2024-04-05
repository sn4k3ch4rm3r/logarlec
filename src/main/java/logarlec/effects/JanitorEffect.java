package logarlec.effects;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;
import logarlec.skeleton.Skeleton;

public class JanitorEffect extends CleanEffect {
    @Override
    public void applyToStudent(Student target) {
        Skeleton.logFunctionCall(this, "applyToStudent", target);
        target.getOut();
        Skeleton.logReturn(void.class);
    }

    @Override
    public void applyToTeacher(Teacher target) {
        Skeleton.logFunctionCall(this, "applyToTeacher", target);
        target.getOut();
        Skeleton.logReturn(void.class);
    }
}
