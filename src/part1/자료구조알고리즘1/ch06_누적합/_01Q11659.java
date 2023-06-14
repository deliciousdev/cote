package part1.자료구조알고리즘1.ch06_누적합;

import java.util.*;
import java.io.*;

public class _01Q11659 {

    static FastReader sc = new FastReader();
    static StringBuilder sb= new StringBuilder();
    static int N,M;
    static int[] acc;
    public static void main(String[] args){

        solve1();
    }

    static void solve1(){
        init();


        int m= M;
        while(m-->0){
            int i= sc.nextInt();
            int j= sc.nextInt();
            sb.append(acc[j]- acc[i-1]).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void init(){
        N= sc.nextInt();
        M= sc.nextInt();
        acc = new int[N+1];

        int s=0;
        for(int i=0; i<N; ++i){
            acc[i+1]= s+= sc.nextInt();
        }
    }
    static class FastReader{
        BufferedReader br ;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st==null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine(){
            String str = "";
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
