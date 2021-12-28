package CourseraToolBox.CourseraToolBox.week2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class gcd {


    static long gcd(int a,int b) {
    	
    	if (b == 0)
        return a;
      
    	
    	return gcd(b, a % b);
      
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        
        System.out.println(gcd(a,b));
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
