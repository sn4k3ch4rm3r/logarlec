package logarlec.skeleton;

import logarlec.test.*;

import java.util.Scanner;

public class Skeleton {

	private static Logger logger;


	public static void main() {
		logger = new Logger();

		TestCollection testCollection = new TestCollection();
		testCollection.addTestCase(new DoorUseTest());
		testCollection.addTestCase(new RoomHideDoorsTest());
		testCollection.addTestCase(new RoomShowDoorsTest());
		testCollection.addTestCase(new RoomMergeTest());
		testCollection.addTestCase(new RoomMergeWithEffectTest());
		testCollection.addTestCase(new RoomSplitTest());
		testCollection.addTestCase(new RoomUpdateGasAndMaskTest());
		testCollection.addTestCase(new RoomUpdateNoTeachersTest());
		testCollection.addTestCase(new RoomUpdateRagEffectTest());
		testCollection.addTestCase(new RoomUpdateStudentTeacherTest());
		testCollection.addTestCase(new StudentDropMaskTest());
		testCollection.addTestCase(new StudentLinkTransistorTest());
		testCollection.addTestCase(new StudentPickupMaskTest());
		testCollection.addTestCase(new StudentPickupSlideRuleTest());
		testCollection.addTestCase(new StudentProtectedByBeerTest());
		testCollection.addTestCase(new TeacherPickupSlideruleTest());
		testCollection.addTestCase(new StudentUseBeerTest());
		testCollection.addTestCase(new StudentUseCamembertTest());
		testCollection.addTestCase(new StudentUseCodeOfStudiesTest());
		testCollection.addTestCase(new StudentUseMaskTest());
		testCollection.addTestCase(new StudentUseTransistorTest());

		testCollection.printSelector();

		Scanner scanner = new Scanner(System.in);
		int index = scanner.nextInt();

		testCollection.runTestCase(index - 1);
	}


	/**
	 * Függvény hívások naplózása
	 * 
	 * @param object Az az objektum, amin a függvény hívódik
	 * @param function A függvény neve
	 * @param params A függvény paraméterei, ha vannak.
	 */
	public static void logFunctionCall(Object object, String function, Object... params) {
		logger.logFunctionCall(object, function, params);
	}

	/**
	 * Objektum létrehozása naplózással
	 * 
	 * @param <T> A létrehozandó objektum típusa
	 * @param name Az objektum neve
	 * @param type A létrehozni kívánt objektum típusa
	 * @param params Konstruktor paraméterei, ha vannak.
	 * @return Az elkészült objektum
	 */
	public static <T> T createObject(String name, Class<T> type, Object... params) {
		return logger.createObject(name, type, params);
	}

	/**
	 * Függvény visszatérés naplózása
	 * 
	 * @param value Viszzatérési érték.
	 */
	public static void logReturn(Object value) {
		logger.logReturn(value);
	}

	/**
	 * Bemenet beolvasása standard bemenetről
	 * 
	 * @param <T> A kívánt bemenet típusa
	 * @param type A kívánt bemenet típusa. Támogatott értékek:
	 *        <ul>
	 *        <li>{@code Integer.class}</li>
	 *        <li>{@code Double.class}</li>
	 *        <li>{@code Boolean.class}</li>
	 *        </ul>
	 * @param message A konzolon beolvasásnál megjelenő üzenet
	 * @return A beolvasott érték
	 */
	public static <T> T getInput(Class<T> type, String message) {
		return logger.getInput(type, message);
	}
}
