package part5.단기완성알고리즘._09동적프로그래밍;

import java.util.*;
import java.io.*;

public class __01P1003 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int T,N;
    static int[][] d;
    public static void main(String[] args){
        input();
        solve1();
        int t= T;
        while(t-->0){
            int q= sc.nextInt();
            sb.append(d[q][0]).append(" ").append(d[q][1]).append("\n");
        }

        System.out.print(sb.toString().trim());
    }

    static void solve1(){
        d[0][0]=1;
        d[0][1]=0;
        d[1][0]=0;
        d[1][1]=1;

        for(int i=2; i<d.length; ++i){
            d[i][0]=d[i-1][0]+d[i-2][0];
            d[i][1]= d[i-1][1]+d[i-2][1];
        }
    }

    static void input(){
        T=sc.nextInt();
        d=new int[40+1][2];
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
