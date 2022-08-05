package javamultithreadingandconcurrencysimplifiedudemythreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class SumCalculatorTask implements Callable<Integer> {
    private int arr[];
    private int start;
    private int end;

    public SumCalculatorTask(int arr[], int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }
        return sum;
    }
}

public class ProblemSet1 {

    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        int blockSize = 3;
        int noOfBlocks = (int) Math.ceil((double)arr.length/blockSize);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Future<Integer>> futureObjList = new ArrayList<Future<Integer>>();

        int start = 0, end;
        for (int i = 1; i <= noOfBlocks; i++) {
            start = (i-1) * blockSize;
            end = start + blockSize - 1;

            // Check if end crosses the actual array size,if yes take the last element index.
            if (end >= arr.length) {
                end = arr.length - 1;
            }

            // Submit the SumCalculatorTask a Callable task which is responsible for calculating the partition sum.
            Future<Integer> future = executorService.submit(new SumCalculatorTask(arr, start, end));

            futureObjList.add(future);

            int totalSum = 0;
            for (Future<Integer> future1 : futureObjList) {
                totalSum += getComputedValue(future1);
            }

            // Display the computed total.
            System.out.println("Final Sum " + totalSum);
        }

    }

    private static int getComputedValue(Future<Integer> future) {

        // Waiting for future object to complete
        while (! future.isDone()) {
            // Pass control to other threads;
            // if any; waiting for CPU.
            Thread.yield();
        }

        try {
            // Get the computed result.
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return 0; // DANGEROUS: Ignored exceptions.
        }
    }


}
