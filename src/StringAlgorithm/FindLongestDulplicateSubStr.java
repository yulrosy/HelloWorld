package StringAlgorithm;

import java.util.Arrays;

/**
 * 最长重复子串
 *
 后缀数组：假设一个字符串s="ababa",其后缀共有如下五个：
 1、 "ababa"
 2、 "baba"
 3、 "aba"
 4、 "ba"
 5、 "a"
 */
public class FindLongestDulplicateSubStr {

    //后缀数组解法
    //两个相邻位置的后缀数组比较，取其最长公共前缀
    public static String find(String s) {
        String[] suffixArr = getSuffixArray(s);
        int len = suffixArr.length;
        int max = -1,
            index = -1,//记录
            temp;
        for (int i = 0; i < len - 1; i++) {
            temp = getMaxPrefix(suffixArr[i],suffixArr[i+1]);
            if (temp > max) {
                max = temp;
                index = i;
            }
        }
        return index != -1 ? suffixArr[index].substring(0, max) : null;
    }

    public static int getMaxPrefix(String a,String b){
        if(StringUtil.isEmpty(a) || StringUtil.isEmpty(b)){
            return 0;
        }
        int i = 0,
            aLen = a.length(),
            bLen = b.length();
        while (a.charAt(i) == b.charAt(i) && i < aLen && i < bLen) {
            i++;
        }
        return i;
    }

    public static String[] getSuffixArray(String s){
        int len = s.length();
        String[] suffixArr = new String[len];
        for (int i = 0; i < len; i++) {
            suffixArr[i] = s.substring(i);
        }
        Arrays.sort(suffixArr);
        return suffixArr;
    }
}
