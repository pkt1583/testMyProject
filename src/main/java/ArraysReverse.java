import scala.Int;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of integers, find the subset of non-adjacent elements with the maximum sum. Calculate the sum of that subset.

For example, given an array

we have the following possible subsets:

Subset      Sum
[-2, 3, 5]   6
[-2, 3]      1
[-2, -4]    -6
[-2, 5]      3
[1, -4]     -3
[1, 5]       6
[3, 5]       8

Our maximum subset sum is

.

Function Description

Complete the

function in the editor below. It should return an integer representing the maximum subset sum for the given array.

maxSubsetSum has the following parameter(s):

    arr: an array of integers

Input Format

The first line contains an integer,
.
The second line contains space-separated integers

.

Constraints

Output Format

Return the maximum sum described in the statement.

Sample Input 0

5
3 7 4 6 5

Sample Output 0

13


 */
public class ArraysReverse {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(rotatedArray(input, 2)));
    }

    static int[] rotatedArray(int[] a, int numberOfRotation) {
        int[] returnArray = new int[a.length];
        int actualNumberOfRotations = numberOfRotation % a.length;
        if (actualNumberOfRotations == 0) {
            return a;
        } else {
            int startIndex = actualNumberOfRotations;
            for (int i = 0; i < a.length; i++) {
                returnArray[i] = a[startIndex];
                if (startIndex == a.length - 1) {
                    startIndex = 0;
                } else {
                    startIndex = startIndex + 1;
                }
            }
        }
        return returnArray;
    }

}
