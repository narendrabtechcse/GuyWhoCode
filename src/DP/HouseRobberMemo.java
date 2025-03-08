package DP;


import java.util.Arrays;

public class HouseRobberMemo {
    public static int rob(int[] nums) {

        if (nums.length == 0)
            return 0;

        int[] memo = new int[nums.length + 1];

        Arrays.fill(memo, -1);

        return helper(nums, nums.length, memo);

    }

    public static int helper(int[] nums, int index, int[] memo) {
        if (index <= 0)
            return 0;

        if (index == 1)
            return nums[0];

        if (memo[index] != -1)
            return memo[index];

        int take = nums[index - 1] + helper(nums, index - 2, memo);
        int nottake = helper(nums, index - 1, memo);

        memo[index] = Math.max(take, nottake);

        return memo[index];

    }

    public static void main(String[] args) {
        int[] hval = {6, 7, 1, 3, 8, 2, 4};
        System.out.println("Memoisation : " + rob(hval));
    }
}