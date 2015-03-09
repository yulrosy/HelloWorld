package StringAlgorithm;

import java.util.Arrays;

/**
 *
 */
public class CheckAnagram {

    public static boolean isAnagram(String s,String an){
        if (StringUtil.isEmpty(s) || StringUtil.isEmpty(an) || s.length()!=an.length()) {
            return false;
        }
        char[] sarr = s.toLowerCase().toCharArray();
        char[] anarr = an.toLowerCase().toCharArray();
        Arrays.sort(sarr);
        Arrays.sort(anarr);
        return Arrays.equals(sarr,anarr);
    }

    public static boolean checkAnagram(String s, String an) {
        if (StringUtil.isEmpty(s) || StringUtil.isEmpty(an) || s.length()!=an.length()) {
            return false;
        }
        char[] chars = s.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder(an);
        for (char c : chars) {
            int index = sb.indexOf(c + "");
            if (index > -1) {
                sb.deleteCharAt(index);
            } else {
                return false;
            }
        }
        return sb.toString().length() == 0;
    }

    public static boolean ckAnagram(String s,String an){
        if (StringUtil.isEmpty(s) || StringUtil.isEmpty(an) || s.length()!=an.length()) {
            return false;
        }
        char[] chars = s.toLowerCase().toCharArray();
        for(char c:chars){
            int index = an.indexOf(c+"");
            if(index>-1){
                an = an.substring(0,index) + an.substring(index+1);
            }else{
                return false;
            }
        }
        return an.isEmpty();//an.length() == 0
    }
}
