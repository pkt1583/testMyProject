package va;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class KSubSequence {

    static long kSub(int k, int[] nums) {
        int numberOfSubSequence=0;

        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum=sum+nums[j];
                if(sum%k==0){
                    numberOfSubSequence++;
                }
            }
        }
        return numberOfSubSequence;

    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long res;
        int _k;
        _k = Integer.parseInt(in.nextLine());


        int _nums_size = Integer.parseInt(in.nextLine());
        int[] _nums = new int[_nums_size];
        int _nums_item;
        for(int _nums_i = 0; _nums_i < _nums_size; _nums_i++) {
            _nums_item = Integer.parseInt(in.nextLine());
            _nums[_nums_i] = _nums_item;
        }

        res = kSub(_k, _nums);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }
}
