package Top100;

public class longestPalindrome {
    public static String longestPalindrome(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        String max = "";
        for (int i = 0; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(j) == s.charAt(i)) {
                    if (j - i == 1) {
                        dp[j][i] = true;
                    } else if (i - j >= 2) {
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                }
                if (dp[j][i] == true) {
                    if (max.length() < (i - j + 1)) {
                        max = s.substring(j, i + 1);
                    }
                }
            }

        }
        return max;
    }

    public static void main(String[] args) {
        String s = "addc";
        System.out.println(longestPalindrome(s));
    }

}
