package hview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, String> characterStringMap = new HashMap<>();

    private static void initialize() {
        characterStringMap.put("1", "one");
        characterStringMap.put("2", "two");
        characterStringMap.put("3", "three");
        characterStringMap.put("4", "four");
        characterStringMap.put("5", "five");
        characterStringMap.put("6", "six");
        characterStringMap.put("7", "seven");
        characterStringMap.put("8", "eight");
        characterStringMap.put("9", "nine");
        characterStringMap.put("11", "eleven");
        characterStringMap.put("12", "twelve");
        characterStringMap.put("13", "thirteen");
        characterStringMap.put("14", "fourten");
        characterStringMap.put("15", "fifteen");
        characterStringMap.put("16", "sixteen");
        characterStringMap.put("17", "seventeen");
        characterStringMap.put("18", "eighteen");
        characterStringMap.put("19", "nineteen");
        characterStringMap.put("0", "zero");
        characterStringMap.put("10", "ten");
        characterStringMap.put("20", "twenty");
        characterStringMap.put("30", "thirty");
        characterStringMap.put("40", "fourty");
        characterStringMap.put("50", "fifty");
        characterStringMap.put("60", "sixty");
        characterStringMap.put("70", "seventy");
        characterStringMap.put("80", "eighty");
        characterStringMap.put("90", "ninety");
        characterStringMap.put("100", "hundred");
        characterStringMap.put("1000", "thousand");
        characterStringMap.put("100000", "lakh");
        characterStringMap.put("1000000", "million");
    }

    public static void main(String[] args) throws IOException {
        initialize();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = in.readLine()) != null) {
            StringBuilder sb=new StringBuilder();
            process(s,sb);
            System.out.println(sb);
        }
    }

    private static void process(String s,StringBuilder sb){
        char[] chars = s.toCharArray();
        if(chars.length==1){
            if(chars[0]!='0') {
                 sb.append(characterStringMap.get(chars[0] + ""));
            }
        }
        if(chars.length==2){
            int number = Integer.parseInt(chars[0] + "" + chars[1]);
            if(number!=0) {
                if (number > 19) {
                     sb.append(characterStringMap.get(new String(chars[0] + "0")));
                    process(chars[1] + "", sb);
                } else {
                     sb.append(characterStringMap.get(new String(chars[0] + "" + chars[1] + "")));
                }
            }
        }
        if(chars.length==3){
           sb.append(characterStringMap.get(new String(chars[0] + "" + chars[1] + "")));
            process(chars[1] + "" + chars[2],sb);
        }
        return ;
    }

   /* private static String process(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        if (chars.length == 3) {
            return processFor3(sb, chars);
        } else if (chars.length == 2) {
            processFor2(sb, chars);
        } else if (chars.length == 1) {
            sb.append(characterStringMap.get(chars[0] + ""));
        } else if (chars.length == 4) {
            int number = Integer.parseInt(chars[2] + "" + chars[3]);
            if (number > 19) {
                sb.append(characterStringMap.get(chars[0] + "")).append("thousand").append(characterStringMap.get(chars[1] + "")).append("hundred").append(characterStringMap.get(new String(chars[2] + "0"))).append(characterStringMap.get(chars[3] + ""));
            } else {
                sb.append(characterStringMap.get(chars[0] + "")).append("thousand").append(characterStringMap.get(chars[1] + "")).append("hundred").append(characterStringMap.get(new String(chars[2] + "" + chars[3] + "")));
            }
        } else if (chars.length == 5) {
            int number = Integer.parseInt(chars[0] + "" + chars[1]);
            if (number > 19) {
                sb.append(characterStringMap.get(chars[0] + "0")).append(chars[1] + "").append("thousand").append(characterStringMap.get(chars[2] + "")).append("hundred").append(characterStringMap.get(new String(chars[3] + "0"))).append(characterStringMap.get(chars[4] + ""));
            } else {
                sb.append(characterStringMap.get(chars[0] + "" + chars[1])).append("thousand").append(characterStringMap.get(chars[2] + "")).append("hundred").append(characterStringMap.get(new String(chars[3] + "" + chars[4] + "")));
            }
        }else if(chars.length==6){
            int number = Integer.parseInt(chars[4] + "" + chars[5]);
            if (number > 19) {
                sb.append(characterStringMap.get(chars[0]+"")).append("lakh").append(characterStringMap.get(chars[1])).append(chars[2] + "").append("thousand").append(characterStringMap.get(chars[3] + "")).append("hundred").append(characterStringMap.get(new String(chars[4] + "0"))).append(characterStringMap.get(chars[5] + ""));
            } else {
                sb.append(characterStringMap.get(chars[0]+"")).append("lakh").append(characterStringMap.get(chars[1] + "" + chars[2])).append("thousand").append(characterStringMap.get(chars[3] + "")).append("hundred").append(characterStringMap.get(new String(chars[4] + "" + chars[5] + "")));
            }
        }else if(chars.length==7){

        }else if(chars.length==8){

        }else if(chars.length==9){

        }else if(chars.length==10){

        }
        return sb.toString();
    }*/

    private static void processFor2(StringBuilder sb, char[] chars) {
        int number = Integer.parseInt(chars[0] + "" + chars[1]);
        if (number > 19) {
            sb.append(characterStringMap.get(new String(chars[0] + "0"))).append(characterStringMap.get(chars[1] + ""));
        } else {
            sb.append(characterStringMap.get(new String(chars[0] + "" + chars[1] + "")));
        }
    }

    private static String processFor3(StringBuilder sb, char[] chars) {
        int number = Integer.parseInt(chars[1] + "" + chars[2]);
        if (number > 19) {
            sb.append(characterStringMap.get(chars[0] + "")).append("hundred").append(characterStringMap.get(new String(chars[1] + "0"))).append(characterStringMap.get(chars[2] + ""));
        } else {
            sb.append(characterStringMap.get(chars[0] + "")).append("hundred").append(characterStringMap.get(new String(chars[1] + "" + chars[2])));
        }
        return sb.toString();
    }
}
