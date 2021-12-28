package CourseraToolBox.CourseraToolBox.week1;

import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        
        int maxNumIdx = -1;
         int size = numbers.length;
        for (int i = 0; i < size; i++) {
            if (maxNumIdx == -1 || numbers[i] > numbers[maxNumIdx]) {
                maxNumIdx = i;
            } 
        }

        int sec_Max_Idx = -1;
        for (int i=0;i<size;i++) {
            if (i!=maxNumIdx && 
                (sec_Max_Idx == -1 || numbers[i] > numbers[sec_Max_Idx])){
                sec_Max_Idx = i;
            }
        }

        long result = (long) numbers[maxNumIdx] * (long) numbers[sec_Max_Idx];
        return result;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}

