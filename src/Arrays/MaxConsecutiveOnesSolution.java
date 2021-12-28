package Arrays;
/*

https://leetcode.com/problems/max-consecutive-ones/

Given a binary array nums, return the maximum number of consecutive 1's in the array.

 */

public class MaxConsecutiveOnesSolution {

    public static void main(String[] args) {
        System.out.println(new MaxConsecutiveOnesSolution().findMaxConsecutiveOnes(new int[] {1,1,0,1,1,1}));

    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0,max=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==1){
                count++;
            }
            else{
                max=Math.max(max,count);
                count=0;
            }
        }
        return Math.max(count,max);
    }

}

