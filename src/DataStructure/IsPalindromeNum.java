package DataStructure;

public class IsPalindromeNum {

    public static boolean check(int num) {
        return num == reverse(num);
    }

    public static int reverse(int n) {
        int reverse = 0;
        while (n != 0) {
            reverse = reverse * 10 + n % 10;
            n /= 10;
        }
//        System.out.println("反转后为：" + reverse);
        return reverse;
    }
}
