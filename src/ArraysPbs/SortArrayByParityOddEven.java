package ArraysPbs;

/*
https://leetcode.com/problems/sort-array-by-parity/

Given an integer array nums, move all the even integers at the
beginning of the array followed by all the odd integers.
Return any array that satisfies this condition.
 */

public class SortArrayByParityOddEven {

	public static void main(String[] args) {
	}
	
	
	    public int[] sortArrayByParity(int[] nums) {
	    	
	    	int start=0,end=nums.length-1;
	    		do {
	    			
	    			if(nums[start]%2==1) {
	    				if(nums[end]%2 ==0) {
	    				//swap
	    				int temp = nums[start];
	    				nums[start] = nums[end];
	    				nums[end] = temp;
	    				start++;
	    				end--;
	    				}else {
	    					end--;
	    				}
	    			}else {
	    				if(nums[end]%2 ==1) {
	    					start++;
		    				end--;
	    				}else {
	    					start++;
	    				}
	    			}
	    			
	    		}while(end>=start);
	    		
			return nums;
	        
	    }

}
