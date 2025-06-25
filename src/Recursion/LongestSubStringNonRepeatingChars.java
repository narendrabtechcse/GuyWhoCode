package Recursion;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringNonRepeatingChars {

    //String str = abcadcpbqarxyzh
    //		nonrepeated longest substring
    //
    //
    //									for(char ch : str.toCharArray())


    public static void main(String[] args) {
        System.out.println(maxLengthSubStringNonRepeatedChars("abcadcpbqarxyzh"));
    }

    private static String maxLengthSubStringNonRepeatedChars(String str) {

        Set<Character> seen = new HashSet<>();

        int start = 0, end = 0, maxLength = 0;
        int maxStart = 0;


        while(end < str.length()-1)
        {
            if(seen.contains(str.charAt(end)))
            {
                seen.remove(str.charAt(start++));
            }else{
                seen.add(str.charAt(end++));
                maxLength= Math.max(maxLength,end-start+1);
                maxStart=start;
            }
        }
        return str.substring(maxStart,maxStart+maxLength);
    }
}
