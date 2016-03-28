import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        System.out.println(convert(1193046));
    }

    static String convert(long input) {
        Map<String, String> map = new HashMap<>();
        map.put("0", "0");
        map.put("1", "a");
        map.put("2", "t");
        map.put("3", "l");
        map.put("4", "s");
        map.put("5", "i");
        map.put("6", "n");
        String base7 = Long.toString(input, 16);
        System.out.println(base7);
        String ans = "";
        for (int i = 0; i < base7.length(); i++) {
            ans += map.get(String.valueOf(base7.charAt(i)));
        }
        return ans;
//123456
    }

}
