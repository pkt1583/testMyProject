package bkng;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        int squareCount = 0;
        int rectangleCount = 0;
        int otherCount = 0;
        Scanner scanner= new Scanner(System.in);
        String elements = null;
        try {
            while ((elements = scanner.nextLine()) != null) {
                if (elements.trim().length() == 0) {
                    System.out.println(squareCount + " " + rectangleCount + " " + otherCount);
                    return;
                }
                String str[] = elements.split(" ");
                int[] integers = new int[str.length];
                for (int i = 0; i < str.length; i++) {
                    integers[i] = Integer.parseInt(str[i]);
                }
                if ((integers[0] < 0)||(integers[1] < 0) || ( integers[2] < 0) || (integers[3] < 0 )){
                        otherCount = otherCount + 1;
                        continue;

                } else if ((integers[0] == integers[1]) && (integers[1] == integers[2]) && (integers[2] == integers[3])) {
                    squareCount = squareCount + 1;
                } else if ((integers[0] == integers[2]) && (integers[1] == integers[3])) {
                    rectangleCount = rectangleCount + 1;
                } else {
                    otherCount = otherCount + 1;
                }
            }
        }catch (Exception e){
            System.out.println(squareCount + " " + rectangleCount + " " + otherCount);
        }
    }
}
