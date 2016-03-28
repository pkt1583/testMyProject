package hview;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConvertToWord {
    static Map<Integer, String> characterStringMap = new HashMap<>();

    public static void main(String[] args) {
        characterStringMap.put(1, "one");
        characterStringMap.put(2, "two");
        characterStringMap.put(3, "three");
        characterStringMap.put(4, "four");
        characterStringMap.put(5, "five");
        characterStringMap.put(6, "six");
        characterStringMap.put(7, "seven");
        characterStringMap.put(8, "eight");
        characterStringMap.put(9, "nine");
        characterStringMap.put(11, "eleven");
        characterStringMap.put(12, "twelve");
        characterStringMap.put(13, "thirteen");
        characterStringMap.put(14, "fourten");
        characterStringMap.put(15, "fifteen");
        characterStringMap.put(16, "sixteen");
        characterStringMap.put(17, "seventeen");
        characterStringMap.put(18, "eighteen");
        characterStringMap.put(19, "nineteen");
        characterStringMap.put(0, "zero");
        characterStringMap.put(10, "ten");
        characterStringMap.put(20, "twenty");
        characterStringMap.put(30, "thirty");
        characterStringMap.put(40, "fourty");
        characterStringMap.put(50, "fifty");
        characterStringMap.put(60, "sixty");
        characterStringMap.put(70, "seventy");
        characterStringMap.put(80, "eighty");
        characterStringMap.put(90, "ninety");
        characterStringMap.put(100, "hundred");
        Scanner scanner=new Scanner(new BufferedInputStream(System.in));
        int numberOfInput=scanner.nextInt();
        for (int i = 0; i < numberOfInput; i++) {
            System.out.println(convertedToWord(scanner.nextInt()));
        }

    }

    private static String convertedToWord(int number) {
        if (number <= 20) {
            return characterStringMap.get(number);
        } else if (number > 20 && number < 100) {
            int tempNumber = number / 10 * 10;
            String tens = characterStringMap.get(tempNumber);
            tempNumber = number % 10;
            tens = tens + " " + characterStringMap.get(tempNumber);
            return tens;
        } else if (number > 100 && number < 1000) {
            String tensConverted = convertedToWord(number % 100);
            int tempNumber = number / 100;
            return characterStringMap.get(tempNumber) + " hundred " + tensConverted;
        } else if (number > 1000 && number < 10000) {
            String hundredConverted = convertedToWord(number % 1000);
            int tempNumber = number / 1000;
            return characterStringMap.get(tempNumber) + " thousand " + hundredConverted;
        }
        return null;
    }
}
