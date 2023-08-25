package test;

import java.util.*;
import java.io.*;

public class P1270 {


    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();
    static int n;
    public static void main(String[] args){
//        solve1(); //정렬을 이용한 카운팅
        solve2();//map을 이용한 카운팅 : 좀 더 빠름
    }


    static void solve2(){

        Map<Long,Integer> cnt= new HashMap<>();
        n= sc.nextInt();

        while(n-->0){

            int total= sc.nextInt();
            for(int i=0; i<total; ++i){
                long number= sc.nextLong();
                cnt.merge(number,1,Integer::sum);
            }
            sb.append(calcWinner(cnt,total)).append("\n");
            cnt.clear();
        }
        System.out.print(sb.toString());
    }

    static String calcWinner(Map<Long,Integer> cnt,int total){
        int half=total/2;
        int mxCnt=Integer.MIN_VALUE;
        long frequentNumber=Long.MAX_VALUE;

        for (Long number : cnt.keySet()) {
            if(cnt.get(number)>mxCnt){
                mxCnt=cnt.get(number);
                frequentNumber=number;
            }
        }
        if(mxCnt>half) return String.valueOf(frequentNumber);
        return "SYJKGW";
    }
    static void solve1(){
        n= sc.nextInt();

        while(n-->0){
            long[] soldier = new long[sc.nextInt()];
            for(int i=0; i<soldier.length; ++i){
                soldier[i]=sc.nextLong();
            }
            Arrays.sort(soldier);

            sb.append(calcWinner(soldier)).append("\n");
        }
        System.out.print(sb.toString());
    }

    static String calcWinner(long[] soldier){

        int half= soldier.length/2;

        int cnt=1;
        long frequentNumber=-1;
        int mxCnt=Integer.MIN_VALUE;
        for(int i=1; i<soldier.length; ++i){
            if(soldier[i]!=soldier[i-1]){
                cnt=1;
            }
            else{
                ++cnt;
                if(mxCnt<cnt){
                    mxCnt=cnt;
                    frequentNumber=soldier[i];
                }
            }
        }

        if(mxCnt>half) return String.valueOf(frequentNumber);
        return "SYJKGW";
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

        long nextLong(){
            return Long.parseLong(next());
        }
    }
}
