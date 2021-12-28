package CourseraToolBox.CourseraToolBox.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class fibonacci {


    static long getFibonacci(int n) {
    	 if (n <= 1) {
    	      return n;
    	    }

    	    long[] memory = new long[n + 1];
    	    memory[0] = 0;
    	    memory[1] = 1;
    	    for (int index = 2 ; index <= n ; index++) {
    	      memory[index] = memory[index - 1] + memory[index - 2];
    	    }

    	    return memory[n];
    	
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        
        System.out.println(getFibonacci(n));
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
