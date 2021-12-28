package DP;

/*


https://leetcode.com/problems/coin-change-2/

You are given an integer array coins representing coins of different denominations and
an integer amount representing a total amount of money.
Return the number of combinations that make up that amount. If that amount of money cannot be made up
by any combination of the coins, return 0.
You may assume that you have an infinite number of each kind of coin.
The answer is guaranteed to fit into a signed 32-bit integer.

 */

public class CoinChange2TopDown {

    public static void main(String[] args)
    {
        int amount = 5;
        int[] coins = {1,2,5};

        System.out.println(change(amount,coins));
    }


    public static int change(int amount, int[] coins) {

        //top down approach

        if (coins.length == 0)
            return 0;

        Integer[][] memo = new Integer[coins.length+1][amount+1];

        int val = helperChange(amount, coins, coins.length,memo);


        return val;

    }

    private static int helperChange(int amount, int[] coins, int i, Integer[][] memo) {

        if (i == 0) {
            memo[i][amount]=0;
            return 0;
        }

        if(amount==0) {
            memo[i][amount]=1;
            return 1;
        }

        if(memo[i][amount]!=null)
        {
            return memo[i][amount];
        }

        if (coins[i - 1] <= amount) {
            memo[i][amount] = helperChange(amount - coins[i - 1], coins, i,memo) + helperChange(amount, coins, i - 1,memo);
        } else {
            memo[i][amount] = helperChange(amount, coins, i - 1,memo);
        }

        return memo[i][amount];
    }
}
