package Arrays;
import java.util.TreeSet;
/*
https://leetcode.com/problems/third-maximum-number/

Given an integer array nums, return the third distinct maximum number in this array.
If the third maximum does not exist, return the maximum number.
 */

public class ThirdMaxWhatISubmitted {
        public int thirdMax(int[] nums) {
            TreeSet<Integer> result =new TreeSet();
            for(int num: nums){
                result.add(num);
            }
            if(result.size()>=3){
                result.pollLast();
                result.pollLast();
            }
            return result.last();
    }
}
