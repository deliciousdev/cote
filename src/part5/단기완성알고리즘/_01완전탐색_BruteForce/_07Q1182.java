package part5.단기완성알고리즘._01완전탐색_BruteForce;

import java.util.*;
import java.io.*;

/**
 *  nC0 + nC1 + nC2 + ... + nCn = (1+1)^N
 *
 *  모든 경우의수가 2^N 이기 때문에 cnt 의 상한값은 2^20 이다. int로 감당 가능
 *  sum 의 중간값도 int 로 감당 가능
 */

public class _07Q1182 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N,S;
    static int[] arr;
    static int[] combination;
    static int cnt;

    public static void main(String[] args){
//        solve1(); // 140ms : 모든 콤비네이션을 다 구해봄
        solve2(); // 200ms : 모든 경우의수를 다 구해봄 : 아무것도 안 선택했을때 주의
    }

    static void solve1(){
        N= sc.nextInt();
        S= sc.nextInt();
        arr= new int[N];
        for(int i=0; i<N; ++i){
            arr[i]=sc.nextInt();
        }
        combination = new int[N];

        for(int i=1; i<=N; ++i){
            pickAllCombination(i);
        }
        System.out.print(cnt);
    }
    static void pickAllCombination(int r){
        rec_func(0,-1,r);
    }

    static void rec_func(int k,int s, int r){
        if(k==r){
            int sum= calcSum(r);
            if(sum==S) {
                ++cnt;
            }
            return ;
        }

        for(int i=s+1; i<=N-1; ++i){
            combination[k]=i;
            rec_func(k+1,i,r);
        }
    }

    static int calcSum(int r){
        int sum=0;
        for(int i=0; i<r; ++i){
            sum+=arr[combination[i]];
        }
        return sum;
    }


    static void solve2(){
        N= sc.nextInt();
        S= sc.nextInt();
        arr= new int[N];
        for(int i=0; i<N; ++i){
            arr[i] = sc.nextInt();
        }

        rec_func2(0,0);
        if(S==0){
            --cnt;
        }
        System.out.print(cnt);
    }

    static void rec_func2(int k,int sum){
        if(k==N){
            if(sum==S){
                ++cnt;
            }
            return;
        }

        rec_func2(1+k,sum+arr[k]);

        rec_func2(1+k,sum);
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
