package StringAlgorithm;

import java.util.LinkedHashSet;

public class PermuteString {

    public static void permute(String s) {
        if (StringUtil.isEmpty(s)) {
            throw new RuntimeException("the string cannot be null or empty");
        }
        StringBuilder sb = new StringBuilder(s);
        permute(sb, 0, s.length() - 1);
    }

    public static void permute(StringBuilder sb, int start, int end) {
        if (start == end) {
            System.out.println(sb.toString());
        } else {
            for (int i = start; i <= end; i++) {
                if (needSwap(sb, start, i)) {
                    swap(sb, start, i);
                    permute(sb, start + 1, end);
                    swap(sb, start, i);
                }
            }
        }
    }

    public static boolean needSwap(StringBuilder sb, int start, int i) {
        for (int j = start; j < i; j++) {
            if (sb.charAt(j) == sb.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void swap(StringBuilder sb, int a, int b) {
        char temp = sb.charAt(a);
        sb.setCharAt(a, sb.charAt(b));
        sb.setCharAt(b, temp);
    }

    public static void main(String[] args) throws Exception {
        permute("aca");
    }

}
