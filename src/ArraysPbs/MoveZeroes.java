package ArraysPbs;

/*
https://leetcode.com/problems/move-zeroes/

Given an integer array nums, move all 0's to the end of it while maintaining
the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        // Counter for keeping track of elements other than val
        int count = 0;
        // Loop through all the elements of the array
        for (int i = 0; i < nums.length; i++) {
            // If the element is not val
            if (nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }

        for(int j=count;j<nums.length;j++){
            nums[j] = 0;
        }


    }
}
