package am;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DelimitedWords {
    public static void main(String[] args) {
        String testString="This is, a test-String test. One";
        String st[]=testString.split("[,\\-\\s*:;.]");
        Set<String> set=new HashSet<String >();
        for(String string:st){
            if(string.trim().equals("")){
                continue;
            }
            if(set.contains(string)){
                return;
            }else {
                set.add(string);
            }
        }
    }
}
