package logarlec.skeleton;

import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;
import logarlec.items.CodeOfStudies;

public class StudentUseCodeOfStudiesTest extends TestCase {
    Student student;
    Teacher teacher;
    CodeOfStudies codeOfStudies;
    public StudentUseCodeOfStudiesTest() {
        super("Student: use code of studies");
    }

    @Override
    public void init() {
        student = new Student();
        teacher = new Teacher();
        codeOfStudies = new CodeOfStudies();
        student.addItem(codeOfStudies);
    }

    @Override
    public void run() {
        student.interactTeacher(teacher);
    }
}
