package test;

import java.util.*;
import java.io.*;

/**
 * 최대공약수 : 유클리드 호제법
 */
public class P1188 {

    static FastReader sc= new FastReader();

    static int n,m;

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        n= sc.nextInt();
        m= sc.nextInt();

//        int gcd= calcGcd(n,m);
        int gcd= calcGcd2(n,m);

        int n_= n/gcd;
//        int ans=(m-1) - (n-1)/n_;
//        int ans=m - n/n_;
        int ans= m-gcd;
        System.out.print(ans);
    }

    static int calcGcd(int a, int b){
        int mx= Math.max(a,b);
        int mn= Math.min(a,b);
        if(mx%mn==0) return mn;
        return calcGcd(mn,mx%mn);
    }

    static int calcGcd2(int a, int b){
        int mx= Math.max(a,b);
        int mn= Math.min(a,b);
        while(mx%mn!=0){
            int r= mx%mn;
            mx=mn;
            mn=r;
        }
        return mn;
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null||!st.hasMoreElements()){
                try{
                    st= new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

    }
}
