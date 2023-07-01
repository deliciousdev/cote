package part1.자료구조알고리즘1.ch08_투포인터;

import java.util.*;
import java.io.*;

/**
 * 이진탐색, 투포인터, 부르트포스 다 가능
 */
public class _09Q15831 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N,B,W;

    public static void main(String[] args){
        solve1();
//        solve2(); //브루트포스 ,누적합
//        solve3();//틀린거 : 반례 : 4 0 2 BWWW
    }

    static void solve1(){
        N= sc.nextInt();
        B= sc.nextInt();
        W= sc.nextInt();
        char[] arr =sc.next().toCharArray();

        int[] cnt= new int['z'];


        int ans =0;

        int left=0;
        int right=-1;
        while(right<=arr.length-2){

            if(arr[right+1] == 'B' && cnt['B']==B){
                --cnt[arr[left]];
                ++left;
            }
            else{
                ++right;
                ++cnt[arr[right]];
            }

            if(cnt['W'] >=W) {
                int length = right - left + 1;
                ans = Math.max(ans, length);
            }
        }

        System.out.print(ans);
    }

    static void solve3(){
        N= sc.nextInt();
        B= sc.nextInt();
        W= sc.nextInt();
        char[] arr =sc.next().toCharArray();

        int[] cnt= new int['z'];
        int left=0;
        int right=0;
        ++cnt[arr[right]];

        int ans =0;
        if(cnt['W'] >=W) {
            int length = right - left + 1;
            ans = Math.max(ans, length);
        }

        while(right<=arr.length-2){

            if(arr[right+1] == 'B' && cnt['B']==B){
                --cnt[arr[left]];
                ++left;
            }
            else{
                ++cnt[arr[right+1]];
                ++right;
            }

            if(cnt['W'] >=W) {
                int length = right - left + 1;
                ans = Math.max(ans, length);
            }
        }

        System.out.print(ans);
    }

    static void solve2(){
        N=sc.nextInt();
        B=sc.nextInt();
        W= sc.nextInt();

        char[] arr= sc.next().toCharArray();
        int[][] acc = new int[N+1][2];//W B
        for(int i=1; i<=N; ++i){
            acc[i][0] =acc[i-1][0];
            acc[i][1]=acc[i-1][1];
            if(arr[i-1]=='W'){
                ++acc[i][0];
            }
            else{
                ++acc[i][1];
            }
        }

        int ans=0;
        for(int i=1; i<=N; ++i){
            for(int j=i; j<=N; ++j){
                int w = acc[j][0]-acc[i-1][0];
                int b = acc[j][1]-acc[i-1][1];

                if(w>=W && b<=B){
                    int length = j-i+1;
                    ans= Math.max(ans,length);
                }
            }
        }
        System.out.print(ans);
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreElements()){
                try{
                    st= new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        String nextLine(){
            String str= "";
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
