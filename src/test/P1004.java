package test;

import java.util.*;
import java.io.*;

/**
 * java.lang.Math
 * Math.sqrt(), Math.pow(base,exponent)
 */
public class P1004 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int startCnt;
    static int destCnt;
    static int bothCnt;

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        int T=sc.nextInt();
        while(T-->0){
            startCnt=0;
            destCnt=0;
            bothCnt=0;

            int startX=sc.nextInt();
            int startY=sc.nextInt();
            int destX=sc.nextInt();
            int destY=sc.nextInt();

            int numCircle=sc.nextInt();

            while(numCircle-->0){
                int x=sc.nextInt();
                int y= sc.nextInt();
                int r= sc.nextInt();
                classify(startX,startY,destX,destY,x,y,r);
            }
            int ans= startCnt+destCnt-bothCnt*2;
            //int ans= startCnt+destCnt-bothCnt // 틀린 코드
            sb.append(ans).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void classify(int sx, int sy, int dx, int dy, int x, int y, int r){
        boolean containsStart =Math.sqrt(Math.pow(sx-x,2)+Math.pow(sy-y,2))<=r;
        boolean containsDest = Math.sqrt(Math.pow(dx-x,2)+Math.pow(dy-y,2))<=r;
        boolean containsBoth = containsStart && containsDest;

        if(containsStart){
            ++startCnt;
        }
        if(containsDest){
            ++destCnt;
        }
        if(containsBoth){
            ++bothCnt;
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
                str=br.readLine();
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
