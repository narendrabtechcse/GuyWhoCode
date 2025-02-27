package Prefix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
46. Permutations
Given an array nums of distinct integers, return all the possible
permutations
. You can return the answer in any order.
Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]


Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.

https://www.youtube.com/watch?v=b1iFSSxg9Y8

 */

public class PermutationsOfArray {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
        //System.out.println("Result : " + result);
    }

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        helper(nums, 0);
        return result;
    }

    public static void helper(int[] nums, int i) {
        if (i == nums.length) {
            // Convert the array to a List<Integer> and add it to the result
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }

        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);   // Swap current element with the element at index j
            helper(nums, i + 1); // Recursively generate permutations
            swap(nums, i, j);   // Backtrack to restore the original array
        }
    }

    // Swap method to exchange elements in the array
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
