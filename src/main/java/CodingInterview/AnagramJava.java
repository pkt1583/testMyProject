package CodingInterview;

/**
 * Created by pankaj on 28/9/16.
 */
public class AnagramJava {
    public static void main(String[] args) {
        String first="fcrxzwscanmligyxyvym";
        String second="jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        int[] occurrences = new int[26];
        for (int i = 0; i < first.length(); i++) {
            occurrences[first.charAt(i) - 'a']++;
        }
        for (int j = 0; j < second.length(); j++) {
            occurrences[second.charAt(j) - 'a']--;
        }

        int numberNeeded = 0;
        for (int k = 0; k < 26; k++) {
            numberNeeded += Math.abs(occurrences[k]);
        }
        System.out.println(numberNeeded);
    }
}
