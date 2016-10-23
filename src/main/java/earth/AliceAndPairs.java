package earth;

import java.math.BigInteger;
import java.util.Scanner;

import static java.math.BigInteger.valueOf;

public class AliceAndPairs {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numberOfInput=scanner.nextInt();
        for(int i=0;i<numberOfInput;i++){
            System.out.println(process(scanner.nextInt())+1);
        }
    }

    private static int process(int input) {
        BigInteger one= valueOf(input);
        int numberOfFound=0;
        for(int i=2;i<input+1;i++){
            if(one.mod(valueOf(i)).equals(BigInteger.ZERO) && one.divide(valueOf(i)).gcd(valueOf(i)).equals(BigInteger.ONE)){
                numberOfFound++;
            }
        }
        return numberOfFound;
    }
}
