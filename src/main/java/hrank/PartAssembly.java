package hrank;//23280666175399
 //       23280666175399

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.List;
import java.util.Collections;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class PartAssembly
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int minimumTime(int numOfParts, List<Integer> parts) {
        Collections.sort(parts);
        int totalSum = 0;
        if (numOfParts == 2) {
            return parts.get(0) + parts.get(1);
        }
        if (numOfParts == 1) {
            return parts.get(0);
        }
        if (numOfParts == 0) {
            return 0;
        }
        int elementIndex = 2;
        int initialSumOfElements = parts.get(0) + parts.get(1);
        while (true) {
            totalSum = totalSum + initialSumOfElements;
            if (elementIndex < numOfParts) {

                initialSumOfElements = initialSumOfElements + parts.get(elementIndex);
                elementIndex++;
            } else {
                break;
            }
        }
        return totalSum;
    }
    // METHOD SIGNATURE ENDS
}