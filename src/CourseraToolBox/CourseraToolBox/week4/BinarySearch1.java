package CourseraToolBox.CourseraToolBox.week4;
//Java implementation of iterative Binary Search
class BinarySearch1 {
 // Returns index of x if it is present in arr[],
 // else return -1
 int binarySearch(int arr[], int x)
 {
	 int c=0;
     int l = 0, r = arr.length - 1;
     while (l <= r) {
         int m = l + (r - l) / 2;
         System.out.println(c++ + " m is : "+m);

         // Check if x is present at mid
         if (arr[m] == x)
             return m;

         // If x greater, ignore left half
         if (arr[m] < x)
             l = m + 1;

         // If x is smaller, ignore right half
         else
             r = m - 1;
     }

     // if we reach here, then element was
     // not present
     return -1;
 }

 // Driver method to test above
 public static void main(String args[])
 {
     BinarySearch1 ob = new BinarySearch1();
     int arr[] = new int[2097152];
     int n = arr.length;
     for(int i=0;i<n;i++) {
    	 arr[i] = i+1;
     }
     int x = 2097151;
     int result = ob.binarySearch(arr, x);
     if (result == -1)
         System.out.println("Element not present");
     else
         System.out.println("Element found at "
                            + "index " + result);
 }
}