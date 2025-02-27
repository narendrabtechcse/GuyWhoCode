package SortingAlgos;

public class MergeSort {

    public static void main(String[] args) {
        int input[] = {79, 90, 1, 2, 67, 89};

        mergeSort(input,0,input.length-1);

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " -----> ");
        }
    }

    private static void mergeSort(int[] arr , int left , int right) {

        if(left<right)
        {
            int mid = (left+right)/2;

            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);

            merge(arr,left,mid,right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid-left+1;
        int n2 = right - mid;

        int Left[] = new int[n1];
        int Right[] = new int[n2];

        for(int i=0;i<n1;i++)
        {
            Left[i] = arr[left+i];
        }

        for (int j = 0; j < n2; j++) {
            Right[j] = arr[mid+1+j];
        }

        int i = 0; int j =0;

        int k = left;

        while(i<n1 && j<n2)
        {
            if(Left[i] <= Right[j])
            {
                arr[k] = Left[i];
                i++;
            }else{
                arr[k] = Right[j];
                j++;
            }
            k++;
        }

        while (i<n1)
        {
            arr[k] = Left[i];
            i++;
            k++;
        }

        while (j<n2)
        {
            arr[k] = Right[j];
            j++;
            k++;
        }

    }
}
