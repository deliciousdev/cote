package test;

import java.util.*;
import java.io.*;

public class P1124 {

    static FastReader sc = new FastReader();

    static int a, b;

    public static void main(String[] args) {
//        solve1();//문제를 있는그대로구현
        solve2();//소인수분해, 소수검증 여러번 해야할때 전처리를 한다
//        solve3();//에라토스테네스...라고함
    }

    static void solve3(){
        a=sc.nextInt();
        b=sc.nextInt();
        int[] cnt=new int[b+1];
        boolean[] checked=new boolean[b+1];


        for(int i=2; i<=b; ++i){
            if(checked[i]) continue;

            for(int n=1; n*i<=b; ++n){
                checked[n*i]=true;
                int temp=n*i;
                while(temp%i==0){
                    ++cnt[n*i];
                    temp/=i;
                }
            }
        }

        int ans=0;
        for(int i=a; i<=b; ++i){
            int primeFactorLength=cnt[i];
            if(cnt[primeFactorLength]==1){
                ++ans;
            }
        }
        System.out.print(ans);
    }

    static void solve2(){
        a= sc.nextInt();
        b=sc.nextInt();

        int[] cnt= new int[b+1];
//        int[] cnt= new int[100000+1];

        for(int i=2; i<cnt.length; ++i){
            if(cnt[i]!=0) continue;

            for(long x=i; x<=b; x*=i){//오버플로우 조심
                for(int d=1; x*d<=b; ++d){//x*d에서 오버플로우조심
                    ++cnt[(int)x*d];
                }
            }
        }

        int ans=0;
        for(int i=a; i<=b; ++i){
            int primeFactorLength= cnt[i];
            if(cnt[primeFactorLength]==1){
                ++ans;
            }
        }
        System.out.print(ans);
    }

    static void solve1() {
        a = sc.nextInt();
        b = sc.nextInt();

        int ans = 0;
        for (int i = a; i <= b; ++i) {
            int primeFactorLength = calcPrimeFactorLength(i);
            if (isPrime(primeFactorLength)) {
                ++ans;
            }
        }
        System.out.print(ans);
    }

    static boolean isPrime(int x) {
        if (x == 1) return false;
        for (int i = 2; i < x; ++i) {
            if (x % i == 0) return false;
        }
        return true;
    }

    static int calcPrimeFactorLength(int x) {

        int length = 0;
        for (int i = 2; i <= x; ++i) {
            while (x % i == 0) {
                x /= i;
                ++length;
            }
            if(x==1) break;
        }
        return length;
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
