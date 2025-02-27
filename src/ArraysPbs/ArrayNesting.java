package ArraysPbs;
import java.util.Set;

/*
https://leetcode.com/problems/array-nesting/

You are given an integer array nums of length n where nums is a permutation of the numbers in the range [0, n - 1].
You should build a set s[k] = {nums[k], nums[nums[k]], nums[nums[nums[k]]], ... } subjected to the following rule:
The first element in s[k] starts with the selection of the element nums[k] of index = k.
The next element in s[k] should be nums[nums[k]], and then nums[nums[nums[k]]], and so on.
We stop adding right before a duplicate element occurs in s[k].
Return the longest length of a set s[k].
 */
public class ArrayNesting {

    public int arrayNesting(int[] nums) {

        boolean[] visited = new boolean[nums.length];

        int countGlobal = 0;
        Set set ;
        int j = 0;
        int countLocal = 0;
        for(int i=0;i<nums.length;i++){

            j=nums[i];
            countLocal = 0;
            if(!visited[i]){
                do{
                    j=nums[j];
                    visited[j] = true;
                    countLocal++;
                }while (j != nums[i]);

                if(countLocal>countGlobal)
                    countGlobal = countLocal;
            }
        }
        return countGlobal;
    }
}
