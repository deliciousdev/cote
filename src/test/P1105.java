package test;

import java.util.*;
import java.io.*;


/**
 * L에서 8이 나온 부분이 변경 될수 있는지 생각해본다 (8이 나온 횟수를 최소로 줄이기위함)-> L에서 idx 인덱스에서 나온 8을 없앨려면 R 이 idx 이하에서 L보다 숫자가 커야함
 * R이 L보다 최초로 숫자가 커지는 idx를 찾으면, 그 idx 뒤로는 L에서 나온 8을 없앨 수 있음.
 */
public class P1105 {

    static FastReader sc = new FastReader();


    public static void main(String[] args) {
//        solve1();
        solve2();
    }

    static void solve1() {
        String L = sc.next();
        String R = sc.next();

        if (R.length() > L.length()) {
            System.out.print(0);
            System.exit(0);
        }

        int idx = L.length();
        for (int i = 0; i < L.length(); ++i) {
            if (L.charAt(i) < R.charAt(i)) {
                idx = i;
                break;
            }
        }
        int cnt = 0;
        for (int i = 0; i < idx; ++i) {
            if (L.charAt(i) == '8') ++cnt;
        }
        System.out.print(cnt);
    }

    static void solve2() {
        String L = sc.next();
        String R = sc.next();

        if (R.length() > L.length()) {
            System.out.print(0);
            System.exit(0);
        }

        int cnt = 0;
        for (int i = 0; i < L.length(); ++i) {
            if (L.charAt(i) == R.charAt(i)) {
                if (L.charAt(i) == '8')
                    ++cnt;
            } else {
                break;
            }
        }
        System.out.print(cnt);
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
