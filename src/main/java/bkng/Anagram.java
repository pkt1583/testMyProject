package bkng;

import java.util.*;

public class Anagram {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String elements = null;
        Map<String,SortedSet<String>> map=new HashMap<>();
        SortedSet<String> sortedSet=new TreeSet<>();
        try {
            while ((elements = scanner.nextLine()) != null) {
                if (elements.trim().length() == 0) {
                    output(map);
                    return;
                }
                char ch[] = elements.toCharArray();
                Arrays.sort(ch);
                String st = String.valueOf(ch).trim();
                if (map.containsKey(st)) {
                    SortedSet<String> currentVal = map.get(st);
                    currentVal.add(elements);
                    map.put(st, currentVal);
                } else {
                    SortedSet<String> sortedSet1 = new TreeSet<>();
                    sortedSet1.add(elements);
                    map.put(st, sortedSet1);
                }
            }
        }catch (Exception e){
            output(map);
        }
    }

    private static void output(Map<String, SortedSet<String>> map) {
        SortedSet<String> finalSet=new TreeSet<>();
        for(Map.Entry<String,SortedSet<String >> entry:map.entrySet()){
            StringBuilder sb=new StringBuilder();
            Iterator<String> iterator=entry.getValue().iterator();
            while (iterator.hasNext()){
                sb.append(iterator.next());
                if(iterator.hasNext()){
                    sb.append(",");
                }
            }
            finalSet.add(sb.toString());
        }
        for(String st:finalSet){
            System.out.println(st);
        }
        return;
    }
}
