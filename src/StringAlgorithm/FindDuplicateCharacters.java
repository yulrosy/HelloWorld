package StringAlgorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindDuplicateCharacters {

    public static void printDuplicateCharacters(String s){
        if(StringUtil.isEmpty(s)){
            System.out.println("Error : the string cannot be null or empty");
            return;
        }
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(char c : chars){
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }

        int flag = 0;
        Set<Map.Entry<Character,Integer>> entrySet = map.entrySet();
        for(Map.Entry<Character,Integer> entry : entrySet){
            if(entry.getValue()>1){
                flag++;
                System.out.printf("%s : %d %n", entry.getKey(), entry.getValue());
            }
        }
        if(flag == 0){
            System.out.println("There're no duplicate characters in the string");
        }
    }

    public static void main(String[] args) {
        printDuplicateCharacters("");
    }
}
