package CourseraToolBox.CourseraToolBox.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class fibonacci_sum_of_squares {

	private static long getFibonacciSum(long n) {
		if (n <= 1)
			return n;

		long current = getfibonacci(n % 60);
		long next = getfibonacci((n + 1) % 60);
    
		return ((current % 10) * (next % 10) % 10);
	}
    
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        
        System.out.println(getFibonacciSum(a));
    }
	
	private static long getfibonacci(long n) {
		if (n == 1 || n == 0) {
			return n;
		}

		long fib1 = 0;
		long fib2 = 1;
		long fib3 = 0;
		for (long i = 2; i <= n; i++) {
			fib3 = fib1 + fib2;
			fib1 = fib2;
			fib2 = fib3;
		}
		return fib3;
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
