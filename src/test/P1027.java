package test;

import java.util.*;
import java.io.*;

public class P1027 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] b;
    static double[][] slope;

    public static void main(String[] args) {
        N = sc.nextInt();
        b = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            b[i] = sc.nextInt();
        }
        slope = new double[N + 1][N + 1];
        solve1();
    }

    static void solve1() {
        int ans = 0;
        for (int i = 1; i < b.length; ++i) {
            int cnt = 0;
            for (int j = 1; j < b.length; ++j) {
                if (i == j) continue;
                if (visible(i, j)) {
                    ++cnt;
                }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.print(ans);
    }

    static boolean visible(int i, int j) {
        double a = (double) (b[j] - b[i]) / (j - i);

        if (j > i) {
            for (int k = i + 1; k < j; ++k) {
                int dh = b[k] - b[i];
                int dn = k - i;
                double slope = (double) dh / dn;
                if (slope >= a) return false;
            }
            return true;
        }
        else{
            for(int k=j+1; k<i; ++k){
                int dh = b[k] - b[i];
                int dn = k - i;
                double slope = (double) dh / dn;
                if (slope <= a) return false;
            }
            return true;
        }
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
