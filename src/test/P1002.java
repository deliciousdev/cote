package test;

import java.util.*;
import java.io.*;

public class P1002 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) {
        solve1();
    }

    static void solve1() {
        int T = sc.nextInt();
        while (T-- > 0) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();
            int ans = countCase(x1, y1, r1, x2, y2, r2);
            sb.append(ans).append("\n");
        }
        System.out.print(sb.toString());
    }

    static int countCase(int x1, int y1, int r1, int x2, int y2, int r2) {

        double d = calcDistance(x1, y1, x2, y2);

        int cnt = -2;
        if(d==0 && r1==r2){
            cnt=-1;
        }
        else if (d == r1 + r2 || d == Math.abs(r1 - r2)) {
            cnt = 1;
        }
        else if (d < r1 + r2 && d > Math.abs(r1 - r2)) {
            cnt = 2;
        }
        else if (d < Math.abs(r1 - r2) || d > r1 + r2) {
            cnt = 0;
        }

        return cnt;
    }

    static double calcDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
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
