package Top100;

import java.util.List;

/**
 * @author canoeYang
 * @Date 2020-03-07 23:10
 */
public class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = false;
        }
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];

    }
}
