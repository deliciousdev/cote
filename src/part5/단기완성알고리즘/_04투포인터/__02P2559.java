package part5.단기완성알고리즘._04투포인터;

import java.util.*;
import java.io.*;

public class __02P2559 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N,K;

    public static void main(String[] args){
        solve1(); //누적합
//        solve2(); //윈도우
//        solve3(); // 투포인터
    }

    static void solve1(){
        N= sc.nextInt();
        K= sc.nextInt();

        int[] acc= new int[N+1];

        for(int i=1; i<=N; ++i){
            acc[i]= acc[i-1]+sc.nextInt();
        }

        int ans=Integer.MIN_VALUE;
        for(int i=1; i<=N+1-K; ++i){
            int temp = acc[i+K-1]-acc[i-1];
            ans=Math.max(ans,temp);
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
