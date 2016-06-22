package practise;

import java.util.ArrayList;
import java.util.List;

public class SeeAndTell {
    public static void main(String[] args) {
        String inputNumber = "11";
        int numberofiteration=3;
        for (int i = 0; i < numberofiteration; i++) {
            inputNumber=process(inputNumber);
        }
        System.out.println(inputNumber);
    }

    private static String process(String inputNumber) {
        List<Integer> resultArray = new ArrayList<>();
        char ch[] = inputNumber.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char current = ch[i];
            int numberOfElements = 1;
            boolean processedInInner = false;
            for (int j = i + 1; j < ch.length; j++) {
                processedInInner = true;
                char nextElement = ch[j];
                if (current == nextElement) {
                    numberOfElements++;
                    if(j==ch.length-1){ //last Element equal
                        resultArray.add(numberOfElements);
                        resultArray.add(Character.getNumericValue(current));
                        i=j;
                        break;
                    }
                } else {
                    resultArray.add(numberOfElements);
                    resultArray.add(Character.getNumericValue(current));
                    i = j - 1; //as it does i++
                    break;
                }
            }
            if (!processedInInner) {
                resultArray.add(1);
                resultArray.add(Character.getNumericValue(current));
            }
        }
        StringBuilder sb=new StringBuilder();
        for(Integer i:resultArray){
            sb.append(i);
        }
        return sb.toString();

    }
}
