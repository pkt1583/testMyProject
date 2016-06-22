package wm;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class KinderGarden {
    public static void main(String[] args) {
        //int[] scores=new int[]{2,4,2,6,1,7,8,9,2,1};
     //   int[] scores=new int[]{1,2,2,3,4};
        Scanner scanner=new Scanner(new BufferedInputStream(System.in));
        int numberOfElements=scanner.nextInt();
        int scores[]=new int[numberOfElements];
        for(int i=0;i<numberOfElements;i++){
            scores[i]=scanner.nextInt();
        }
        System.out.println(distributeCandy(scores));

    }


   /* static int distributeCandy(int[] score){
        int candyCountArray[]=new int[score.length];
        int candyCount=1;
        candyCountArray[0]=candyCount;
        int currentScore=score[0];
        if(score.length>1){
            if(currentScore<score[1]){
                candyCountArray[1]=candyCountArray[0]+1;
            }
            for(int j=2;j<score.length;j=j+2){
                if(j+2<score.length+1){
                    if(score[j]<score[j+1]){
                        if(score[j]>score[j-1]){
                            candyCountArray[j] = candyCountArray[j - 1] + 1;
                        }else {
                            candyCountArray[j] = candyCountArray[j - 1] - 1;
                        }
                        candyCountArray[j+1]=candyCountArray[j]+1;
                    }else {
                        if(score[j]>score[j+1]){
                            candyCountArray[j+1]=1;
                            candyCountArray[j]=candyCountArray[j+1]+1;
                        }
                    }
                }else {
                    candyCountArray[j]=1;
                }
            }
        }

        int sum=0;
        for (int i = 0; i < candyCountArray.length; i++) {
            sum=sum+candyCountArray[i];
        }
        return sum;
    }*/

   static int distributeCandy(int[] score) {
       int candyCountArray[]=new int[score.length];
       int candyCount=1;
       candyCountArray[0]=candyCount;
       int currentScore=score[0];
       if(score.length>1){
           if(currentScore<score[1]){
               candyCountArray[1]=candyCountArray[0]+1;
           }
           for(int j=2;j<score.length;j=j+2){
               if(score[j]<score[j-1]){
                    candyCountArray[j]=candyCountArray[j-1]-1;
               }else {
                   candyCountArray[j-1]=candyCountArray[j];
                   candyCountArray[j]=candyCountArray[j-1]+1;
               }
           }
       }

       int sum=0;
       for (int i = 0; i < candyCountArray.length; i++) {
           sum=sum+candyCountArray[i];
       }
       return sum;
    }

    private static int getCandyAtEqualScore(int i,int[] score,int currentScore) {
        for (int j = 0; j <=  i; j++) {
            if(score[j]==currentScore){
                return j;
            }
        }
        return -1;
    }
}
