package test;

import java.util.*;
import java.io.*;

public class P1034 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N,M,K;
    static int[][] lamp;

    public static void main(String[] args){
        N=sc.nextInt();
        M=sc.nextInt();
        lamp= new int[N][M];
        for(int i=0; i<N; ++i){
            String s= sc.next();
            for(int j=0; j<M; ++j){
                lamp[i][j]=s.charAt(j-'0');
            }
        }
        K=sc.nextInt();
        solve1();
    }
    static void solve1(){

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
