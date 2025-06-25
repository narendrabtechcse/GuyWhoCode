package DP;

import java.util.Arrays;

/*
Servey Monkey My interview asked.

Given a rod of length n inches and an array price[]. price[i] denotes the value of a piece of length i. The task is to determine the maximum value obtainable by cutting up the rod and selling the pieces.

Note: price[] is 1-indexed array.

Input: price[] =  [1, 5, 8, 9, 10, 17, 17, 20]
Output: 22
Explanation:  The maximum obtainable value is 22 by cutting in two pieces of lengths 2 and 6, i.e., 5 + 17 = 22.

Input : price[] =  [3, 5, 8, 9, 10, 17, 17, 20]
Output : 24
Explanation : The maximum obtainable value is 24 by cutting the rod into 8 pieces of length 1, i.e, 8*price[1]= 8*3 = 24.

Input : price[] =  [3]
Output : 3
Explanation: There is only 1 way to pick a piece of length 1.

 */
public class RodCuttingProblem {
    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        //System.out.println(cutRod(price));
        //System.out.println(cutRodTopDown(price));
        System.out.println(cutRodBottomUp(price));
    }

    private static int cutRodBottomUp(int[] price) {
        int n = price.length;
        return cutRodBottomUpImpl(price, n);
    }

    private static int cutRodBottomUpImpl(int[] price, int n) {

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], price[j - 1] + dp[i - j]);
            }
        }
        return dp[n];
    }

    private static int cutRodTopDown(int[] price) {
        int n = price.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return cutRodTopDownImpl(price, n, memo);
    }

    private static int cutRodTopDownImpl(int[] price, int i, int[] memo) {

        if (i == 0)
            return 0;

        if (memo[i - 1] != -1)
            return memo[i - 1];

        int maxVal = 0;

        for (int j = 1; j <= i; j++) {
            maxVal = Math.max(maxVal, price[j - 1] + cutRodTopDownImpl(price, i - j, memo));
        }

        return memo[i - 1] = maxVal;
    }

    private static int cutRod(int[] price) {
        int n = price.length;
        return cutRodRec(price, n);
    }

    private static int cutRodRec(int[] price, int i) {
        if (i == 0)
            return 0;

        int maxPrice = 0;

        for (int j = 1; j <= i; j++) {
            maxPrice = Math.max(maxPrice, price[j - 1] + cutRodRec(price, i - j));
        }
        return maxPrice;
    }
}
