package techgig;

import scala.Int;

import java.util.*;

public class Solution {
    private static Integer modulo=1000000007;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numberOfinput=scanner.nextInt();
        int[] inputs=new int[numberOfinput];
        for (int i = 0; i < numberOfinput; i++) {
            inputs[i]=scanner.nextInt();
        }
        LinkedList<LinkedList<Integer>> finalList=new LinkedList<>();
        for (int i = 0; i < inputs.length; i++) {
            LinkedList<Integer> tempList=new LinkedList<>();
            tempList.add(inputs[i]);
            finalList.add(tempList);
            for (int j = i+1; j < inputs.length; j++) {
                LinkedList<Integer> newTemp=new LinkedList<>();
                newTemp.addAll(finalList.getLast());
                newTemp.add(inputs[j]);
                finalList.add(newTemp);
            }

        }

        Integer finalAnswer=0;
        for (int i = 0; i < finalList.size(); i++) {
            LinkedList<Integer> elements= finalList.get(i);
            int maxElement=elements.getLast();
            int answer=0;
            for (int j = 0; j < elements.size(); j++) {
                answer=answer+(maxElement*elements.get(j))%modulo;
            }
            finalAnswer=finalAnswer+answer;
        }
        System.out.println(finalAnswer);
    }
}
