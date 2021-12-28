package DP;

/*
https://leetcode.com/problems/partition-equal-subset-sum/

Given a non-empty array nums containing only positive integers,
find if the array can be partitioned into two subsets such that the
sum of elements in both subsets is equal.

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
 */

public class PartitionEqualSubsetSumBottomUP_416LC {

    public static void main(String[] args) {
        boolean length = new PartitionEqualSubsetSumBottomUP_416LC().canPartition(new int[]{1, 5, 11 , 5});

        System.out.println("Length : " + length);
    }



    public boolean canPartition(int[] nums) {

        int sum = 0;

        for(int num:nums)
            sum += num;
        if(sum%2!=0)
            return false;

        boolean dp[][] = new boolean[nums.length+1][sum/2+1];

        dp[0][0] = true;

        boolean isPossible = canPartition1(nums,nums.length,sum/2,dp);

        return  isPossible;

    }

    private boolean canPartition1(int[] nums, int n, int sum , boolean[][] dp) {

        if(dp[n][sum] == true )
            return dp[n][sum];

        for (int i=1;i<=n;i++)
        {
            dp[i][0] = true;
        }

        /*
        if(n==0)
            return false;
        if(sum==0)
            return true;
*/


        for (int i = 1; i <= nums.length; i++) {
            if(i==0)
                dp[i][sum]=false;

            for (int j = 1; j <= sum; j++) {


                if (nums[i - 1] <= j) {
                     dp[i][j] = dp[i - 1][ j - nums[i - 1]] || dp[i-1][ j];
                } else {
                     dp[i][j] = dp[i-1][j];
                }

            }
        }


        return dp[n][sum];
    }

}
