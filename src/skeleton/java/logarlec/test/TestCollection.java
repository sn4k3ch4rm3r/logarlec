package logarlec.test;

import java.util.*;

/**
 * Tesztesetek kezelésére szolgáló osztály
 */
public class TestCollection {

    /**
     * A tesztesetek listája
     */
    List<TestCase> testCases = new ArrayList<>();

    /**
     * Teszteset hozzáadása a listához
     * 
     * @param testCase a teszteset
     */
    public void addTestCase(TestCase testCase) {
        testCases.add(testCase);
    }

    /**
     * A tesztesetek listázása
     */
    public void printSelector() {
        for (int i = 0; i < testCases.size(); i++) {
            System.out.println((i + 1) + ". " + testCases.get(i).name);
        }
        System.out.print("The chosen test number: ");
    }

    /**
     * Egy teszteset futtatása
     * 
     * @param index a futtatandó teszteset indexe
     */
    public void runTestCase(int index) {
        testCases.get(index).init();
        testCases.get(index).run();
    }
}
