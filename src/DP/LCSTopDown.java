package DP;

/*

https://leetcode.com/problems/longest-common-subsequence/

Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without
changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.


 */


//top down with recurion approach

public class LCSTopDown {


    public static void main(String[] args) {
        int length = new LCSTopDown().longestCommonSubsequence("abcgfdhs", "bgd");

        System.out.println("Length : " + length);
    }

    public int longestCommonSubsequence(String text1, String text2) {


        if(text1.equals(text2))
            return text1.length();

        int val = lcs(text1, text2, text1.length(), text2.length());


        return val;
    }

    private int lcs(String text1, String text2, int m, int n) {

        Integer[][] dp = new Integer[text1.length()+1][text2.length()+1];

        if(m==0 || n== 0)
            return 0;

        if(dp[m][n]!=null)
            return dp[m][n];

        if(text1.charAt(m-1)==text2.charAt(n-1))
            dp[m][n] = 1 + lcs(text1,text2,m-1,n-1);
        else
            dp[m][n] =  Math.max(lcs(text1,text2,m-1,n),lcs(text1,text2,m,n-1));

        return dp[m][n];

    }

}
