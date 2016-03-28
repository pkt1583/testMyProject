package sorting;

import java.io.IOException;
import java.util.Arrays;
import java.util.Timer;

public class Sort {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        //      String inputLine=bufferedReader.readLine();
        //
        String inputLine = "1 5 3 8 9 4 10";
        String inputArray[] = inputLine.split(" ");
        int inputInteger[] = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            inputInteger[i] = Integer.parseInt(inputArray[i]);
        }

        int[] sortedElement = insertionSort(inputInteger);
        System.out.print(" Insertion sorted elements ");
        for (int el : sortedElement) {
            System.out.print(+el + " ");
        }
        System.out.println();
        sortedElement = selectionSort(inputInteger);
        System.out.print(" Selection sorted elements ");
        for (int el : sortedElement) {
            System.out.print(el + " ");
        }
        System.out.println();
        sortedElement = bubbleSort(inputInteger);
        System.out.print(" Bubble sorted elements ");
        for (int el : sortedElement) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    private static int[] bubbleSort(int[] inputInteger) {
        int sortedElements[] = Arrays.copyOf(inputInteger, inputInteger.length);
        boolean swappedAtleastOne = false;
        for (int i = 0; i < sortedElements.length; i++) {
            for (int j = 0; j < sortedElements.length - 1; j++) {
                if (sortedElements[j] > sortedElements[j + 1]) {
                    swap(j, j + 1, sortedElements);
                    swappedAtleastOne = true;
                }
            }
            if (!swappedAtleastOne) {
                break;
            }
        }
        return sortedElements;
    }

    private static int[] selectionSort(int[] inputInteger) {
        int sortedElements[] = Arrays.copyOf(inputInteger, inputInteger.length);
        for (int i = 0; i < sortedElements.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < sortedElements.length; j++) {
                if (sortedElements[j] < sortedElements[minIndex]) {
                    minIndex = j;
                }
            }
            swap(i, minIndex, sortedElements);
        }
        return sortedElements;
    }

    private static int[] insertionSort(int[] inputInteger) {
        int sortedElements[] = Arrays.copyOf(inputInteger, inputInteger.length);
        for (int i = 0; i < inputInteger.length; i++) {
            int temp = sortedElements[i];
            for (int j = i - 1; j >= 0; j--) {
                if (temp < sortedElements[j]) {
                    swap(j, j + 1, sortedElements);
                }
            }
        }

        return sortedElements;
    }

    private static void swap(int j, int i, int[] sortedElements) {
        int temp = sortedElements[i];
        sortedElements[i] = sortedElements[j];
        sortedElements[j] = temp;
    }
}
