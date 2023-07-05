package part1.자료구조알고리즘1.ch08_투포인터;

import java.util.*;
import java.io.*;

public class _12Q10025 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N,K;
    static int[] x = new int[10000002];
    static final int LAST=1000000;
    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        N=sc.nextInt();
        K= sc.nextInt();

        for(int i=0; i<N; ++i){
            int g =sc.nextInt();
            int x_ = sc.nextInt();
            x[x_]=g;
        }

        int sum=0;
        int d= 2*K+1;

        for(int i=0; i<=d-1; ++i){
            sum+=x[i];
        }
        int ans= sum;

        for(int i=1; i<=LAST-d+1; ++i){
            sum-= x[i-1];
            sum+=x[i+d-1];
            ans= Math.max(ans,sum);
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
            while(st==null|| !st.hasMoreElements()){
                try{
                    st= new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine(){
            String str="";
            try{
                str= br.readLine();
            }catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
