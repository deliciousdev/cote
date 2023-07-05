package part1.자료구조알고리즘1.ch08_투포인터;


import java.util.*;
import java.io.*;

public class _11Q14465 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N,K,B;
    static boolean[] broken;

    public static void main(String[] args){
//        solve1(); //누적합
        solve2(); //윈도우
    }

    static void solve1(){
        N= sc.nextInt();
        K= sc.nextInt();
        B= sc.nextInt();
        broken = new boolean[N+1];

        for(int i=0; i<B; ++i){
            broken[sc.nextInt()]=true;
        }

        int[] acc= new int[N+1];
        for(int i=1; i<=N; ++i){
            acc[i]=acc[i-1];
            if(broken[i]){
                ++acc[i];
            }
        }

        int ans= Integer.MAX_VALUE;
        for(int i=K; i<=N; ++i){
            ans = Math.min(ans,acc[i]-acc[i-K]);
        }

        System.out.print(ans);
    }

    static void solve2(){
        N= sc.nextInt();
        K= sc.nextInt();
        B= sc.nextInt();

        broken = new boolean[N+1];
        int b= B;
        while(b-->0){
            broken[sc.nextInt()]=true;
        }

        int cntBroken=0;
        for(int i=1; i<=K; ++i){
            if(broken[i]) {
                ++cntBroken;
            }
        }
        int ans= cntBroken;

        for(int i=2; i<=N-K+1; ++i){
            if(broken[i-1]){
                --cntBroken;
            }
            if(broken[i+K-1]){
                ++cntBroken;
            }
            ans=Math.min(ans,cntBroken);
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
            while(st==null || !st.hasMoreElements()){
                try{
                    st= new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine(){
            String str= "";
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
