package test;

import java.util.*;
import java.io.*;

public class P1193 {

    static FastReader sc = new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int x;

    public static void main(String[] args) {
//        solve1();//일반항
        solve2();//일반항 없이 그냥 계차로
    }

    static void solve2(){
        x= sc.nextInt();
        int d=1;
        int an=1;
        int an_1=2;
        int n=1;
        while(!(an<=x&&x<an_1)) {
            ++n;
            int temp = an_1;
            an_1 += (++d);
            an = temp;
        }

        int xR= n%2==0? 1+x-an : n-(x-an);
        int xC= n%2==0? n-(x-an) : 1+(x-an);
        sb.append(xR).append("/").append(xC);
        System.out.print(sb.toString());
    }
    static void solve1() {
        x = sc.nextInt();
        int n = 1;
        int an = 1;
        int an_1 = 2;
        while (!(an <= x && x < an_1)) {
            ++n;
            an = an_1;
            an_1 = 1 + (n) * (n + 1) / 2;
        }

        int d= x-an;
        int xR = n%2==0? 1+d :n-d;
        int xC= n%2==0? n-d : 1+d;

        sb.append(xR).append("/").append(xC);
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
