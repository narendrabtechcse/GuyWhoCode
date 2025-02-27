package SortingAlgos;

public class QuickSort {

    public static void main(String[] args) {
        int input[] = {79, 90, 1, 2, 67, 89};

        quickSort(input,0,input.length-1);

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " -----> ");
        }
        
    }

    private static void quickSort(int[] arr , int left , int right) {
        if(left<right)
        {
            int pi = partition(arr , left , right);
            quickSort(arr,left,pi-1);
            quickSort(arr,pi+1,right);
        }
    }

    private static int partition(int[] arr, int left, int right) {

        int pivot = arr[right];
        int i = left-1;

        for(int j=left;j<right;j++)
        {
            if(arr[j]<pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[right];
        arr[right] = temp;

        return i+1;
    }

}
