package logarlec.gameobjects;

public class Teacher extends Person {
	boolean peaceful;
	public void setPeaceful(boolean value) {
		peaceful = value;
	}

	@Override
	public void protectFromTeacher(Teacher target) {
		setPeaceful(true);

	}

	@Override
	public void interactTeacher(Teacher teacher) {

	}
}
