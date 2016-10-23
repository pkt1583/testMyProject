package earth;

import java.util.Scanner;

public class VasyaAndMathematics {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int size=scanner.nextInt();
        int[] input=new int[size];
        int[] fx=new int[size];
        for(int i=0;i<size;i++){
            input[i]=scanner.nextInt();
            fx[i]=calculateFx(input[i]);
        }
        int numberOfqueries=scanner.nextInt();
        for(int i=0;i<numberOfqueries;i++){
            System.out.println( process(input,fx,scanner.nextInt(),scanner.nextInt()));
        }

    }

    private static int calculateFx(int input) {
        for(int i=input-1;i>1;i--){
            if(input%i==0){
                return i;
            }
        }
        return 0;
    }

    private static int process(int[] input, int[] fx,int l,int  r) {
        int product=1;
        for(int i=0;i<input.length;i++){
            if(fx[i]>=l && fx[i]<=r){
                product=product*fx[i];
            }
        }
        return product;
    }
}
