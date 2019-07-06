package hrank;

public class LilahRepeatedString {
    public static void main(String[] args) {
        System.out.println(repeatedString("aba", 10));
    }

    // Complete the repeatedString function below.
    static long repeatedString(String input, long numberRequred) {
        int inputlength = input.length();
        char ch[] = input.toCharArray();
        int occuranceOfa = 0;
        for (char c : ch) {
            if (c == 'a') {
                occuranceOfa++;
            }
        }
        long closestToNumberRequired = numberRequred / inputlength;
        long occuranceSoFar = occuranceOfa * closestToNumberRequired;
        long remaining = numberRequred % inputlength;
        for (int i = 0; i < remaining; i++) {
            if (ch[i] == 'a') {
                occuranceSoFar++;
            }
        }
        return occuranceSoFar;

    }
}
