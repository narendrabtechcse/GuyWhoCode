package RandomLeetCode;

public class SortArrayByParity2 {

	public static void main(String[] args) {
		new SortArrayByParity2().findMaxConsecutiveOnes(new int[] {1,1,0,1,1,1});

	}
	
	
	 public int findMaxConsecutiveOnes(int[] nums) {
	        
	        int maxConsecutive1s = 0;
	        
	        int current1s = 0;
	        for(int i=0;i<nums.length;i++){
	            if(nums[i]==1){
	               current1s++; 
	                if(maxConsecutive1s<current1s){
	                    maxConsecutive1s = current1s;
	                    System.out.println("1:"+maxConsecutive1s);
	                }
	                System.out.println(current1s);
	            }else{
	                if(maxConsecutive1s<current1s){
	                    maxConsecutive1s = current1s;
	                    System.out.println("2:"+maxConsecutive1s);
	                    
	                    }
	                
	                System.out.println("3:"+current1s);
	                
	                current1s=0;
	            }
	            
	            
	        }
	        System.out.println("4:"+maxConsecutive1s);
	        return maxConsecutive1s;
	    }

}
