import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BracketMatch {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }

    public static String isBalanced(String inputVal) {
        int currentIndex = 0;
        String[] bracketStack = new String[999999];
        Map matches = new HashMap();
        matches.put(")", "(");
        matches.put("]", "[");
        matches.put("}", "{");

        char[] input = inputVal.toCharArray();
        for (int i = 0; i < input.length; i++) {
            String oneChar = input[i] + "";
            if (currentIndex == 0) {
                bracketStack[currentIndex] = oneChar;
                currentIndex = currentIndex + 1;
            } else {
                if (matches.keySet().contains(oneChar)) {
                    String probableOpening = bracketStack[currentIndex - 1];
                    if (probableOpening.equals(matches.get(oneChar))) {
                        bracketStack[currentIndex - 1] = null;
                        currentIndex = currentIndex - 1;
                    } else {
                        return "NO";
                    }
                } else {
                    bracketStack[currentIndex] = oneChar;
                    currentIndex = currentIndex + 1;
                }
            }
        }
        if (currentIndex == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
