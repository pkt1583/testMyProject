package practise;

import java.util.*;

public class SubString {
    public static void main(String[] args) {
        String inputString="abababababababababababababababababab";
      //  String  inputString="ababa";
        System.out.println(new SubString().process(inputString).size());
    }

    private Set<String> process(String input) {
        char[] chars=input.toCharArray();
        Set<String> subStrings=new LinkedHashSet<>();
        for(int i=0;i<chars.length;i++){
            subStrings.add(String.valueOf(chars[i]));
            subStrings.add(String.valueOf(Arrays.copyOf(chars,chars.length-i)));
            for(int j=0;j>chars.length-i;j--){
                subStrings.add(String.valueOf(Arrays.copyOfRange(chars,j,chars.length-i)));
            }
            subStrings.add(String.valueOf(Arrays.copyOfRange(chars,i,chars.length)));
            for(int j=chars.length-1;j> i;j--){
                subStrings.add(String.valueOf(Arrays.copyOfRange(chars,i,j)));
            }
            if(i<chars.length-i)
                subStrings.add(String.valueOf(Arrays.copyOfRange(chars,i,chars.length-i)));
        }

     /*   for(String s:subStrings){
            System.out.println(s);
        }*/

        return subStrings;
    }
}
