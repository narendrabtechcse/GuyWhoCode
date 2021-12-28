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

public class PartitionEqualSubsetSum_416LC {

    public static void main(String[] args) {
        boolean length = new PartitionEqualSubsetSum_416LC().canPartition(new int[]{1, 5, 11 , 5});

        System.out.println("Length : " + length);
    }



    public boolean canPartition(int[] nums) {

        int sum = 0;

        for(int num:nums)
            sum += num;
        if(sum%2!=0)
            return false;

        boolean dp[][] = new boolean[nums.length+1][sum/2+1];


        boolean isPossible = canPartition1(nums,nums.length,sum/2,dp);

        // System.out.println("isPossible : "+isPossible);

        return  isPossible;

    }

    private boolean canPartition1(int[] nums, int n, int sum , boolean[][] dp) {

       if(n==0){

           dp[n][sum] = false;

            return dp[n][sum];
       }


        if(dp[n][sum] == true )
            return dp[n][sum];

        if(n==0)
            return false;
        if(sum==0)
            return true;



        if(nums[n-1]<=sum)
        {
            return dp[n][sum] = canPartition1(nums,n-1,sum-nums[n-1],dp) || canPartition1(nums,n-1,sum,dp);
        }else{
            return dp[n][sum] = canPartition1(nums,n-1,sum,dp);
        }

        //return dp[n][sum];
    }

}
