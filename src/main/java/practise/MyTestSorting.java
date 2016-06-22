package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyTestSorting {


    public static void main(String[] args) {
       // List<Integer> list1 = new ArrayList<>(Arrays.asList(2,4,5,9,9));
        int[] list1=new int[]{2,4,5,9,9};
        //List<Integer> list2 = new ArrayList<>(Arrays.asList(0,1,2,3,4));
        int[] list2=new int[]{0,1,2,3,4};
        List<Integer> finalList = new ArrayList<>();
        merge(list1, list2, 0, 0,finalList);
        //System.out.println((int[])finalList.toArray(new Integer[1]));
    }

    private static void merge(int[] list1, int[] list2, int index1, int index2,List<Integer> finalList) {
        if (index1 < list1.length && index2 < list2.length) {
            Integer element1 = list1[index1];
            Integer element2 = list2[index2];
            if (element1 <= element2) {
                finalList.add(element1);
                merge(list1, list2, ++index1, index2,finalList);
            } else {
                finalList.add(element2);
                merge(list1, list2, index1, ++index2,finalList);
            }
        }else {
            if(index1<list1.length){
                for (int i = index1; i < list1.length; i++) {
                    finalList.add(list1[i]);
                }
            }else if(index2<list2.length){
                for (int i = index2; i < list2.length; i++) {
                    finalList.add(list2[i]);
                }
            }
        }
    }


}
