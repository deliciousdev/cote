package test;

import java.util.*;
import java.io.*;

/**
 * LinkedList 삽입
 */
public class P1138 {

    static FastReader sc= new FastReader();
    static int n;
    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        n= sc.nextInt();
        int[] input=new int[n+1];
        for(int i=1; i<=n; ++i){
            input[i]=sc.nextInt();
        }
        LinkedList<Integer> arr= new LinkedList<>();
        for(int i=n; i>=1; --i){
            int idx=input[i];
            arr.add(idx,i);
        }

        print(arr);
    }

    static void print(List<Integer> arr){
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<arr.size(); ++i){
            sb.append(arr.get(i)).append(" ");
        }
        System.out.print(sb.toString());
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while (st == null || !st.hasMoreElements()) {
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
