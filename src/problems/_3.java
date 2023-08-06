package problems;

import java.util.HashSet;
import java.util.Set;

public class _3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        int r = 1;
        int l = 0;
        Set<Character> set = new HashSet<>();

        int max = 1;
        set.add(s.charAt(0));
        while (r < s.length()) {
            char ch = s.charAt(r);
            if (!set.contains(ch)) {
                set.add(ch);
                r++;
            } else {
                max = Math.max(max, set.size());
                while (!set.add(ch)) {
                    set.remove(s.charAt(l));
                    l++;
                }
                r++;
            }
        }
        max = Math.max(max, set.size());
        return max;
    }
}
