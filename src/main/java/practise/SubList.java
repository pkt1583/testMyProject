package practise;

import java.util.*;

public class SubList {
    public static void main(String[] args) {
        List<Integer> list1 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));

        List<Integer> list2 = new LinkedList<>(Arrays.asList(5,4));

        if(list1.containsAll(list2)){
            System.out.println("Y");
        }else {
            System.out.println("N");
        }

        System.exit(0);
        for (int i = 0; i < list1.size(); i++) {
            int searchElement = list1.get(i);
            int tempIndex = i;
            boolean found = false;
            for (int j = 0; j < list2.size(); j++) {
                if(j<list2.size()-1 && i==list1.size()-1 ){

                }
                int subElement = list2.get(j);

                if (searchElement == subElement) {
                    found = true;
                    if (j == list2.size() - 1) {
                        System.out.println(i);
                        return;
                    }
                    searchElement = list1.get(++tempIndex);
                } else {
                    found = false;
                    break;
                }
            }
            if (found) {
                System.out.println(i);
                return;
            }

        }
       // System.out.println(-1);

    }
}
