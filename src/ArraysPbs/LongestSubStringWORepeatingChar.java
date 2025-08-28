package ArraysPbs;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWORepeatingChar {
    public static void main(String[] args) {
        System.out.println(longestSubStringWoRepeatingChar("abcabcbb"));
    }

    private static int longestSubStringWoRepeatingChar(String s) {
        int i = 0;
        int j = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(i++);
            }
        }
        return max;
    }
}
