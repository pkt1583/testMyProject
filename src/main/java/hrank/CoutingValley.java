package hrank;

import java.util.Arrays;
import java.util.Stack;

public class CoutingValley {
    public static void main(String[] args) {
        String steps = "UDDDUDUU";
        int numberOfSteps = 12;
        System.out.println(countValleys(numberOfSteps, steps));
    }

    static int countValleys(int numberOfSteps, String steps) {
        if (numberOfSteps == 2) {
            if (steps.equals("DU")) {
                return 1;
            } else if (steps.equals("UD")) {
                return 0;
            }
        }

        Stack<Character> stepsStack = new Stack<>();
        int numberOfValleys = 0;
        for (char c : steps.toCharArray()) {
            if (stepsStack.empty()) {
                stepsStack.push(c);
            } else {
                Character currentElement = stepsStack.peek();
                if (currentElement.equals('D')) {
                    if (c == 'U') {
                        stepsStack.pop();
                        if (stepsStack.empty()) {
                            numberOfValleys++;
                        }
                    }
                    if (c == 'D') {
                        stepsStack.push(c);
                    }
                } else if (currentElement.equals('U')) {
                    if (c == 'D') {
                        stepsStack.pop();
                    } else {
                        stepsStack.push(c);
                    }
                }
            }
        }
        return numberOfValleys;
    }
}
