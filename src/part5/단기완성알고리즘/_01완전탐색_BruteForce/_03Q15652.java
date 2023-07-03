package part5.단기완성알고리즘._01완전탐색_BruteForce;

import java.util.*;
import java.io.*;

/**
 * 중복 조합
 * nCm
 * 간단하게 시간복잡도를 계산할때는 그냥 N^M 으로 함 ( nCm 이 적어도 N^M 보다는 작으니까)
 */
public class _03Q15652 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[] result;

    static int N,M;

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        N= sc.nextInt();
        M= sc.nextInt();
        result= new int[M+1];

        rec_func(1,1);
        System.out.print(sb.toString().trim());
    }

    static void rec_func(int k,int s){
        if(k>M){
            for(int i=1; i<=M; ++i){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }



        for(int i=s; i<=N; ++i){
            result[k]=i;
            rec_func(k+1,i);
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
