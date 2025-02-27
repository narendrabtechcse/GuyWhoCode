package SortingAlgos;

public class HeapSort {

    public static void main(String[] args) {
        int input[] = {12,34,76,6,8,1,2,54,89,98,2,3,45,12};
        System.out.println("Before Sorting : ");
        for (int i = 0; i < input.length; i++) {
            System.out.print("--> "+ input[i]);
        }
        heapSort(input);
        System.out.println();
        System.out.println("After Sorting : ");

        for (int i = 0; i < input.length; i++) {
            System.out.print("--> "+ input[i]);
        }
    }

    private static void heapSort(int[] arr) {

        int n = arr.length;;

        for(int i=(n/2-1) ;i>=0;i--)
        {
            heapify(arr,n,i); //max heap
        }

        

    }

    private static void heapify(int[] arr, int n, int i) {

    }
}
