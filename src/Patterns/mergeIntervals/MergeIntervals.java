package Patterns.mergeIntervals;

/*

https://leetcode.com/problems/merge-intervals/description/

56. Merge Intervals

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an
array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104


 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] merged = merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});

        for (int[] arr : merged)
            System.out.print("[ " + arr[0] + " , " + arr[1] + " ] ");
    }

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i = 0; i < intervals.length; i++) {

            int[] interval = intervals[i];

            if (interval[0] <= prev[1]) {
                prev[1] = Math.max(interval[1], prev[1]);
            } else {
                merged.add(prev);
                prev = interval;
            }

        }
        merged.add(prev);
        return merged.toArray(new int[merged.size()][]);
    }

}
