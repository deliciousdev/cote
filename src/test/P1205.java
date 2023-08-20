package test;

import java.util.*;
import java.io.*;

/**
 * 간단한 구현
 */
public class P1205 {

    static FastReader sc= new FastReader();

    static int n,newScore,p;

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        n= sc.nextInt();
        newScore= sc.nextInt();
        p =sc.nextInt();

        int biggerCnt=0;
        int equalCnt=0;
        for(int i=0; i<n; ++i){
            int score= sc.nextInt();
            if(score>newScore){
                ++biggerCnt;
            }
            else if( score==newScore){
                ++equalCnt;
            }
        }

        if(biggerCnt+equalCnt>=p){
            System.out.print(-1);
            System.exit(0);
        }

        int rank=biggerCnt+1;
        System.out.print(rank);
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
