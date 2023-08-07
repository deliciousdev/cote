package test;

import java.util.*;
import java.io.*;

/**
 * 음수 모듈러연산, StringBuilder.reverse();
 */
public class P1112 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int x, b;
    static ArrayList<Integer> arr;

    public static void main(String[] args) {
//        solve1();
        solve2();
    }


    static void solve2() {
        x = sc.nextInt();
        b = sc.nextInt();
        boolean numberIsNegative=x<0;
        while (true) {
            int q = x / b;
            int remainder = x % b;
            if (remainder < 0) {
                if (b < 0) {
                    ++q;
                    remainder += Math.abs(b);
                }
                else{
                    remainder=Math.abs(remainder);
                }
            }
            sb.append(remainder);

            if (q == 0) break;
            x = q;
        }

        if (numberIsNegative && b>0) sb.append('-');

        System.out.print(sb.reverse());
    }

    static void solve1() {
        x = sc.nextInt();
        b = sc.nextInt();
        arr = new ArrayList<>();

        if (x == 0) {
            System.out.print(0);
            System.exit(0);
        }

        if (b > 0) {
            if (x < 0) {
                sb.append('-');
            }
            int x_ = Math.abs(x);
            while (x_ != 0) {//이거때문에 0 이 여기 못들어가서 예외처리를 해줘야함
                int remainder = x_ % b;
                arr.add(remainder);
                x_ /= b;
            }

        } else {
            while (x != 0) {
                int q = x / b;
                int remainder = x - q * b;
                if (remainder < 0) {
                    ++q;
                    remainder += Math.abs(b);
                }
                arr.add(remainder);
                x = q;
            }
        }

        print();
    }

    static void print() {
        for (int i = arr.size() - 1; i >= 0; --i) {
            sb.append(arr.get(i));
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
