package practise;

import java.util.*;

public class ParenthesisMatch {
    // static Map<MatchPair,Object> parenthesis= new HashMap<>();
    static Set<Character> start = new HashSet<>();
    static Map<Character, Character> end = new HashMap<>();

    public ParenthesisMatch() {

    }

    public static void main(String[] args) {
        String input = "{[}]";
        start.add('(');
        start.add('{');
        end.put(')', '(');
        start.add('[');
        end.put(']', '[');
        end.put('}','{');
        System.out.println(isBalance(input));
    }

    static boolean isBalance(String input) {
        Stack stack = new Stack<>();
        char ch[] = input.toCharArray();
        for (char c : ch) {
            if (start.contains(c)) {
                stack.push(c);
            } else if (end.containsKey(c)) {
                char startChar = end.get(c);
                if(stack.empty()){
                    return false;
                }
                char stackCh = (char) stack.pop();
                if (startChar != stackCh) {
                    return false;
                }
            }
        }
        if(!stack.empty()){
            return false;
        }
        return true;
    }

}
