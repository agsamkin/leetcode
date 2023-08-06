package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _20 {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));

    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char curr = chars[i];
            if (stack.empty()) {
                stack.push(curr);
                continue;
            }
            char last = stack.lastElement();

            if (last == '(' && curr == ')') {
                stack.pop();
            } else if (last == '[' && curr == ']') {
                stack.pop();
            } else if (last == '{' && curr == '}') {
                stack.pop();
            } else {
                stack.push(curr);
            }
        }

        return stack.empty();
    }
}
