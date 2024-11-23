package Search;

public class BinarySearchRecursive {

    public static void main(String[] args) {
        int[] inputArr = {1,3,4,5,6,7,9,11,12,34,66};
        int key = 6;
        BinarySearchRecursive obj = new BinarySearchRecursive();
        System.out.println("Key is present at index : " + obj.binarySearchRecursive(inputArr,0,inputArr.length-1,key));
    }

    private int binarySearchRecursive(int[] inputArr, int left , int right , int target) {
      if(left<=right)
      {
          int mid = left + (right-left)/2;
          if(inputArr[mid]==target)
              return mid;
          else if (inputArr[mid]>target) {
              return binarySearchRecursive(inputArr,left,mid-1,target);
          }else{
              return binarySearchRecursive(inputArr,mid+1,right,target);
          }
      }
     return -1;
    }
}
