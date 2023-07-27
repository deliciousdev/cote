package test;

import java.util.*;
import java.io.*;

public class P2439 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N;

    public static void main(String[] args){
        solve1();
//        System.out.print(sb.toString().trim());//trim() 하면 첫번째줄 앞에 빈칸들 날라감..
        System.out.print(sb.toString());
    }
    static void solve1(){
        N=sc.nextInt();

        for(int i=1; i<=N; ++i){

            for(int j=N; j>i; --j){
                sb.append(" ");
            }
            for(int j=1; j<=i; ++j){
                sb.append("*");
            }
            sb.append("\n");
        }
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
                    st=new StringTokenizer(br.readLine());
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
