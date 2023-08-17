package test;

import java.util.*;
import java.io.*;

/**
 * 좋은 dp : 과정을 나눌것이 아니라 현재 결과를 보고 경우를 나눔
 */
public class P1149 {

    static FastReader sc= new FastReader();
    static int n;
    static int[][] cost;

    static int[][] dp; //dp[i][a] : i번째 에서 a 색깔일때 현재까지 i번 째까지 최소비용

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        n= sc.nextInt();
        cost= new int[n+1][3];
        dp = new int[n+1][3];

        for(int i=1; i<=n; ++i){
            for(int j=0; j<3; ++j){
                cost[i][j]=sc.nextInt();
            }
        }

        for(int i=1; i<=n; ++i){
            dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+cost[i][0];
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+cost[i][1];
            dp[i][2]=Math.min(dp[i-1][1],dp[i-1][0])+cost[i][2];
        }

        int ans = Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
        System.out.print(ans);
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
