package test;

import java.util.*;
import java.io.*;

/**
 * 수학 합이 일정할때, 곱이 가장 커질려면 수들이 비슷해져야함
 */
public class P1500 {

    static FastReader sc= new FastReader();
    static int s,k;
    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        s=sc.nextInt();
        k=sc.nextInt();

        int div= s/k;
        int mod=s%k;
        long ans=1;

        for(int i=1; i<=mod; ++i){
            ans *= (div + 1);
        }

        for(int i=1; i<=k-mod; ++i){
            ans*=div;
        }
        System.out.print(ans);
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while (st == null || !st.hasMoreElements()) {
                try{
                    st=new StringTokenizer(br.readLine());
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
