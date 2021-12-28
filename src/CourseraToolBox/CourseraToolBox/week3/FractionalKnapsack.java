package CourseraToolBox.CourseraToolBox.week3;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Problem Introduction
A thief finds much more loot than his bag can fit. Help him to find the most valuable combination of items assuming that any fraction of a loot item can be put into his bag.
Problem Description
Task. The goal of this code problem is to implement an algorithm for the fractional knapsack problem.
Input Format. The first line of the input contains the number 𝑛 of items and the capacity 𝑊 of a knapsack. The next 𝑛 lines define the values and weights of the items. The 𝑖-th line contains integers 𝑣𝑖 and 𝑤𝑖—the value and the weight of 𝑖-th item, respectively.
Constraints. 1≤𝑛≤103,0≤𝑊 ≤2·106;0≤𝑣𝑖 ≤2·106,0<𝑤𝑖 ≤2·106 forall1≤𝑖≤𝑛.Allthe numbers are integers.
Output Format. Output the maximal value of fractions of items that fit into the knapsack. The absolute value of the difference between the answer of your program and the optimal value should be at most 10−3. To ensure this, output your answer with at least four digits after the decimal point (otherwise your answer, while being computed correctly, can turn out to be wrong because of rounding issues).
Sample 1.
Input:
3 50 
60 20 
100 50 
120 30
Output:
180.0000
To achieve the value 180, we take the first item and the third item into the bag.
 * 
 * 
 * 
 */

public class FractionalKnapsack {
	private static double getOptimalValue(int capacity, int[] values, int[] weights) {
		// write your code here
		Double[] viwiValues = new Double[values.length];
		Map<Double, Integer> viwiIndexMap = new HashMap<>();
		for (int i = 0; i < viwiValues.length; i++) {
			viwiValues[i] = (double) values[i] / weights[i];
			viwiIndexMap.put(viwiValues[i], i);
		}

		Arrays.sort(viwiValues);

		Double valuesAll = 0.0000;
		
		for (int i = 0; i < weights.length; i++) {
            if (capacity == 0)
                return valuesAll;
            int index = viwiIndexMap.get(viwiValues[weights.length-1-i]);
            int a = Math.min(capacity, weights[index]);
            valuesAll += a * (double) values[index] / weights[index];
            weights[index] -= a;
            capacity -= a;
        }

		DecimalFormat df = new DecimalFormat("#.0000");
		return Double.valueOf(df.format(valuesAll));
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int capacity = scanner.nextInt();
		int[] values = new int[n];
		int[] weights = new int[n];
		for (int i = 0; i < n; i++) {
			values[i] = scanner.nextInt();
			weights[i] = scanner.nextInt();
		}
		System.out.println(getOptimalValue(capacity, values, weights));
	}
}
