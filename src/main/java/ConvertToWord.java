import java.io.IOException;
import java.text.CharacterIterator;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConvertToWord {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int NUMBER = in.nextInt();
        String res = convertToWords(NUMBER).toLowerCase();
        System.out.println(res);
        in.close();
    }
    /*
 * Complete the function below.
 */

    static String convertToWords(int N) {
        StringBuilder sb=new StringBuilder();
        Map<String,String> characterStringMap=new HashMap<>();
        characterStringMap.put("1","one");
        characterStringMap.put("2","two");
        characterStringMap.put("3","three");
        characterStringMap.put("4","four");
        characterStringMap.put("5","five");
        characterStringMap.put("6","six");
        characterStringMap.put("7","seven");
        characterStringMap.put("8","eight");
        characterStringMap.put("9","nine");
        characterStringMap.put("11","eleven");
        characterStringMap.put("12","twelve");
        characterStringMap.put("13","thirteen");
        characterStringMap.put("14","fourten");
        characterStringMap.put("15","fifteen");
        characterStringMap.put("16","sixteen");
        characterStringMap.put("17","seventeen");
        characterStringMap.put("18","eighteen");
        characterStringMap.put("19","nineteen");
        characterStringMap.put("0","zero");
        characterStringMap.put("10","ten");
        characterStringMap.put("20","twenty");
        characterStringMap.put("30","thirty");
        characterStringMap.put("40","fourty");
        characterStringMap.put("50","fifty");
        characterStringMap.put("60","sixty");
        characterStringMap.put("70","seventy");
        characterStringMap.put("80","eighty");
        characterStringMap.put("90","ninety");
        characterStringMap.put("100","hundred");
        String numberString=Integer.toString(N);
        char[] chars=numberString.toCharArray();
        if(chars.length==3){
            int number=Integer.parseInt(chars[1]+""+chars[2]);
            if(number>19) {
                sb.append(characterStringMap.get(chars[0] + "")).append(" hundred ").append(characterStringMap.get(new String(chars[1] + "0"))).append(" ").append(characterStringMap.get(chars[2] + ""));
            }else{
                sb.append(characterStringMap.get(chars[0] + "")).append(" hundred ").append(characterStringMap.get(new String(chars[1] +""+chars[2] )));
            }
            return sb.toString();
        }else if(chars.length==2){
            int number=Integer.parseInt(chars[0]+""+chars[1]);
            if(number>19) {
                sb.append(characterStringMap.get(new String(chars[0] + "0"))).append(" ").append(characterStringMap.get(chars[1] + ""));
            }else{
                sb.append(characterStringMap.get(new String(chars[0] + ""+chars[1] + "")));
            }
        }else if(chars.length==1){
            sb.append(characterStringMap.get(chars[0]+""));
        }else if(chars.length==4){
            int number=Integer.parseInt(chars[2]+""+chars[3]);
            if(number>19) {
                sb.append(characterStringMap.get(chars[0] + "")).append(" thousand ").append(characterStringMap.get(chars[1] + "")).append(" hundred ").append(characterStringMap.get(new String(chars[2] + "0"))).append(" ").append(characterStringMap.get(chars[3] + ""));
            }else{
                sb.append(characterStringMap.get(chars[0] + "")).append(" thousand ").append(characterStringMap.get(chars[1] + "")).append(" hundred ").append(characterStringMap.get(new String(chars[2] + ""+chars[3] + "")));
            }
        }else if(chars.length==5){
            int number=Integer.parseInt(chars[3]+""+chars[4]);
            if(number>19) {
                sb.append(characterStringMap.get(chars[0] + "0")).append(" ").append(chars[1] + "").append(" thousand ").append(characterStringMap.get(chars[2] + "")).append(" hundred ").append(characterStringMap.get(new String(chars[3] + "0"))).append(" ").append(characterStringMap.get(chars[4] + ""));
            }else{
                sb.append(characterStringMap.get(chars[0] + ""+chars[1])).append(" thousand ").append(characterStringMap.get(chars[2] + "")).append(" hundred ").append(characterStringMap.get(new String(chars[3] +""+chars[4] + "")));
            }
        }
        return sb.toString();

    }
}
