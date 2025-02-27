package leetcode_premium.array2D;

/*

Pascal's Triangle

Solution
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]

Constraints:

1 <= numRows <= 30

 */

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_4 {

    public static void main(String[] args) {
        System.out.println(generate(10));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                }
                else {
                    int val = list.get(i - 1).get(j) + list.get(i - 1).get(j - 1);
                    temp.add(val);
                }
            }
            list.add(temp);
        }
        return list;
    }

}
