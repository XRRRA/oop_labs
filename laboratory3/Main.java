package Laboratory3;

import static Laboratory3.Tests.testQueues;
import static Laboratory3.Tests.testStacks;

public class Main {
    public static void main(String[] args) {
        boolean queueTestsPassed = testQueues();
        boolean stackTestsPassed = testStacks();

        if (queueTestsPassed && stackTestsPassed) {
            System.out.println("All Tests are OK");
        } else {
            System.out.println("Tests Failed");
        }
    }
}