package Queue;

/*

https://leetcode.com/problems/first-unique-character-in-a-string/submissions/

Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:

Input: s = "leetcode"
Output: 0
 */

public class FirstNonRepeatingCharLeetCode {


    public static int firstUniqChar(String s) {

        int[] indexOccArr = new int[256];

        for (int i = 0; i < indexOccArr.length; i++) {
            indexOccArr[i] = -1;
        }

        for(int j=0;j<s.length();j++)
        {
            if(indexOccArr[s.charAt(j)]==-1)
            {
                indexOccArr[s.charAt(j)] = j;
            }else{
                indexOccArr[s.charAt(j)]=-2;
            }
        }

        int res =  Integer.MAX_VALUE;

        for(int i = 0; i<256; i++) {
            if(indexOccArr[i] >= 0)
                res = Math.min(res, indexOccArr[i]);
        }


        if(res ==  Integer.MAX_VALUE) return -1;
        else return res;


    }




    public static void main(String args[]){
        String str;
        str = "geeksforgeeks";
        int firstIndex = firstUniqChar(str);
        if (firstIndex == -1)
            System.out.println("Either all characters are repeating or string is empty");
        else
            System.out.println("First non-repeating character is "+ str.charAt(firstIndex));
    }
}
