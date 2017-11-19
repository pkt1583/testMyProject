package earth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pallindrome {


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        for(int i=0;i<n;i++){
            process(scanner.next(),scanner.next());
        }
    }

    private static void process(String  firstNumber, String secondNumber) {
        List<StringBuilder> allPallindrome=new ArrayList<>();
        String firstPallindrome=getFirstPallindrome(firstNumber);
        while(true){
            if(Integer.parseInt(firstPallindrome)>Integer.parseInt(secondNumber)){
                break;
            }
            String firstTwo=firstNumber.substring(0,2);
            StringBuilder pallindrome=new StringBuilder();
            int intval=Integer.parseInt(firstTwo);
            int nextVal=intval+1;
            if(nextVal<10){
               pallindrome.append("0").append(nextVal).append(nextVal).append(0);
            }else{
                pallindrome.append(nextVal).append(new StringBuilder(String.valueOf(nextVal)).reverse().toString());
            }
            allPallindrome.add(pallindrome);
            firstPallindrome=pallindrome.toString();
        }
    }

    private static String getFirstPallindrome(String firstNumber) {
        while (true){
            if(firstNumber.substring(0,2).equals(firstNumber.substring(3,firstNumber.length()))){
                return firstNumber;
            }else {
                int integerVal=Integer.parseInt(firstNumber.substring(0,2));
                integerVal++;
                firstNumber=String.valueOf(integerVal);
                if(firstNumber.length()==1){
                    firstNumber="0"+firstNumber;
                }
            }
        }
    }
}
