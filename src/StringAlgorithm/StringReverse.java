package StringAlgorithm;

public class StringReverse {

    public static String reverse(String s) {
        if (s == null) {
            throw new RuntimeException("the string cannot be null");
        }
        return s.length() < 2 ? s : new StringBuilder(s).reverse().toString();
    }

    public static String rever(String s) {
        if (s == null) {
            throw new RuntimeException("the string cannot be null");
        }
        if (s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    //递归  abcd→bcd+a→cd+b+a→d+c+b+a
    public static String revRecursively(String s){
        if (s == null) {
            throw new RuntimeException("the string cannot be null");
        }
        return s.length() < 2 ? s : revRecursively(s.substring(1)) + s.charAt(0);
    }
}
