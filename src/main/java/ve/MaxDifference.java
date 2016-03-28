package ve;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class MaxDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int[] arrayElement=new int[scanner.nextInt()];
        for(int i=0;i<arrayElement.length;i++){
            arrayElement[i]=scanner.nextInt();
        }
        System.out.println(getMaxElement(arrayElement));
    }

    private static int getMaxElement(int[] arrayElement) {
        int min=arrayElement[0],max=arrayElement[0],diff=0;
        int minindex=0;
        int maxIndex=0;
        for(int i=1;i<arrayElement.length;i++){
            if(arrayElement[i]<min ){
                min=arrayElement[i];
                minindex=i;
            }
            if(arrayElement[i]>max){
                max=arrayElement[i];
                maxIndex=i;
            }
            if(diff<(max-min) && maxIndex>=minindex){
                diff=max-min;
            }
        }
        if(diff==0){
            return -1;
        }else {
            return diff;
        }
    }

}
