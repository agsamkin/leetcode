package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class _242 {
    public static void main(String[] args) {
        String s = "aacc", t = "ccac";
        var res = isAnagram(s, t);
        System.out.println(res);
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        final int UTF8 = 256;

        int[] chars = new int[UTF8];
        int len = s.length();

        for (int i = 0; i < len; i++) {
            int chS = s.charAt(i);
            chars[chS] = ++chars[chS];

            int chT = t.charAt(i);
            chars[chT] = --chars[chT];
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) {
                return false;
            }
        }

        return true;
    }

}
