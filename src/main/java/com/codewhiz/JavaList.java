package com.codewhiz;

import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class JavaList {
    static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int numberOfElementsInList = scanner.nextInt();
        for (int i = 0; i < numberOfElementsInList; i++) {
            list.add(scanner.nextInt());
        }
        int numberOfQueries = scanner.nextInt();
        for (int i = 0; i < numberOfQueries; i++) {
            String query = scanner.next();
            if (query.equals("Insert")) {
                list.add(scanner.nextInt(), scanner.nextInt());
            } else if (query.equals("Delete")) {
                list.remove(scanner.nextInt());
            }
        }
        for(Integer integer:list){
            System.out.print(integer+" ");
        }
    }
}
