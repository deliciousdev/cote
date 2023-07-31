package test;

import java.util.*;
import java.io.*;

/**
 * (x-1)%MOD +1
 */
public class P1009 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
//        solve1();
        solve2();
    }

    static void solve2() {
        int t = sc.nextInt();
        int[][] arr = {
                {0},//dummy
                {1},
                {2, 4, 8, 6},
                {3, 9, 7, 1},
                {4, 6},
                {5},
                {6},
                {7, 9, 3, 1},
                {8, 4, 2, 6},
                {9, 1},
                {10}
        };
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int a_=(a-1)%10+1;
            int temp =( b-1) % (arr[a_].length );
            int result = arr[a_][temp];
            sb.append(result).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void solve1() {
        int t = sc.nextInt();
        int[] f = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int result = 1;
            for (int i = 1; i <= b; ++i) {
                result *= a;
                result %= 10;
            }

            sb.append(f[result]).append("\n");
        }
        System.out.print(sb.toString());
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
