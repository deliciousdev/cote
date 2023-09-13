package test;

import java.util.*;
import java.io.*;

/**
 * 그리디
 */
public class P1455 {

    public static FastReader sc= new FastReader();
    static int n,m;
    static int[][] coins;
    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        n= sc.nextInt();
        m= sc.nextInt();
        coins = new int[n][m];
        for(int i=0; i<n; ++i){
            String s = sc.next();
            for(int j=0; j<m; ++j){
                coins[i][j]=s.charAt(j)-'0';
            }
        }

        int flipCnt=0;
        for(int col=m-1; col>=0 ; --col){
            for(int row=n-1; row>=0; --row){
                if(coins[row][col]==1) {
                    ++flipCnt;
                    flip(coins,row,col);
                }
            }
        }

        System.out.print(flipCnt);
    }

    static void flip(int[][] coins, int a, int b){
        for(int i=0; i<=a; ++i){
            for(int j=0; j<=b; ++j){
                int v = coins[i][j];
//                coins[i][j]= (v-1)*-1;
                coins[i][j]=  v==1?0:1;
            }
        }
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
