package hview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MainOld {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = in.readLine()) != null) {
            String str[]=s.split(" ");
            int numberOfRecords=Integer.parseInt(str[0]);
            int input[]=new int[numberOfRecords];
            for(int i=0;i<numberOfRecords;i++){
                input[i]=Integer.parseInt(str[i+1]);
            }
            int max=process(input);
            if(max==input[1]){
                System.out.println(0);
            }else{
                System.out.println(max);
            }

        }


    }

    private static int process(int[] input) {
        SortedSet<Integer> maxArray=new TreeSet<>();
        int max=input[0];
        int newMax=max;
        for(int i=1;i<input.length;i++){
            newMax=max+input[i];
            if(newMax>0){
                maxArray.add(newMax);
                max=newMax;
            }else{
                max=input[i];
            }
        }
        if(maxArray.size()>0) {
            return maxArray.last();
        }else{
            return 0;
        }
    }
}
