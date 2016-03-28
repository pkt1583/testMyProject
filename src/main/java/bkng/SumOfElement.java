package bkng;

import java.util.Scanner;

public class SumOfElement {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int finalAns=scanner.nextInt();
        int inpurs=scanner.nextInt();
        int arr[]=new int[inpurs];
        for(int i=0;i<inpurs;i++){
            arr[i]=scanner.nextInt();
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(i==j) continue;
                if((arr[i]+arr[j])==finalAns){
                    System.out.println(1);
                }
            }
        }
        System.out.println(0);
    }
}
