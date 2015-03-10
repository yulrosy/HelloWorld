package StringAlgorithm;

import java.util.*;

public class FindFirstNonRepeatedChar {

    /**
     * use Set & ArrayList
     */
    public static char findFirstNonRepeatedChar(String s) {
        if(StringUtil.isEmpty(s)){
            throw new RuntimeException("the string cannot be null or empty");
        }
        Set<Character> rep = new HashSet<>();
        List<Character> norep = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (rep.contains(c)) {
                continue;
            }
            if (norep.contains(c)) {
                norep.remove((Character) c);//直接传入c,会被当成索引
                rep.add(c);
            } else {
                norep.add(c);
            }
        }
        if(norep.isEmpty()){
            throw new RuntimeException("didn't find any non-repeated Character");
        }
        return norep.get(0);
    }

    /**
     * use LinkedHashMap
     */
    public static char getFirstNonRepeatedChar(String s) {
        if(StringUtil.isEmpty(s)){
            throw new RuntimeException("the string cannot be null or empty");
        }
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }
        for (char c : chars) {
            if(map.get(c)==1){
                return c;
            }
        }
        throw new RuntimeException("didn't find any non-repeated Character");
    }

    /**
     * use HashMap
     */
    public static char firstNonRepeatedChar(String s){
        if(StringUtil.isEmpty(s)){
            throw new RuntimeException("the string cannot be null or empty");
        }
        char[] chars = s.toCharArray();
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        for(char c:chars){
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }
        Set<Map.Entry<Character,Integer>> set = map.entrySet();
        for(Map.Entry<Character,Integer> entry : set){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        throw new RuntimeException("didn't find any non-repeated Character");
    }
}
