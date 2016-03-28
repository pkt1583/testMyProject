package va;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class StringSimilarity {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(new BufferedInputStream(System.in));
        int numberOnfInput=scanner.nextInt();
        String st[]=new String[numberOnfInput];
        for (int i=0;i<numberOnfInput;i++){
            st[i]=scanner.next();
            process(st[i]);
        }
    }

    private static void process(String s) {
        char ch[]=s.toCharArray();
        int sum=ch.length;
        for(int i=0;i<ch.length;i++){
            int temp=0;
            for(int j=i+1;j<ch.length;j++){
                if(ch[temp]==ch[j]){
                    sum++;
                    temp++;
                }else {
                    break;
                }
            }
        }
        System.out.println(sum);
    }
}
