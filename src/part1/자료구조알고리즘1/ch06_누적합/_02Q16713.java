package part1.자료구조알고리즘1.ch06_누적합;

import java.util.*;
import java.io.*;

public class _02Q16713 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N,Q;
    static int acc[];

    public static void main(String[] args){

        N= sc.nextInt();
        Q= sc.nextInt();
        acc = new int[N+1];

        int ac=0;
        for(int i=1; i<=N; ++i){
            acc[i] = ac^=sc.nextInt();
        }

        int q = Q;
        ac=0;
        while (q-- > 0) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            ac ^= acc[e] ^ acc[s-1];
        }

        System.out.print(ac);
    }
    static class FastReader{
        BufferedReader br ;
        StringTokenizer st;
        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null|| !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
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
