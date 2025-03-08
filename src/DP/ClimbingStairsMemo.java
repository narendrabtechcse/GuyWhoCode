package DP;

/*
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

 */

import java.util.Arrays;

public class ClimbingStairsMemo {

    public static void main(String[] args) {
        int n = 10;

        System.out.println(new ClimbingStairsMemo().climbStairs(n));
    }

    public int climbStairs(int n) {

        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);

        return helper(n,memo);
    }

    public int helper(int n , int[] memo)
    {
        if(n==0)
            return 0;

        if(n==1)
            return 1;

        if(n==2)
            return 2;

        if(memo[n]!=-1)
            return memo[n];

        memo[n] = helper(n-1,memo) + helper(n-2,memo);

        return memo[n];
    }
}
