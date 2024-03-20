package logarlec.gameobjects;

public class Student extends Person {
	boolean eliminated;
	public void setEliminated(boolean value) {
		eliminated = value;
	}

	@Override
	public void protectFromTeacher(Teacher target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'protectFromTeacher'");
	}

	@Override
	public void interactTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'interactTeacher'");
	}
}
