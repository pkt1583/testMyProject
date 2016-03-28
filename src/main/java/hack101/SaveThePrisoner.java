package hack101;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class SaveThePrisoner {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(new BufferedInputStream(System.in));
        int numberOfCases=scanner.nextInt();
        for(int i=0;i<numberOfCases;i++) {
            int numberOfPrisoners = scanner.nextInt();
            int numberOfSweets = scanner.nextInt();
            int prisonerId = scanner.nextInt();

            while (numberOfSweets>numberOfPrisoners){
                numberOfSweets=numberOfSweets-numberOfPrisoners;
            }
            int val=numberOfSweets+prisonerId-1;
            System.out.println(val);

        }
    }

}
