package Search;

public class BinarySearchIterative {
    public static void main(String[] args) {
        int[] inputArr = {1,3,4,5,6,7,9,11,12,34,66};

        int key = 6;

        BinarySearchIterative obj = new BinarySearchIterative();

        System.out.println("Key is present at index : " + obj.binarySearchIterative(inputArr,key));
    }

    private int binarySearchIterative(int[] inputArr, int target) {
        int start = 0;
        int end = inputArr.length-1;

        while(start<=end)
        {
            int mid = start + (end-start)/2;

            System.out.println("mid is : "+inputArr[mid]);

            if(inputArr[mid] == target) {
                return mid;
            }
            else if(inputArr[mid]<target)
            {
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }
}
