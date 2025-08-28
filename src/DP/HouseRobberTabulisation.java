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

/*
Memoisation way



class Solution {
    public int rob(int[] nums) {

        int n = nums.length;
        int[] memo = new int[n];

        Arrays.fill(memo,-1);

        return solve(nums,memo,0);

    }

    public int solve(int[] nums, int[] memo , int i)
    {
        if(i>=nums.length)
        return 0;
        if(memo[i]>-1)
        return memo[i];

        int ans=Math.max(solve(nums,memo,i+1),solve(nums,memo,i+2)+nums[i]);

        memo[i] = ans;
        return ans;


    }
}



 */