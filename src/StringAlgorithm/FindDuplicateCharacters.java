package StringAlgorithm;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicateCharacters {

    public static void printDuplicateCharacters(String s){
        if(StringUtil.isEmpty(s)){
            System.out.println("the string cannot be null or empty");
            return;
        }
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(char c : chars){
            if(map.containsKey(c)){
                map.put(c,map.get(c) + 1);
            }else{
                map.put(c,1);
            }
        }
    }
}
