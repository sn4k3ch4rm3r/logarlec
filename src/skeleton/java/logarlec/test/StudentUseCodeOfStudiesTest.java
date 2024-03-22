package logarlec.test;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;
import logarlec.items.CodeOfStudies;
import logarlec.skeleton.Skeleton;

public class StudentUseCodeOfStudiesTest extends TestCase {
    Student student;
    Teacher teacher;
    CodeOfStudies codeOfStudies;
    public StudentUseCodeOfStudiesTest() {
        super("Student: use code of studies");
    }

    @Override
    public void init() {
        student = Skeleton.createObject("student", Student.class);
        teacher = Skeleton.createObject("teacher", Teacher.class);
        codeOfStudies = Skeleton.createObject("codeOfStudies", CodeOfStudies.class);
        student.addItem(codeOfStudies);
    }

    @Override
    public void run() {
        student.interactTeacher(teacher);
    }
}
