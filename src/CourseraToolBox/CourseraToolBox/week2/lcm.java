package CourseraToolBox.CourseraToolBox.week2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class lcm {




    static long gcd(long a,long b) {
    	
    	if (b == 0)
        return a;
      
    	
    	return gcd(b, a % b);
      
    }
    
    static long lcm(long a, long b)
    {
    	return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        
        System.out.println(lcm(a,b));
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
