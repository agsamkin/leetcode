package problems;

import java.util.ArrayList;
import java.util.List;

public class _22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        addParenthesis(res,"",0, 0, n);
        return res;
    }

    public static void addParenthesis(List<String> res, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            res.add(str);
            return;
        }

        if (open < max) {
            addParenthesis(res, str + "(", open + 1, close, max);
        }

        if (close < open) {
            addParenthesis(res, str + ")", open, close + 1, max);
        }
    }
}
