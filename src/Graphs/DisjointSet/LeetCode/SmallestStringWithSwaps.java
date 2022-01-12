package Graphs.DisjointSet.LeetCode;

/*

https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3913/

You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.

You can swap the characters at any pair of indices in the given pairs any number of times.

Return the lexicographically smallest string that s can be changed to after using the swaps.


 */

import java.util.*;

public class SmallestStringWithSwaps {

    int[] root;
    int[] rank;
    static int count;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        count = s.length();
        root = new int[s.length()];
        rank = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            root[i] = i;
            rank[i] = 1;
        }

        for (List<Integer> pair : pairs) {
            union(pair.get(0),pair.get(1));
        }


        Map<Integer, List<Integer>> map = new HashMap<>();
        // Group each set of indices can swap together
        for (int i = 0; i < s.length(); i++) {
            int pi = find(i);
            map.putIfAbsent(pi, new ArrayList<>());
            map.get(pi).add(i);
        }

        char[] chs = new char[s.length()];

        for (int key : map.keySet()) {
            // List of indices in that group
            List<Integer> value = map.get(key);
            List<Integer> list = new ArrayList<>(value);
            // sorting the indices based on character in input string
            Collections.sort(list, (o1, o2) -> (s.charAt(o1) - s.charAt(o2)));
            for (int i = 0; i < list.size(); i++) {
                // put value to each index
                chs[value.get(i)] = s.charAt(list.get(i));
            }
        }
        // return new string
        return new String(chs);


    }

    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
            count--;
        }
    }
}
