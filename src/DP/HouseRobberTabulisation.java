package DP;

public class HouseRobberTabulisation {

    public static void main(String[] args) {
        int[] hval = {6, 7, 1, 3, 8, 2, 4};
        System.out.println("Tabulisation : " + rob(hval));
    }

    private static int rob(int[] hval) {

        int n = hval.length;
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = hval[0];

        for(int i=2;i<=n;i++)
        {
            dp[i] = Math.max(hval[i-1] + dp[i-2] , dp[i-1]);
        }
        return dp[n];
    }
}
