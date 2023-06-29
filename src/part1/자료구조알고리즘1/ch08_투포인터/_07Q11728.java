package part1.자료구조알고리즘1.ch08_투포인터;

import java.util.*;
import java.io.*;

public class _07Q11728 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N,M;


    public static void main(String[] args){

        solve1();

    }

    static void solve1(){
        N= sc.nextInt();
        M= sc.nextInt();
        int[] merge = new int[N+M];
        for(int i=0; i<N; ++i){
            merge[i] =sc.nextInt();
        }
        for(int i=N; i<N+M; ++i){
            merge[i] = sc.nextInt();
        }

        Arrays.sort(merge);
        for(int i=0; i<N+M; ++i){
            sb.append(merge[i]).append(" ");
        }
        System.out.print(sb.toString().trim());

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
