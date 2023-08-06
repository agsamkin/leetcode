package problems;

import java.util.Arrays;
import java.util.Stack;

public class _739 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[] {73,74,75,71,69,72,76,73})));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int res[] = new int[n];

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++)
        {
            while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }

    public static int[] _dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int curr = temperatures[i];
            for (int j = i + 1, d = 1; j < temperatures.length; j++, d++) {
                int next = temperatures[j];
                if (next > curr) {
                    res[i] = d;
                    break;
                }
            }
        }
        return res;
    }

}
