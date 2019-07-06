package practise;

public class RecommendedSubSequence {
    public static void main(String[] args) {
        String baseString = "abppplee";
        String elements[] = {"able", "ale", "apple", "bale", "kangaroo"};
        int maxSoFar = 0;
        String maxElement = null;
        for (String element : elements) {
            int current = getLength(baseString, element.toCharArray());
            if (maxSoFar < current) {
                maxSoFar = current;
                maxElement = element;
            }
        }
        System.out.println(maxElement);
    }

    public static int getLength(String baseString, char[] subString) {
        int previouslocation = 0;
        for (char ch : subString) {
            previouslocation = findCharInStringAfterLocation(previouslocation, ch, baseString);
            if (previouslocation == -1) {
                return -1;
            }
        }
        return subString.length;
    }

    private static int findCharInStringAfterLocation(int location, char ch, String baseString) {
        char baseStringArray[] = baseString.toCharArray();
        for (int i = location; i < baseStringArray.length; i++) {
            if (baseStringArray[i] == ch) {
                return i;
            }
        }
        return -1;
    }


}
