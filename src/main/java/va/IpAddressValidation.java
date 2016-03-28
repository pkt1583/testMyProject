package va;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class IpAddressValidation {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(new BufferedInputStream(System.in));
        int numberOfInput=scanner.nextInt();
        String[] str=new String[numberOfInput];
        for(int i=0;i<numberOfInput;i++){
            str[i]=scanner.next();
        }
        String st[]=check_IP(str);
        for(String s:st){
            System.out.println(s);
        }
    }

    private static String[] check_IP(String[] s) {
        String[] output=new String[s.length];
        int outputindex=0;
        for (int i = 0; i < s.length; i++) {
            String[] ipArray=s[i].split("\\.");
            boolean continueouter=false;
            if(ipArray.length>1){
                for(String st:ipArray){
                    try {
                        if (!(Integer.parseInt(st) <= 255)) {
                            output[outputindex] = "Neither";
                            outputindex++;
                            continueouter = true;
                            break;
                        }
                    }catch (Exception e){
                        output[outputindex]="Neither";
                        outputindex++;
                        continueouter=true;
                        break;
                    }

                }
                if(continueouter) {
                    continue;
                }else {
                    output[outputindex]="IPv4";
                    outputindex++;
                    continue;
                }
            }
            String[] ip6Array=s[i].split(":");
            if(ip6Array.length>1){
                for(String st:ip6Array){
                    if(!st.matches("^[0-9a-f]{1,4}")){
                        output[outputindex] = "Neither";
                        outputindex++;
                        continueouter = true;
                        break;
                    }
                }
                if(continueouter) {
                    continue;
                }else {
                    output[outputindex]="IPv6";
                    outputindex++;
                    continue;
                }
            }
            output[outputindex]="Neither";
            outputindex++;
            continue;
        }
        return output;
    }
}
