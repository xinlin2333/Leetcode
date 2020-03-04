package Top100;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return null;
        }
        dfs("", 0, 0, n, res);
        return res;
    }

    private static void dfs(String temp, int l, int r, int n, List<String> res) {
        if (l == n && r == n) {
            res.add(temp);
            return;
        }
        if (l < r) {
            return;
        }
        if (l < n) {
            dfs(temp + "(", l + 1, r, n, res);
        }
        if (r < n) {
            dfs(temp + ")", l, r + 1, n, res);
        }

    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(generateParenthesis(n));
    }
}
