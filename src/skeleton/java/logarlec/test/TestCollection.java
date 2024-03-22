package logarlec.test;

import java.util.*;

public class TestCollection {
    List<TestCase> testCases = new ArrayList<>();

    public void addTestCase(TestCase testCase) {
        testCases.add(testCase);
    }

    public void printSelector() {
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
