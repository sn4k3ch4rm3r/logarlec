package logarlec.skeleton;

import java.util.Scanner;
import java.util.stream.Stream;

import logarlec.skeleton.*;;

public class Skeleton {
    public static void main() {
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

        testCollection.printSelector();

        int index = 0;

        // Read the index from the user

        Scanner scanner = new Scanner(System.in);
        index = scanner.nextInt();

        testCollection.runTestCase(index - 1);

    }
}
