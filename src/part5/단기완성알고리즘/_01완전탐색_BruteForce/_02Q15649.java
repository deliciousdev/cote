package part5.단기완성알고리즘._01완전탐색_BruteForce;

import java.util.*;
import java.io.*;

/**
 * 순열
 * 시간 복잡도 : 8!
 */
public class _02Q15649 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N,M;
    static int[] result;
    static boolean[] used;


    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        N=sc.nextInt();
        M= sc.nextInt();
        result = new int[M+1];
        used = new boolean[N+1];

        rec_func(1);
        System.out.print(sb.toString().trim());
    }

    static void rec_func(int k){
        if(k>M){
            for(int i=1;i<=M; ++i){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");

            return;
        }


        for(int i=1; i<=N; ++i){
            if(!used[i]){
                used[i]=true;
                result[k]=i;
                rec_func(k+1);
                used[i]=false;
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
