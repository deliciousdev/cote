package test;

import java.util.*;
import java.io.*;

public class P1024 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, L;

    public static void main(String[] args) {
        solve1();
    }

    static void solve1() {
        N = sc.nextInt();
        L = sc.nextInt();

        boolean exist=false;
        for (int x = L; x <= 100; ++x) {
            if (2 * N % x != 0 ) continue;
            if((2*N/x-x-1)%2!=0) continue;

            int a= (2*N/x-x-1)/2;
            if(a>=-1){
                exist=true;
                setStringBuilder(a,x);
                break;
            }
        }

        System.out.print(exist?sb.toString():-1);
    }

    static void setStringBuilder(int a, int x){
        for(int i=1; i<=x; ++i){
            sb.append(a+i).append(" ");
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
