package Top100;

import java.util.Stack;

public class minStack {
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack;

    /**
     * initialize your data structure here.
     */
    public void MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (min >= x) {
            min = x;
            stack.push(min);

        }
        stack.push(x);

    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
