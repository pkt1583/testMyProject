package openbracket;

import java.util.Arrays;
import java.util.Scanner;

public class Fraud {
    public static void main(String[] args) {
        new Fraud().startProcess();
    }


    void startProcess(){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int d=scanner.nextInt();

        int[] elements=new int[n];
        for(int i=0;i<n;i++){
            elements[i]=scanner.nextInt();
        }

        int[] sortedElement;
        int notification=0;
        double median=0.0;
        //Arrays.
        for(int i=0;i+d<n;i++){
            sortedElement= Arrays.copyOfRange(elements,i,i+d);
           // Arrays.parallelSort(sortedElement);
            int numberItems=sortedElement.length;
            int midNumber = (int)(numberItems/2);
         //   median=numberItems %2 != 0 ? sortedElement[midNumber] : (sortedElement[midNumber] + sortedElement[midNumber-1])/2.0;
            median=findMedianUtil(sortedElement,(sortedElement.length)/2 + 1,0,sortedElement.length-1);
            if(elements[i+d]>=2.0*median){
                notification++;
            }
        }

        System.out.println(notification);
    }

    private static int findMedianUtil(int arr[],int k,int low,int high)
    {

        if(low == high)
        {
            return arr[low];
        }

        int m = partition(arr,low,high);

        int length = m - low + 1;

        if(length == k)
        {
            return arr[m];
        }

        if(length > k)
        {
            return findMedianUtil(arr,k,low,m-1);
        }
        else
        {
            return findMedianUtil(arr,k-length,m+1,high);
        }

    }


    private static int partition(int arr[],int low, int high)
    {
        int pivotValue = getPivotValue(arr, low, high);

        while(low < high)
        {
            while(arr[low] < pivotValue)
            {
                low ++;
            }

            while(arr[high] > pivotValue)
            {
                high--;
            }

            if(arr[low] == arr[high])
            {
                low ++;
            }
            else if(low < high)
            {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }

        }
        return high;
    }

    // Find pivot value, such the it is always 'closer' to the actual median
    private static int getPivotValue(int arr[],int low,int high)
    {
        // If number of elements in the array are small, return the actual median
        if(high-low+1 <= 9)
        {
            Arrays.sort(arr);
            return arr[arr.length/2];
        }


        int temp[] = null;

        int medians[] = new int[(int)Math.ceil((double)(high-low+1)/5)];
        int medianIndex = 0;

        while(low <= high)
        {
            temp = new int[Math.min(5,high-low+1)];

            for(int j=0;j<temp.length && low <= high;j++)
            {
                temp[j] = arr[low];
                low++;
            }

            Arrays.sort(temp);

            medians[medianIndex] = temp[temp.length/2];
            medianIndex++;
        }

        return getPivotValue(medians,0,medians.length-1);
    }
}
