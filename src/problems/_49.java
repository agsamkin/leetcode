package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _49 {
    private final static int UTF8 = 255;

    public static void main(String[] args) {
        var res = groupAnagrams(new String[]{"cab","tin","pew","duh","may","ill","buy","bar","max","doc"});
        System.out.println(res);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            String s1 = strs[i];
            if ((s1 == null)) {
                continue;
            }

            List<String> anagrams = new ArrayList<>();
            anagrams.add(s1);
            for (int j = i+1; j < strs.length; j++) {
               String s2 = strs[j];
               if ((s2 == null)) {
                    continue;
               }

               boolean isAnagram = isAnagram(s1, s2);
               if (isAnagram) {
                   anagrams.add(s2);
                   strs[j] = null;
               }
            }
            groups.add(anagrams);
        }
        return groups;
    }

    private static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] chars = new int[UTF8];
        int len = s1.length();

        for (int i = 0; i < len; i++) {
            int ch1 = s1.charAt(i);
            chars[ch1] = ++chars[ch1];
            int ch2 = s2.charAt(i);
            chars[ch2] = --chars[ch2];
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
