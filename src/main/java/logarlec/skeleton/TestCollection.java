package logarlec.skeleton;

import java.util.*;

public class TestCollection {
    List<TestCase> testCases = new ArrayList<TestCase>();

    public void addTestCase(TestCase testCase) {
        testCases.add(testCase);
    }

    public void printSelector() {
        System.out.println("Select a testcase to run: ");
        for (int i = 0; i < testCases.size(); i++) {
            System.out.println((i + 1) + ". " + testCases.get(i).name);
        }
        System.out.println("The chosen test number: ");
    }

    public void runTestCase(int index) {
        testCases.get(index).init();
        testCases.get(index).run();
    }
}
