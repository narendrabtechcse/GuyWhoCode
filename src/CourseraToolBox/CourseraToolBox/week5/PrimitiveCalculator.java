package CourseraToolBox.CourseraToolBox.week5;


import java.util.*;

public class PrimitiveCalculator {
	private static List<Integer> optimal_sequence(int n) {
		List<Integer> sequence = new ArrayList<Integer>();
        int[] minOperation = new int[n + 1];
        int[] path = new int[n + 1];

        for (int op = 2; op <= n; op++) {
            int min = Integer.MAX_VALUE;
            if (op % 3 == 0 && min > minOperation[op / 3] + 1) {
                min = minOperation[op / 3] + 1;
                path[op] = op / 3;
            } 
            if (op % 2 == 0 && min > minOperation[op / 2] + 1) {
                min = minOperation[op / 2] + 1;
                path[op] = op / 2;
            }
            if (min > minOperation[op - 1] + 1) {
                min = minOperation[op - 1] + 1;
                path[op] = op - 1;
            }
            minOperation[op] = min;
        }

        while (n >= 1) {
            sequence.add(n);
            n = path[n];
        }
        Collections.reverse(sequence);

        return sequence;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

