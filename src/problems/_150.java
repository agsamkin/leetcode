package problems;

import java.util.Stack;
import java.util.function.Supplier;

public class _150 {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

    public static int evalRPN(String[] tokens) {
        final String PLUS = "+";
        final String MINUS = "-";
        final String MULT = "*";
        final String DIV = "/";

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String t = tokens[i];
            if (PLUS.equals(t) || MINUS.equals(t) || MULT.equals(t) || DIV.equals(t)) {
                int n2 = Integer.parseInt(stack.pop());
                int n1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (PLUS.equals(t)) {
                    res = n1 + n2;
                } else if ( MINUS.equals(t)) {
                    res = n1 - n2;
                } else if ( MULT.equals(t)) {
                    res = n1 * n2;
                } else {
                    res = n1 / n2;
                }
                stack.push(String.valueOf(res));
            } else {
                stack.push(t);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
