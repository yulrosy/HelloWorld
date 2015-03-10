package StringAlgorithm;

public class CheckDigitsOnly {

    public static boolean checkContainsDigitsOnly(String s) {
        if (StringUtil.isEmpty(s)) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < 48 || c > 57) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkContainsDigitOnly(String s){
        return s.matches("\\d+");
    }

    public static void main(String[] args) {
        System.out.println(checkContainsDigitOnly("22321"));
    }
}
