package Heap.LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
/*
https://leetcode.com/problems/kth-largest-element-in-an-array/

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 */


public class KthLargest {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }
        int removeElement=0;
        for (int i = 0; i < k; i++) {


            removeElement = maxHeap.poll();
        }
        return removeElement;
    }
}

/*

by minheap :


public class Solution {
            public int findKthLargest(int[] nums, int k) {
                PriorityQueue<Integer> largeK = new PriorityQueue<Integer>(k + 1);

                for(int el : nums) {
                    largeK.add(el);
                    if (largeK.size() > k) {
                        largeK.poll();
                    }
                }

                return largeK.poll();
            }
}
 */
