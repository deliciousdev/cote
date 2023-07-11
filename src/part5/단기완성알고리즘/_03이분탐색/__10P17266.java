package part5.단기완성알고리즘._03이분탐색;

import java.util.*;
import java.io.*;

public class __10P17266 {

    static FastReader sc = new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N,M;

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        N= sc.nextInt();
        M= sc.nextInt();

        int[] arr= new int[N+1];

        int ans= arr[0] =sc.nextInt();
        for(int i=1; i<M; ++i){
            arr[i]=sc.nextInt();
            ans=Math.max(ans,(arr[i]-arr[i-1]+1)/2);
        }
        ans= Math.max(ans,N-arr[M-1]);
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
