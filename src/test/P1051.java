package test;

import java.util.*;
import java.io.*;

/**
 * 쉬운 단순 구현
 */
public class P1051 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[][] arr;

    public static void main(String[] args) {
        solve1();
    }

    static void solve1() {
        input();
        int maxLength=Math.min(N,M);

        Loop1:for(int l=maxLength; l>=1; --l){

            for(int i=0; i+l-1<N; ++i){
                for(int j=0; j+l-1<M; ++j){
                    if(validate(i,j,l)){
                        sb.append(l*l);
                        break Loop1;
                    }
                }
            }
        }
        System.out.print(sb.toString());
    }

    static boolean validate(int i, int j,int l){
        if(arr[i][j]!=arr[i+l-1][j]) return false;
        if(arr[i][j]!=arr[i][j+l-1]) return false;
        if(arr[i][j]!=arr[i+l-1][j+l-1]) return false;
        return true;
    }

    private static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];

        for (int i = 0; i < N; ++i) {
            String s = sc.next();
            for (int j = 0; j < M; ++j) {
                arr[i][j] = s.charAt(j) - '0';
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
