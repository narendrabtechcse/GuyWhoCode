package RandomLeetCode;

public class SortArrayByParity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
