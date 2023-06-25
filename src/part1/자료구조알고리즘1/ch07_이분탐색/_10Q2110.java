package part1.자료구조알고리즘1.ch07_이분탐색;

import java.util.*;
import java.io.*;

/**
 * 가장 인접한 두 공유기 사이의 최대거리 : 가장 인접한 ~~ 최대  이런 워딩 자체가 Parametric Search 의 대표적인 유형임
 */
public class _10Q2110 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N,C;

    public static void main(String[] args){

        solve1();
    }

    static void solve1(){
        N= sc.nextInt();
        C= sc.nextInt();
        int[] arr= new int[N];
        for(int i=0; i<N; ++i){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);

        //mid : 공유기간 거리
        int left=1;
        int right= 1000000000; //arr[N-1]-arr[0]으로 하는게 더 효율적이긴함
        while(left<=right){
            int mid=(left+right)/2; //최대값을 고려하면 오버플로우에 대해서도 안전함 : left+right 의 최대값-> 2*right
            int modemCnt=calcModemCnt(arr,mid);
            if(modemCnt>=C){
                left=mid+1;
            }
            else{
                right= mid-1;
            }
        }
        System.out.print(right);
    }

    static int calcModemCnt(int[] arr, int distance){
        int modemCnt=1;//거리를 최대로 유지하면서 주어진 개수를 다 설치할려면 최대한 많이 설치해야함 그래서 제일 첫번째에 공유기는 설치를 해야함

        int d=0;
        for(int i=1; i<=N-1;++i){
            d+= arr[i]-arr[i-1];
            if( d>=distance){
                ++modemCnt;
                if(modemCnt>=C) return C;
                d=0;
            }
        }
        return modemCnt;
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
