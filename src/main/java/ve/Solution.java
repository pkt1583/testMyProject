package ve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> comments = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String lineRead = null;
        while (true) {
            lineRead = br.readLine();
            if (lineRead == null || lineRead.trim().length() == 0) {
                for (String outpur : comments) {
                    System.out.println(outpur.trim());
                }
                return;
            }
            if (lineRead.startsWith("//")) {
                comments.add(lineRead);
            } else {
                if (lineRead.startsWith("/*")) {
                    comments.add(lineRead);
                    if (!lineRead.contains("*/")) {
                        while (true) {
                            if(!lineRead.contains("*/")) {
                                lineRead = br.readLine();
                                if(lineRead==null || lineRead.trim().length()==0){
                                    break;
                                }else {
                                    comments.add(lineRead);
                                }
                            }else {
                                break;
                            }
                        }
                    }
                }else {
                    int indexof=lineRead.indexOf("//");
                    if(indexof!=-1){
                        comments.add(lineRead.substring(indexof));
                    }
                }
            }
        }
    }
}
