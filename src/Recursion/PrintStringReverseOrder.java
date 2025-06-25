package Recursion;

public class PrintStringReverseOrder {
    public static void main(String[] args) {
        helper(0,"Narendra");
    }

    private static void helper(int i, String str) {
        if(str==null || str.length()==0 || i==str.length())
            return;

        helper(i+1,str);
        System.out.print(str.charAt(i));
    }
}
