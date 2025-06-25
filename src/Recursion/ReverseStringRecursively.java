package Recursion;

public class ReverseStringRecursively {
    public static void main(String[] args) {
        System.out.println("Reversed String is : " + reverseString("Narendra".toCharArray(),0,"Narendra".length()-1));
    }

    private static String reverseString(char[] str,int start,int end) {
        if(start<0 || end>=str.length || start>=end)
            return "";
        else{
            char temp = str[start];
            str[start]=str[end];
            str[end]=temp;
            reverseString(str,start+1,end-1);
            return new String(str);
        }
    }
}
