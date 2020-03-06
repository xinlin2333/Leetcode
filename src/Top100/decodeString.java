package Top100;

import java.util.Stack;

public class decodeString {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int num = 0;
            // 若为数字
            while (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                c = s.charAt(++i);
            }
            // 刚获取到的数字入栈
            if (num > 0) {
                numStack.push(num);
            }
            if (c != ']') {
                stack.push(String.valueOf(c));
            } else {
                String cur = "";
                while (!stack.peek().equals("[")) {
                    cur = stack.pop() + cur;
                }
                stack.pop();
                String part = "";
                int topNum = numStack.pop();
                for (int j = 0; j < topNum; j++) {
                    part += cur;
                }
                stack.push(part);
            }
            i++;

        }
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }
    //result:时间超时


    public String func(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                sb.append(c);
            } else if (c == '[') {
                if (num > 0) {
                    numStack.push(num);
                }
                strStack.push(sb.toString());
                sb = new StringBuilder();
                num = 0;
            } else {
                StringBuilder part = new StringBuilder();
                int topNum = numStack.pop();
                for (int j = 0; j < topNum; j++) {
                    part.append(sb);
                }
            }
        }
        return sb.toString();
    }
}
