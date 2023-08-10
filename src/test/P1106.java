package test;

import java.util.*;
import java.io.*;

/**
 * 냅색 알고리즘 : 같은 cost 에서 최대획득값 고려를 굳이 안해줘도 dp를 할때 적용됨
 */

public class P1106 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int C,N;

    static int[] gain= new int[100+1];


    static int[] dp= new int[100000+1]; //dp[i] : i만큼 cost 를 투자했을때 얻을수 있는 최대 gain

    public static void main(String[] args){
//        solve1();
//        solve2();
        solve3();
    }

    static void solve3(){
        C=sc.nextInt();
        N=sc.nextInt();
        int[] cost= new int[N];
        int[] gain= new int[N];
        for(int i=0; i<N; ++i){
            cost[i]=sc.nextInt();
            gain[i]=sc.nextInt();
        }

        for(int i=0; i<cost.length; ++i){
            for(int j=cost[i]; j<dp.length; ++j){
                dp[j]=Math.max(dp[j-cost[i]]+gain[i],dp[j]);
            }
        }

        int ans=-1;
        for(int i=1; i<dp.length; ++i){
            if(dp[i]>=C){
                ans=i;
                break;
            }
        }
        System.out.print(ans);
    }

    static void solve2(){
        C = sc.nextInt();
        N = sc.nextInt();
        Arrays.fill(gain, 0);
        for (int i = 0; i < N; ++i) {//냅색 알고리즘에서 굳이 최대값만 안남겨도 되긴함.
            int cost_ = sc.nextInt();
            int gain_ = sc.nextInt();
            gain[cost_] = Math.max(gain[cost_], gain_);
        }

        for(int cost=1; cost<=100; ++cost){
            int d= gain[cost];
            for(int i=cost; i<dp.length; ++i){
                dp[i]=Math.max(dp[i],dp[i-cost]+d);
            }
        }

        int ans=-1;
        for(int i=1; i<dp.length; ++i){
            if(dp[i]>=C){
                ans=i;
                break;
            }
        }
        System.out.print(ans);
    }

    static void solve1() {//O(NN) 이라서 하다가 안함

        C = sc.nextInt();
        N = sc.nextInt();
        Arrays.fill(gain, Integer.MIN_VALUE);
        for (int i = 0; i < N; ++i) {
            int cost_ = sc.nextInt();
            int gain_ = sc.nextInt();
            gain[cost_] = Math.max(gain[cost_], gain_);
        }

//        dp[1] = gain[1];
//        for (int i = 2; i < gain.length; ++i) {
//            dp[i] = gain[i];
//            for (int j = 1; j <= N / 2; ++j) {
//                dp[i] = Math.max(dp[i], dp[j] + dp[N - j]);
//            }
//        }
//
//        for(int i=gain.length; i<dp.length; ++i){
//
//        }
//
//        int ans = -1;
//        for (int i = 1; i < dp.length; ++i) {
//            if (dp[i] >= C) ans = i;
//        }
//        System.out.print(ans);
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
                    st=new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        String nextLine(){
            String str="";
            try{
                str=br.readLine();
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
