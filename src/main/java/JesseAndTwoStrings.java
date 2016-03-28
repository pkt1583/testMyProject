import java.io.BufferedInputStream;
import java.util.Scanner;

public class JesseAndTwoStrings {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int noOfInputs = scanner.nextInt();

        for (int i = 0; i < noOfInputs; i++) {
            StringBuffer firstPart = new StringBuffer();
            StringBuffer secondPart = new StringBuffer();
            StringBuffer firstPartAnother = new StringBuffer();
            StringBuffer secondPartAnother = new StringBuffer();
            StringBuffer finalString = new StringBuffer();
            process(scanner.next(), firstPart, secondPart, firstPartAnother, secondPartAnother, finalString);
            //  System.out.println(finalString);
            firstPart = new StringBuffer();
            secondPart = new StringBuffer();
            firstPartAnother = new StringBuffer();
            secondPartAnother = new StringBuffer();
            //finalString=new StringBuffer();
            process(scanner.next(), firstPart, secondPart, firstPartAnother, secondPartAnother, finalString);
            System.out.println(finalString.length());

        }
    }

    static void process(String input, StringBuffer firstPart, StringBuffer secondPart, StringBuffer firstPartAnother, StringBuffer secondPartAnother, StringBuffer finalString) {
        char[] charArray = input.toCharArray();
        int size = input.length();
        compare(0, size - 1, charArray, firstPart, secondPart);
        StringBuffer sb = new StringBuffer(input).reverse();
        charArray = sb.toString().toCharArray();
        compare(0, size - 1, charArray, firstPartAnother, secondPartAnother);
        if (firstPart.length() > firstPartAnother.length()) {
            finalString.append(firstPart.append(secondPart.reverse()));
        } else {
            finalString.append(firstPartAnother.append(secondPartAnother.reverse()));
        }
    }

    static void compare(int firstIndex, int lastIndex, char[] chars, StringBuffer firstPartAnother, StringBuffer secondPartAnother) {
        if (chars[firstIndex] == chars[lastIndex]) {
            if (lastIndex > firstIndex) {
                firstPartAnother.append(chars[firstIndex]);
                secondPartAnother.append(chars[lastIndex]);
                compare(firstIndex + 1, lastIndex - 1, chars, firstPartAnother, secondPartAnother);
            } else {
                return;
            }
        } else {
            if (lastIndex > firstIndex) {
                compare(firstIndex, lastIndex - 1, chars, firstPartAnother, secondPartAnother);
            } else {
                return;
            }
        }
    }
}
