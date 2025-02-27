package SortingAlgos;

public class InsertionSort {

    public static void main(String[] args) {
        int[] inputArr = new int[]{12,4,5,78,96,11,32,44,2,8,10};

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(inputArr);

        for(int i : inputArr)
            System.out.print(i + " --> ");
    }

    private void insertionSort(int[] inputArr) {
        for(int i=1;i<inputArr.length;i++)
        {
            int key = inputArr[i];
            int j = i-1;

            while(j>0 && inputArr[j] > key)
            {
                inputArr[j+1] = inputArr[j];
                j = j-1;
            }

            inputArr[j+1] = key;
        }

    }

}
