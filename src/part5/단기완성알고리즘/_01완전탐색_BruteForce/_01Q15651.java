package part5.단기완성알고리즘._01완전탐색_BruteForce;

import java.util.*;
import java.io.*;

/**
 * 중복순열
 * 시간 복잡도 7^7
 */

public class _01Q15651 {
    static int N,M;

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[] result;

    public static void main(String[] args){

        solve1();
    }

    static void solve1(){
        N= sc.nextInt();
        M= sc.nextInt();
        result= new int[M+1];

        rec_func(1);
        System.out.print(sb.toString().trim());
    }

    static void rec_func(int k ){ //k번째 부터 M까지 골라줘 : 총 M개를 골랐으면 조건에 맞는 경우를 하나 찾았다는 의미
        if(k>M){
            for(int i=1; i<=M; ++i){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            //이거 때문에 시간초과
//            System.out.println(sb.toString().trim());
//            sb.setLength(0);
            return ;
        }

        for(int i=1; i<=N; ++i){
            result[k]=i;
            rec_func(k+1);
        }

    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null ||!st.hasMoreElements()){
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
