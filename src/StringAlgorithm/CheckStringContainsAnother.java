package StringAlgorithm;

public class CheckStringContainsAnother {
    public static int indexOf(String main, String sub) {
        if (StringUtil.isEmpty(main) || StringUtil.isEmpty(sub)) {
            return -1;
        }
        int mainLen = main.length(),
                subLen = sub.length();
        if (mainLen < subLen) {
            return -1;
        }
        int loop = mainLen - subLen;
        for (int i = 0; i < loop; i++) {
            if (main.substring(i, i + subLen).equals(sub)) {
                return i;
            }
        }
        return -1;
    }
}
