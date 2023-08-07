package problems;

import java.util.Stack;

public class _424 {
    public static void main(String[] args) {
        System.out.println(characterReplacement("ABCC", 3));
    }

    public static int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static int _characterReplacement(String s, int k) {
        if (s.length() == 1) {
            return 1;
        }

        String rs = new StringBuilder(s).reverse().toString();
        return Math.max(checkString(s, k), checkString(rs, k));

    }

    public static int checkString(String s, int k) {
        int l = 0;
        int r = 1;

        int max = 1;

        int anotherCh = s.charAt(0);

        while (r < s.length()) {
            char ch = s.charAt(l);
            if (ch != s.charAt(r)) {
                anotherCh = ch;
            }

            int tmp_k = k;
            while (r < s.length() && (tmp_k > 0 || s.charAt(r) == ch)) {
                if (s.charAt(r) != ch) {
                    tmp_k--;
                }
                r++;
            }
            max = Math.max(max, r - l);
            l++;
            r = l + 1;
        }

        int tmp_k = k;
        if (tmp_k > 0 && anotherCh != s.charAt(0)) {
            l = 0;
            r = 1;
            tmp_k--;
            while (r < s.length() && (tmp_k > 0 || s.charAt(r) == anotherCh)) {
                if (s.charAt(r) != anotherCh) {
                    tmp_k--;
                }
                r++;
            }
            max = Math.max(max, r - l);
        }

        return max;
    }

}
