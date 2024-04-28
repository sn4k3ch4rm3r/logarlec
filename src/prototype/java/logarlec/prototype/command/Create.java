package logarlec.prototype.command;

import java.lang.reflect.Constructor;
import logarlec.prototype.Prototype;

public class Create implements Command {
	private String className;
	private String objectName;
	private String[] argsStr;

	public Create(String type, String name, String... args) {
		this.className = type;
		this.argsStr = args;
		this.objectName = name;
	}

	@Override
	public String execute() throws Exception {
		Class<?> type = null;
		String[] packages =
				{"logarlec.gameobjects", "logarlec.effects", "logarlec.items", "logarlec.util"};
		for (String packageName : packages) {
			try {
				type = Class.forName(packageName + "." + className);
				break;
			} catch (ClassNotFoundException e) {
				// Ignore and try the next package
			}
		}
		if (type == null) {
			throw new ClassNotFoundException("Class " + className + " not found in any package");
		}
		Class<?>[] argTypes = new Class<?>[argsStr.length];
		Object[] args = new Object[argsStr.length];
		for (int i = 0; i < argsStr.length; i++) {
			Object arg = Prototype.getObject(argsStr[i]);
			if (arg == null) {
				arg = Integer.parseInt(argsStr[i]);
			}
			args[i] = arg;
			argTypes[i] = arg.getClass();
		}
		Constructor<?> constructor = type.getDeclaredConstructor(argTypes);
		if (!constructor.canAccess(null)) {
			constructor.setAccessible(true);
		}
		Object object = constructor.newInstance(args);
		Prototype.addObject(objectName, object);
		return null;
	}

}
