package Heap.LeetCode;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinCostToConnectSticks {

    public int connectSticks(int[] sticks) {

        Queue<Integer> minHeap = new PriorityQueue<Integer>();
        int size=0;

        for(int n : sticks)
        {
            minHeap.add(n);
        }
        int sum=0;
        int curSum=0;
        while(minHeap.size()>1)
        {
            curSum = minHeap.poll()+minHeap.poll();
            minHeap.add(curSum);
            sum+=curSum;
        }

        return sum;
    }
}
