package DP;

public class LCSBottomUP {

    public static void main(String[] args) {
        int length = new LCSBottomUP().longestCommonSubsequence("abcgfdhs", "bgd");

        System.out.println("Length : " + length);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.equals(text2))
            return text1.length();

        Integer[][] dp = new Integer[text1.length() + 1][text2.length() + 1];
        int val = lcs(text1, text2, text1.length(), text2.length(), dp);

        return val;
    }

    private int lcs(String text1, String text2, int m, int n, Integer[][] dp) {
        if (m == 0 || n == 0)
            return 0;
        if (dp[m][n] != null)
            return dp[m][n];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {

                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

}

