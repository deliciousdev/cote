package test;

import java.util.*;
import java.io.*;

/**
 * 나눗셈 하는거 시뮬레이션
 */
public class P1312 {

    static FastReader sc = new FastReader();
    static int a, b, n;

    public static void main(String[] args) {
        solve1();
    }

    static void solve1() {
        a = sc.nextInt();
        b = sc.nextInt();
        n = sc.nextInt();

        int cnt = 1;
        int number = -1;
        int remainder= a % b;
        while (cnt <= n) {
            remainder *= 10;
            number = remainder / b;
            remainder %=b;

            ++cnt;
        }
        System.out.print(number);
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

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
