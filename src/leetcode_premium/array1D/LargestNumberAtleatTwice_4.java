package leetcode_premium.array1D;

/*
You are given an integer array nums where the largest integer is unique.

Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is, return the index of the largest element, or return -1 otherwise.

Example 1:

Input: nums = [3,6,1,0]
Output: 1
Explanation: 6 is the largest integer.
For every other number in the array x, 6 is at least twice as big as x.
The index of value 6 is 1, so we return 1.
Example 2:

Input: nums = [1,2,3,4]
Output: -1
Explanation: 4 is less than twice the value of 3, so we return -1.


Constraints:

2 <= nums.length <= 50
0 <= nums[i] <= 100
The largest element in nums is unique.
 */
public class LargestNumberAtleatTwice_4 {

    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{4,5,8,7,10,12,14,67}));
    }

    public static int dominantIndex(int[] nums) {

        int largest_elam = 0;
        int largest_idx=0;
        int sec_largest_elem=0;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>largest_elam)
            {
                sec_largest_elem = largest_elam;
                largest_elam = nums[i];
                largest_idx = i;
            }else if(nums[i]>sec_largest_elem)
            {
                sec_largest_elem = nums[i];
            }
        }

        if(largest_elam>=sec_largest_elem*2)
            return largest_idx;



        return -1;

    }
}
