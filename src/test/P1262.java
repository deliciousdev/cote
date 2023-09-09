package test;

import java.util.*;
import java.io.*;

/**
 * 구현 ㅇㅇ 걍 외우면됨
 */
public class P1262 {

    static FastReader sc = new FastReader();
    static int n, r1, c1, r2, c2;
    static char[][] arr;
    static char[] e = "0abcdefghijklmnopqrstuvwxyz".toCharArray();//1~26 : (x-1)%26 +1
    static char[] character ="abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) {
//        solve1();//시간초과.
//        solve2();
        solve3();//모범답안
    }

    static void solve3(){
        n = sc.nextInt();
        r1 = sc.nextInt();
        c1 = sc.nextInt();
        r2 = sc.nextInt();
        c2 = sc.nextInt();
        arr = new char[r2 - r1 + 1][c2 - c1 + 1];

        for(int row=r1; row<=r2; ++row){
            for(int col=c1; col<=c2; ++col){
                int L = 2*n-1;
                int r= row%L;
                int c= col%L;
                int d= calcDistanceFromCenter(r,c,L);
                if(d>=n){
                    arr[row-r1][col-c1]='.';
                }
                else{
                    arr[row-r1][col-c1]=character[d%26];
                }
            }
        }

        print(arr);
    }
    static void solve2() {
        n = sc.nextInt();
        r1 = sc.nextInt();
        c1 = sc.nextInt();
        r2 = sc.nextInt();
        c2 = sc.nextInt();
        arr = new char[r2 - r1 + 1][c2 - c1 + 1];
        init(arr);

        for (int row = r1; row <= r2; ++row) {
            for (int col = c1; col <= c2; ++col) {

                int L = 2 * n - 1;
                int r = row % L;
                int c = col % L;

                int d=calcDistanceFromCenter(r,c,L);
                if(d>=n) continue;
                arr[row-r1][col-c1]=e[d%26+1];

            }
        }


        print(arr);
    }

    static void solve1() {
        n = sc.nextInt();
        r1 = sc.nextInt();
        c1 = sc.nextInt();
        r2 = sc.nextInt();
        c2 = sc.nextInt();
        arr = new char[r2 - r1 + 1][c2 - c1 + 1];
        init(arr);

        for (int row = r1; row <= r2; ++row) {
            for (int col = c1; col <= c2; ++col) {

                for (int i = 1; i <= n; ++i) {
                    int L = 2 * n - 1;
                    int r = row % L;
                    int c = col % L;
                    if (calcDistanceFromCenter(r, c, L) % 26 + 1 == i) {
                        arr[row - r1][col - c1] = e[(i - 1) % 26 + 1];
                    }
                }

            }
        }


        print(arr);
    }

    static int calcDistanceFromCenter(int row, int col, int L) {
        int centRow = L / 2;
        int centCol = L / 2;
        return Math.abs(centRow - row) + Math.abs(centCol - col);
    }

    static void init(char[][] arr) {
        for (int i = 0; i < arr.length; ++i) {
            Arrays.fill(arr[i], '.');
        }
    }

    static void print(char[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr[i].length; ++j) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
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

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
