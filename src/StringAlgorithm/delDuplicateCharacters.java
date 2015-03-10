package StringAlgorithm;

import java.util.*;

public class delDuplicateCharacters {
    public static String delDupChars(String s){
        Set<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for(char c : set){
            sb.append(c);
        }
        return sb.toString();
    }

    public static String delDupChar(String s){
        Map<Character,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,1);
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(delDupChars("avsdsds"));
    }
}
