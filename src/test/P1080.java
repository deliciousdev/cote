package test;

import java.util.*;
import java.io.*;

/**
 * 그리디 특징 : 미래는 몰르지만 지금 당장 일단은 이렇게 해야해
 * 사실 needSwitch라는 배열을 따로 안만들어도 되긴함
 */
public class P1080 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;

    static int[][] a;
    static int[][] b;
    static boolean[][] needSwitch;

    static int ans = 0;

    public static void main(String[] args) {
        input();

        needSwitch = new boolean[N][M];

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (a[i][j] != b[i][j]) {
                    needSwitch[i][j] = true;
                }
            }
        }

        solve1();//그리디
    }

    private static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        a = new int[N][M];
        b = new int[N][M];

        for (int i = 0; i < N; ++i) {
            String s = sc.next();
            for (int j = 0; j < M; ++j) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        for (int i = 0; i < N; ++i) {
            String s = sc.next();
            for (int j = 0; j < M; ++j) {
                b[i][j] = s.charAt(j) - '0';
            }
        }
    }

    public static void solve1() {
        for (int i = 0; i + 2 < needSwitch.length; ++i) {
            for (int j = 0; j + 2 < needSwitch[i].length; ++j) {
                if (needSwitch[i][j]) {
                    switch3x3(i, j);
                    ++ans;
                }
            }
        }

        System.out.print(validate() ? ans : -1);
    }

    static boolean validate() {
        for(int i=needSwitch.length-1; i>=0; --i){
            for(int j=needSwitch[i].length-1; j>=0; --j){
                if(needSwitch[i][j]) return false;
            }
        }
        return true;
    }

    static void switch3x3(int r, int c) {
        for (int i = r; i < r + 3; ++i) {
            for (int j = c; j < c + 3; ++j) {
                needSwitch[i][j] = !needSwitch[i][j];
            }
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
