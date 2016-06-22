package practise;

import java.util.Stack;

public class BaseConvert {
    public static void main(String[] args) {
        Long number = 7L;

        Stack<Long> values = new Stack<>();
        Long remainder;
        if(number==0){
            System.out.println(0);
            return;
        }
        while (true) {
            if (number <= 0) {
                break;
            }
            remainder = number % 7;
            values.push(remainder);
            number = number / 7;
        }

        StringBuilder sb=new StringBuilder();
        while (!values.empty()) {
            Long popedInteger=values.pop();
            sb.append(checkForRuleAndAppend(popedInteger));
        }
         System.out.println(sb.toString());
    }

    private static String  checkForRuleAndAppend(long popedInteger) {

        switch ((int) popedInteger){
            case 0:
                return 0+"";
            case 1:
                return "a";
            case 2:
                return "t";
            case 3:
                return "l";
            case 4:
                return "s";
            case 5:
                return "i";
            case 6:
                return "n";
             default:
                 return popedInteger+"";
        }
    }
}
