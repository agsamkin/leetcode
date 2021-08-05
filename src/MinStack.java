import java.util.ArrayList;

public class MinStack {

    ArrayList<Integer> stack = new ArrayList<>();

    public MinStack() {}

    public void push(int val) {
        stack.add(val);
    }

    public void pop() {
        if (stack.size() > 0) {
            stack.remove(stack.size()-1);
        }
    }

    public int top() {
        int res = 0;
        if (stack.size() > 0) {
            res = stack.get(stack.size()-1);
        }
        return res;
    }

    public int getMin() {

        if (stack.size()==0) {
            return 0;
        }

        int min = stack.get(0);

        for (int i = 1; i < stack.size(); i++) {
            min = Math.min(min, stack.get(i));
        }

        return min;

    }

}
