package logarlec.gameobjects;


import java.util.List;

public class Student extends Person {
	private boolean eliminated;

	private List<Teacher> immuneToTeacher;

	public void setEliminated(boolean value) {
		eliminated = value;
	}

	@Override
	public void protectFromTeacher(Teacher target) {
		immuneToTeacher.add(target);
	}

	@Override
	public void interactTeacher(Teacher teacher) {
		if (immuneToTeacher.contains(teacher)) {
			return;
		}
		inventory.protectFrom(teacher);
	}
}
