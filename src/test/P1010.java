package test;

import java.util.*;
import java.io.*;

/**
 * dp 콤비네이션, 메모이제이션
 */
public class P1010 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args){
//        solve1(); //콤비네이션 직접 계산
        solve2();//파스칼 삼각형 (dp) : N개중R개를 선택하는 경우의수 = A를 포함하는경우 + A를 포함하지 않는 경우  : nCr = n-1Cr-1 + n-1Cr
    }

    static void solve2(){
        long[][] c = new long[31][31];

        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();

            long ans= combi(m,n,c);
            sb.append(ans).append("\n");
        }
        System.out.print(sb.toString());
    }

    static long combi(int n, int r,long[][] c){

        if(c[n][r]!=0) return c[n][r];

        if(n==r) return c[n][r]=1;
        if(r==1) return c[n][r]=n;

        return c[n][r]=combi(n-1,r-1,c)+combi(n-1,r,c);
    }

    static void solve1(){
        int t= sc.nextInt();

        while(t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();

            int n_= Math.min(n,m-n);

            long temp=1;
            for(int i=m ; i>=m-n_+1; --i){
                temp*=i;
            }
            for(int i=n_; i>=2; --i ){
                temp/=i;
            }
            sb.append(temp).append("\n");
        }
        System.out.print(sb.toString());
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br =new BufferedReader(new InputStreamReader(System.in));
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
