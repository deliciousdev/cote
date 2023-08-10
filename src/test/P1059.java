package test;

import java.util.*;
import java.io.*;

/**
 *어떤 값의 가장 가까운 양옆의 수를 구하는거 -> treeSet을 이용하면 편함
 * ceiling : 크거나 같은것 중에 가장 작은거
 * floor : 작거나 같은거 중에 가장 큰거
 * lower : 작은거 중에 가장 큰거
 * higher : 큰거중에 가장 작은거
 */
public class P1059 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int L,n;
    static int[] S;

    public static void main(String[] args){
//        solve1();
        solve2();
    }

    static void solve2(){

    }
    static void solve1(){
        L=sc.nextInt();
        S=new int[L+2];
        for(int i=1; i<=L; ++i){
            S[i]=sc.nextInt();
        }
        S[0]=0;
        S[L+1]=1001;
        n=sc.nextInt();

        int mn=-1;
        int mx=10002;
        for(int i=0; i<=L+1; ++i){
            if(S[i]<n){
                mn=Math.max(mn,S[i]);
            }
            else if(S[i]>n){
                mx=Math.min(mx,S[i]);
            }
            else{
                System.out.print(0);
                System.exit(0);
            }
        }

        int ans=-1;
        if(n-mn!=1 && mx-n!=1){
            ans=(mx-n)*(n-mn)-1;
        }
        else if(n-mn==1){
            ans=mx-n-1;
        }
        else{
            ans=n-mn-1;
        }
        System.out.print(ans);
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null||!st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
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
