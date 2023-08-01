package test;

import java.util.*;
import java.io.*;

/**
 * 바둑판 배열은 i+j 가 홀수 인지 짝수인지...
 */
public class P1018 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();


    static char[][] board;
    static int N,M;
    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        N=sc.nextInt();
        M=sc.nextInt();
        board= new char[N][M];
        for(int i=0; i<N; ++i){
            board[i]=sc.next().toCharArray();
        }

        int ans=Integer.MAX_VALUE;
        for(int i=0; i+7<N; ++i){
            for(int j=0; j+7<M; ++j){
//                int cnt=count(i,j);
//                int cnt= count2(i,j);
                int cnt= count3(i,j);
                ans=Math.min(ans,cnt);
            }
        }
        System.out.print(ans);
    }

    static int count3(int startRow,int startCol){
        String w="WBWBWBWB";
        String b="BWBWBWBW";
        int cnt1=0;
        for(int i=0; i<8; ++i){
            for(int j=0; j<8; ++j){
                int row= startRow+i;
                int col = startCol+j;
                if(i%2==0){
                    if(w.charAt(j)!=board[row][col]){
                        ++cnt1;
                    }
                }
                else{
                    if(b.charAt(j)!=board[row][col]){
                        ++cnt1;
                    }
                }
            }
        }

        int cnt2=0;
        for(int i=0; i<8; ++i){
            for(int j=0; j<8; ++j){
                int row= startRow+i;
                int col = startCol+j;
                if(i%2==0){
                    if(b.charAt(j)!=board[row][col]){
                        ++cnt2;
                    }
                }
                else{
                    if(w.charAt(j)!=board[row][col]){
                        ++cnt2;
                    }
                }
            }
        }
        return Math.min(cnt1,cnt2);
    }

    static int count2(int startRow,int startCol){
        int cnt1=0;
        for(int i=0; i<8; ++i){
            for(int j=0; j<8; ++j){
                int row=startRow+i;
                int col=startCol+j;
                if((row+col)%2==0){
                    if(board[row][col]!='W'){
                        ++cnt1;
                    }
                }
                else{
                    if(board[row][col]!='B'){
                        ++cnt1;
                    }
                }
            }
        }

        int cnt2=0;
        for(int i=0; i<8; ++i){
            for(int j=0; j<8; ++j){
                int row=startRow+i;
                int col=startCol+j;
                if((row+col)%2==0){
                    if(board[row][col]!='B'){
                        ++cnt2;
                    }
                }
                else{
                    if(board[row][col]!='W'){
                        ++cnt2;
                    }
                }
            }
        }
        return Math.min(cnt1,cnt2);
    }
    static int count(int startRow, int startCol){

        int cnt1=0;
        //w로 시작 짝수열
        for(int i=0; i<64; i+=2){
           int row= startRow+(i/8); //이걸 그냥 int row=i/8 ; int col= i%8; 로 했어서 디버깅 하는데 오래걸림....
           int col= startCol+(i%8);
           if(row%2==0){
               if(board[row][col]!='W'){
                   ++cnt1;
               }
           }
           else{
               if(board[row][col]!='B'){
                   ++cnt1;
               }
           }
        }
        //w로시작 홀수열
        for(int i=1; i<64; i+=2){
            int row= startRow+(i/8);
            int col= startCol+(i%8);
            if(row%2==0){
                if(board[row][col]!='B'){
                    ++cnt1;
                }
            }
            else{
                if(board[row][col]!='W'){
                    ++cnt1;
                }
            }
        }

        int cnt2=0;
        //B로 시작 짝수열
        for(int i=0; i<64; i+=2){
            int row= startRow+(i/8);
            int col= startCol+(i%8);
            if(row%2==0){
                if(board[row][col]!='B'){
                    ++cnt2;
                }
            }
            else{
                if(board[row][col]!='W'){
                    ++cnt2;
                }
            }
        }
        //B로시작 홀수열
        for(int i=1; i<64; i+=2){
            int row= startRow+(i/8);
            int col= startCol+(i%8);
            if(row%2==0){
                if(board[row][col]!='W'){
                    ++cnt2;
                }
            }
            else{
                if(board[row][col]!='B'){
                    ++cnt2;
                }
            }
        }
        return Math.min(cnt1,cnt2);
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
