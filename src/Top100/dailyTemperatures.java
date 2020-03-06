package Top100;

import java.util.Stack;

public class dailyTemperatures {
    // 暴力法；O（n^2)
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        for (int i = 0; i < T.length - 1; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[i] < T[j]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        res[T.length - 1] = 0;
        return res;
    }

    public int[] func2(int[] T) {
        // 利用栈
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int pos = stack.pop();
                res[pos] = i - pos;

            }
            stack.add(i);
        }
        return res;
    }
}
