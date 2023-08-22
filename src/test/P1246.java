package test;

import java.util.*;
import java.io.*;

public class P1246 {

    static FastReader sc= new FastReader();
    static int n,m;
    static int[] p;

    public static void main(String[] args){
//        solve1();
        solve2();
    }

    static void solve2(){
        input();
        Arrays.sort(p);
        int maxProfit=Integer.MIN_VALUE;
        int price= -1;
        for(int i=0; i<p.length; ++i){
            int amount=Math.min(m-i,n);

            int profit=amount*p[i];
            if(maxProfit<profit){
                maxProfit=profit;
                price=p[i];
            }
        }
        System.out.print(price+" "+maxProfit);
    }

    static void solve1(){
        input();
        Arrays.sort(p);
        int profit=Integer.MIN_VALUE;
        int price=-1;
        for(int i=0; i<p.length; ++i){
            int tempProfit=-1;
            if(m-i<=n){
                tempProfit=p[i]*(m-i);
            }
            else{
                tempProfit=p[i]*n;
            }
            if(tempProfit>profit){
                price=p[i];
                profit=tempProfit;
            }
        }
        System.out.print(price+" "+profit);
    }

    private static void input() {
        n=sc.nextInt();
        m= sc.nextInt();
        p = new int[m];
        for(int i=0; i<p.length; ++i){
            p[i]=sc.nextInt();
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
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
