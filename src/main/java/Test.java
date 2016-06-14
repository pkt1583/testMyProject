import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
       // System.out.println(fibonacci(6));
      //  System.out.println(fibonacii(6));
        System.out.println(4%3);
    }

    static int fibonacii(int tillWhat){
        if(tillWhat==1){
            return tillWhat;
        }
        if(tillWhat==0){
            return tillWhat;
        }
        return fibonacii(tillWhat-1)+fibonacii(tillWhat-2);
    }
    public static long fibonacci(long number) {
        if ((number == 0) || (number == 1)) // base cases
            return number;
        else
            // recursion step
            return fibonacci(number - 1) + fibonacci(number - 2);
    }

    static void printAscii(){
        Scanner scanner=new Scanner(new BufferedInputStream(System.in));
        String input=scanner.next();
        char ch[]=input.toCharArray();
        for(int i=0;i<ch.length;i++){
            System.out.println((int)ch[i]);
        }
    }
}
