package logarlec.skeleton;

import logarlec.gameobjects.Room;
import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;

public class RoomUpdateStudentTeacherTest extends TestCase {
    Room room;
    Student student;
    Teacher teacher;
    public RoomUpdateStudentTeacherTest() {
        super("Room: update student and teacher");
    }

    @Override
    public void init() {
        room = new Room();
        student = new Student();
        teacher = new Teacher();
        room.enter(student);
        room.enter(teacher);
    }

    @Override
    public void run() {
        room.update(1);
    }
}
