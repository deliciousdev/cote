package test;

import java.util.*;
import java.io.*;

/**
 * 분할 정복, 재귀..
 */
public class P1074 {

    static FastReader sc= new FastReader();

    static int N,r,c;
    static int ans;
    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        N=sc.nextInt();
        r=sc.nextInt();
        c=sc.nextInt();

        rec_func(N,0,0,0);
        System.out.print(ans);
    }

    static void rec_func(int n,int start,int startR,int startC){
        if(n==0){
            ans=start;
            return ;
        }

        int half= (int)Math.pow(2,n-1);

        int d=(int)Math.pow(2,2*n-2);
        if(r<startR+half && c<startC+half){
            rec_func(n-1,start,startR,startC);
        }
        else if( r<startR+half &&c>=startC+half){
            rec_func(n-1,start+d,startR,startC+half);
        }
        else if(r>=startR+half && c<startC+half){
            rec_func(n-1,start+d*2,startR+half,startC);
        }
        else if(r>=startR+half && c>=startC+half){
            rec_func(n-1,start+d*3,startR+half,startC+half);
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
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
