import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    /*
 * Complete the function below.
 */

    static int maxDifference(int[] a) {
      int[] tempArray=Arrays.copyOf(a,a.length);
        Arrays.sort(tempArray);
        int maxNumber=tempArray[tempArray.length-1];
        int maxElementIndex=0;
        for(int i=0;i<a.length;i++){
            if(a[i]==maxNumber){
                maxElementIndex=i;
                break;
            }
        }
        if(tempArray[0]==tempArray[tempArray.length-1]){
            return 0;
        }
        if(maxElementIndex==0 && a.length>1){
            return -1;
        }else if(maxElementIndex==0){
            return maxNumber;
        }
        int[] tempArrays2=Arrays.copyOf(a,maxElementIndex);
        Arrays.sort(tempArrays2);
        int minNumber=tempArrays2[0];
        return maxNumber-minNumber;
    }

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        //final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int res;

        int _a_size = 0;
        _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(in.nextLine());
            _a[_a_i] = _a_item;
        }

        res = maxDifference(_a);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }
}