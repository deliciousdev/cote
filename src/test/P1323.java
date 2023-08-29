package test;

import java.util.*;
import java.io.*;

/**
 * 문제 그대로 시뮬레이션 하듯이 코딩 하면됨, 정수의 power를 구하는것은 Math.pow() 말고 직접 구현해서 하자...
 */
public class P1323 {

    static FastReader sc = new FastReader();

    static int n, k;

    public static void main(String[] args) {
//        solve1();
        solve2();
    }

    static void solve2(){
        String nTemp=sc.next();
        final int nLength=nTemp.length();
        n =Integer.parseInt(nTemp);
        k = sc.nextInt();

        boolean[] checked = new boolean[k];


        long number= n;
        int cnt=0;
        while(true){
            ++cnt;

            long remainder = number % k;
            if (remainder == 0) {
                System.out.print(cnt);
                System.exit(0);
            }
            if(checked[(int)remainder]){
                System.out.print(-1);
                System.exit(0);
            }

            checked[(int)remainder]=true;
            number= remainder*powerOfTen(nLength)+n;
        }
    }

    static void solve1() {

        String nTemp=sc.next();
        final int nLength=nTemp.length();
        n =Integer.parseInt(nTemp);
        k = sc.nextInt();

        boolean[] checked = new boolean[k];

        int cnt = 0;
        long number= n;
        do {
            ++cnt;

            long remainder = number % k;
            if (remainder == 0) {
                System.out.print(cnt);
                System.exit(0);
            }
            if(checked[(int)remainder]){
                System.out.print(-1);
                System.exit(0);
            }

            checked[(int)remainder]=true;
            number= remainder*powerOfTen(nLength)+n;
        } while (true);
    }

    static long powerOfTen(int n){
        long result=1;
        while(n-->0){
            result*=10;
        }
        return result;
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
