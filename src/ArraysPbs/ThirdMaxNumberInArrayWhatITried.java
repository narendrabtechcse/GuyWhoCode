package ArraysPbs;

/*

https://leetcode.com/problems/third-maximum-number/

Given an integer array nums, return the third distinct maximum number in this array.
If the third maximum does not exist, return the maximum number.
 */

class ThirdMaxNumberInArrayWhatITried {
    public int thirdMax(int[] nums) {
        
        int max=nums[0];
        int sec_max=Integer.MIN_VALUE;
        int third_max=Integer.MIN_VALUE;
        
        for(int i=1;i<nums.length;i++){
            if(nums[i]>max){
                third_max=sec_max;
                sec_max=max;
                max=nums[i];
            }
            else if(nums[i]>sec_max && nums[i]<max){
                third_max = sec_max;
                sec_max=nums[i];
                    }
            else if(nums[i]<sec_max&&nums[i]>third_max){
                third_max=nums[i];
                }
        }
        
        if(nums.length<=2)
            third_max = max;
        
        if(nums.length>2 && third_max==0)
            third_max = max;
        
       
        
        return third_max;
        
    }
}
