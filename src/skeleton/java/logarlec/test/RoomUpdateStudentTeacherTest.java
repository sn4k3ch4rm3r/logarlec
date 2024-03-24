package logarlec.test;

import logarlec.gameobjects.Room;
import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;
import logarlec.skeleton.Skeleton;

public class RoomUpdateStudentTeacherTest extends TestCase {
    Room room;
    Student student;
    Teacher teacher;
    public RoomUpdateStudentTeacherTest() {
        super("Room: update student and teacher");
    }

    @Override
    public void init() {
        room = Skeleton.createObject("room", Room.class);
        student = Skeleton.createObject("student", Student.class);
        teacher = Skeleton.createObject("teacher", Teacher.class);
        room.enter(student);
        room.enter(teacher);
    }

    @Override
    public void run() {
        room.update(1);
    }
}
