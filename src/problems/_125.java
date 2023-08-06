package problems;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class _125 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("t,n8'`q`?55t`q`'8n,?"));
    }

    public static boolean isPalindrome(String s) {
//        boolean res = true;
//        s = s.replaceAll("[^a-zA-ZА-Яа-я0-9\\s]", "").replace(" ", "").toLowerCase();
//
//        int mid = s.length()/2;
//        char[] arr = s.toCharArray();
//        for (int i = 0; i < mid; i++) {
//            if (arr[i] != arr[arr.length-i-1]) {
//                res = false;
//                break;
//            }
//        }

        String alphStr = "abcdefghijklmnopqrstuvwxyz0123456789";
        Set<Character> alph = new HashSet<>();
        for (int i = 0; i < alphStr.length(); i++) {
            char ch = alphStr.charAt(i);
            alph.add(ch);
            alph.add(Character.toUpperCase(ch));
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            if (alph.contains(ch1)) {
                sb1.append(Character.toLowerCase(ch1));
            }
            char ch2 = s.charAt(s.length()-i-1);
            if (alph.contains(ch2)) {
                sb2.append(Character.toLowerCase(ch2));
            }
        }

        String normal1 = sb1.toString();
        String normal2 = sb2.toString();

        if (normal1.length() == normal2.length()
                && normal1.length() != 1
                && normal1.equals(normal2)) {
            return true;
        }

        return false;
    }

}
