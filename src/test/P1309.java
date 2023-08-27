package test;

import java.util.*;
import java.io.*;

/**
 * dp :점화식 2가지 있네
 */
public class P1309 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int n;
    static final int MOD=9901;
    public static void main(String[] args) {
        solve1();
    }

    static void solve1(){
        n= sc.nextInt();
        int[][] dp = new int[n+1][3];
        //dp[i][0]: i번째 왼쪽 우리에 넣을 수 있는 경우의수
        //dp[i][1] :i번째 오른쪽 우리에 넣을 수 있는 경우의수
        //dp[i][2] : i번째 우리에 넣지 않을 수 있는 경우의수


        dp[1][0]=1;
        dp[1][1]=1;
        dp[1][2]=1;
        for(int i=2; i<=n; ++i){
            dp[i][0]=(dp[i-1][1]+dp[i-1][2])%MOD;
            dp[i][1]=(dp[i-1][0]+dp[i-1][2])%MOD;
            dp[i][2]=(dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%MOD;
        }

        int result= (dp[n][0]+dp[n][1]+dp[n][2])%MOD;
        System.out.print(result);
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
