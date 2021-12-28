package CourseraToolBox.CourseraToolBox.week2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class fibonacci_sum {

	private static long lastDigSum(long n) {

		if (n == 1 || n == 0) {
			return n;
		}
		n = (n + 2) % 60;
		ArrayList<Long> fib = new ArrayList<>();
		fib.add(0L);
		fib.add(1L);
		for (int i = 2; i <= n; i++)
			fib.add((fib.get(i - 1) % 10 + fib.get(i - 2) % 10) % 10);

		if (fib.get((int) n) == 0) {
			return 9;
		}

		return (fib.get((int) n) % 10) - 1;

	}

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
       
        
        System.out.println(lastDigSum(a));
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
