package test;

import java.util.*;
import java.io.*;


/**
 * 브루트포스,dp
 */
public class P1535 {

    static FastReader sc= new FastReader();
    static int n;
    static int[] hp,joy;
    static int mxJoy;
    
    static int[] dp; //dp[i]
    public static void main(String[] args){
        solve1();
//        solve2();//dp
    }
    
    static void solve2(){
    }
    static void solve1(){
        n= sc.nextInt();
        hp =new int[n];
        joy= new int[n];
        for(int i = 0; i< hp.length; ++i){
            hp[i]=sc.nextInt();
        }
        for(int i=0; i<joy.length; ++i){
            joy[i]=sc.nextInt();
        }

        dfs(0,100,0);
        System.out.print(mxJoy);
    }

    static void dfs(int k, int currentHp,int currentJoy){//k번째 까지 탐색해줘
        mxJoy= Math.max(mxJoy,currentJoy);
        if(k==n) return;

        if(currentHp- hp[k]>0){
            dfs(k+1,currentHp- hp[k],currentJoy+joy[k]);
        }

        dfs(k+1,currentHp,currentJoy);
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
