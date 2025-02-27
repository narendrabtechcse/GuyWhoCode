package SortingAlgos;

public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] inputArr = new int[]{23,12,56,7,3,89,87,11,1,5};
        bubbleSort.bubbleSort(inputArr);

        for (int j : inputArr) {
            System.out.print(j + " --> ");
        }
    }

    private void bubbleSort(int[] inputArr) {
        boolean isSwapped = false;
        for(int i=0;i<inputArr.length;i++)
        {
            for(int j=0;j<inputArr.length-i-1;j++)
            {
                if(inputArr[j]>inputArr[j+1])
                {
                    int temp = inputArr[j+1];
                    inputArr[j+1] = inputArr[j];
                    inputArr[j] = temp;

                    isSwapped = true;
                }
            }
            if(isSwapped == false)
                break;
        }
    }
}
