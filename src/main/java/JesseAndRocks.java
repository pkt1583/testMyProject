import java.io.BufferedInputStream;
import java.util.Scanner;

public class JesseAndRocks {
    private static boolean hasSkipped;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(new BufferedInputStream(System.in));
        int numberOfRocks=scanner.nextInt();
        int strength=scanner.nextInt();
        //int[] rocks=new int[numberOfRocks];
        int counter=0;
        int rockStrength;
        for(int i=0;i<numberOfRocks;i++){
            rockStrength=scanner.nextInt();
            if(rockStrength>strength){
                if(hasSkipped){
                    System.out.println(counter);
                    return;
                }else{
                    hasSkipped=true;
                }
            }else {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
