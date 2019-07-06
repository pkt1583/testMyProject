package hrank;

import java.util.Arrays;

public class JumpingOnCloud {
    public static void main(String[] args) {
        int cloudArray[];
        cloudArray = new int[]{0, 0, 1, 0, 0, 1, 0};
        int numberOfInput = 7;
        System.out.println(jumpingOnClouds(cloudArray));
    }

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] cloudArray) {
        int jumpcount = 0;
        for (int i = 1; i < cloudArray.length; i++) {
            int step1Value = cloudArray[i];
            int step2Value = 1;
            if (i != cloudArray.length - 1) {
                step2Value = cloudArray[i + 1];
            }
            if (step1Value == 0 && step2Value == 0) {
                i = i + 1;
                jumpcount++;
            } else if (step1Value == 0 && step2Value == 0) {
                jumpcount++;
            } else if (step1Value == 1 && step2Value == 0) {
                i = i + 1;
                jumpcount++;
            }else if(step1Value==0 && step2Value==1){
                jumpcount++;
            }
        }
        return jumpcount;
    }
}
