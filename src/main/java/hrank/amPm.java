package hrank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by pankaj on 19-04-2016.
 */
public class amPm {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        String splitedTime[]=time.split(":");
        int addition=0;
        if(splitedTime[2].contains("PM") && Integer.parseInt(splitedTime[0])<12){
            addition=12;
        }
        if(splitedTime[2].contains("AM") && Integer.parseInt(splitedTime[0])==12){
            addition=-12;
        }

        int hour=Integer.parseInt(splitedTime[0])+addition;

        String  hourVal=hour<10?"0"+hour:hour+"";
        System.out.println(hourVal+":"+splitedTime[1]+":"+splitedTime[2].substring(0,2));
    }
}
