package test;

import java.util.*;
import java.io.*;

/**
 * 분할정복, 재귀
 */
public class P1780 {

    static FastReader sc= new FastReader();
    static int n;

    static int[][] arr;
    static int[] cnt = new int[3];//-1,0,1

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        n=sc.nextInt();
        arr= new int[n][n];
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                arr[i][j]=sc.nextInt();
            }
        }

        func(n,0,0);

        print();
    }

    static void print(){
        StringBuilder sb= new StringBuilder();
        sb.append(cnt[-1 + 1]).append("\n").
                append(cnt[0 + 1]).append("\n").
                append(cnt[1 + 1]).append("\n");
        System.out.print(sb.toString());
    }

    static void func(int size,int r, int c){

        if(isAllTheSame(size,r,c)){
            ++cnt[arr[r][c]+1];
            return;
        }

        int l =size/3;
        for(int i=0; i<3; ++i){
            int row= r+l*i;
            for(int j=0; j<3; ++j){
                int col= c+l*j;
                func(l,row,col);
            }
        }
    }

    static boolean isAllTheSame(int l,int startRow,int startCol){
        for(int i=startRow; i<startRow+l; ++i){
            for(int j=startCol; j<startCol+l; ++j){
                if(arr[i][j]!=arr[startRow][startCol]) return false;
            }
        }
        return true;
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
