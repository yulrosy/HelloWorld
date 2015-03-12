package StringAlgorithm;

public class FindLongestPalindrome {
    //S         1     2     2     1     2     3     2     1
    //T   ^  #  1  #  2  #  2  #  1  #  2  #  3  #  2  #  1  #  $  “^”和“$”是为了防止数组越界
    //P      1  2  1  2  5  2  1  4  1  2  1  6  1  2  1  2  1    记录以字符T[i](0<i<length-1)为中心的最长回文子串向左/右扩张的长度（包括T[i]）
//P_Index 0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18
    //可以看出，P[i]-1正好是原字符串中回文串的总长度
    public static String find(String s){
        if(StringUtil.isEmpty(s)){
            throw new RuntimeException("");
        }
        if (s.length() == 1) {
            return s;
        }
        String T = init(s);//添加"#"后的新字符串
        int n = T.length();
        int[] P = new int[n];
        int C = 0,//最大回文子串中心在T中的位置
            R = 0;//右边界
        for (int i = 1; i < n - 1; i++) {
            int i_mirror = 2 * C - i;//i关于C的对称位置
            P[i] = R > i ? Math.min(R - i, P[i_mirror]) : 1;
            while (T.charAt(i + P[i]) == T.charAt(i -P[i])) {
                P[i]++;
            }
            //If the palindrome centered at i does expand past R,
            // we update C to i, (the center of this new palindrome),
            // and extend R to the new palindrome’s right edge.
            if(i + P[i] > R){
                C = i;
                R = i + P[i];
            }
        }
        // Find the maximum element in P[n]  P[1]-P[n-2]
        int maxLen = 0,centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] - 1 > maxLen) {
                maxLen = P[i] - 1;
                centerIndex = i;
            }
        }
        //I(original) * 2 + maxLen = I(new) - 1
        int start = (centerIndex - 1 - maxLen) / 2;
        return s.substring(start,start + maxLen);
    }

    /**
     *填充“#”，开头加“^”，末尾加“$”，防止出现数组越界
     */
    public static String init(String s){
        if(StringUtil.isEmpty(s)){
            throw new RuntimeException("");
        }
        StringBuilder sb = new StringBuilder("^#");
        int len = s.length();
        for (int i = 0; i < len; i++) {
            sb.append(s.charAt(i)).append("#");
        }
        sb.append("$");
        return sb.toString();
    }
    /***************************方法2**************************************/
    public static String fn(String s) {
        if (StringUtil.isEmpty(s)) {
            throw new RuntimeException("");
        }
        if (s.length() == 1) {
            return s;
        }
        String longest = s.substring(0, 1);
        int strLen = s.length();
        for (int i = 0; i < strLen; i++) {
            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            longest = tmp.length() > longest.length() ? tmp : longest;
            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            longest = tmp.length() > longest.length() ? tmp : longest;
        }
        return longest;
    }
    // Find longest palindrome
    public static String helper(String s, int begin, int end) {
        int len = s.length();
        while (begin >= 0 && end < len && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }

    public static void main(String[] args) {
        System.out.println(find("babcbabcbaccba"));
        System.out.println(find("ccc"));
    }
}
