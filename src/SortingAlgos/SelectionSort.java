package SortingAlgos;

public class SelectionSort {
    public static void main(String[] args) {
        int input[] = {79, 90, 1, 2, 67, 89};

        selectionSort(input);

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " -----> ");
        }
    }

    private static void selectionSort(int[] input) {

        int n = input.length;
        for (int i = 0; i < n ; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (input[j] < input[minIndex]) {
                    minIndex = j;
                }
            }

            //swap the minimum number
            if (minIndex != i) {
                int temp = input[minIndex];
                input[minIndex] = input[i];
                input[i] = temp;
            }
        }
    }
}
