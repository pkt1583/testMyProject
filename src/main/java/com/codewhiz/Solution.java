package com.codewhiz;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void print(int A[], int i) {
        StringBuilder sb = new StringBuilder();
        try {
            System.out.println(A[i]);
        } catch (ArrayIndexOutOfBoundsException aeob) {
            sb.append(aeob.getClass().getName());
        } finally {
            Arrays.sort(A);
            System.out.println(A[A.length-1] + " " + A[0]);
            if (sb.length() > 0) {
                System.out.println(sb.toString());
            }
        }

    }

    public static void main(String[] args) {
        int N;
        Scanner st = new Scanner(System.in);
        N = st.nextInt();
        int A[] = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = st.nextInt();
        }
        int i = st.nextInt();
        try {
            print(A, i);

        } catch (Exception e) {
            System.out.println(e.getClass().getName());
        }

    }// end of main
}// end of Solutio