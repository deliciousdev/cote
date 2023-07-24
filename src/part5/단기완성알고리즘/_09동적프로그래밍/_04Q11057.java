package part5.단기완성알고리즘._09동적프로그래밍;

import java.util.*;
import java.io.*;

/**
 * N이 너무 커서 완전탐색은 좀... -> dp를 생각하자
 * 강의는 나랑 다르게 dp를 정의했음.
 */
public class _04Q11057 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N;
    static int[][] dp= new int[1000+2][11];
    static int[] sum= new int[1000+1];
    static int MOD=10007;
    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        N=sc.nextInt();
        for(int i=0; i<=9; ++i){//dp[i][j] ; i 자리수 인데 j 숫자로 시작하는 오름막수의 경우의수
            dp[1][i]=1;
        }
        for(int i=2; i<=N+1; ++i){ //N+1까지 dp를 구해줘야 sum 의 N을 구할 수 있음
            for(int j=9; j>=1; --j){
                dp[i][j]=(dp[i][j+1]+dp[i-1][j])%MOD;
            }
            sum[i-1]=(dp[i][1]+dp[i-1][0])%MOD;
        }


        int ans=0;
        for(int i=1; i<=N; ++i){
            ans+=sum[i];
        }
        ans%=MOD;
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
