package part1.자료구조알고리즘1.ch07_이분탐색;

import java.util.*;
import java.io.*;


/**
 * ,이건 다시 해야함 오버플로우땜에 잘 안되는듯
 */
public class _06Q2417 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static long N;
    public static void main(String[] args){
            N= sc.nextLong();

            long left= 0L;
            long right= N;

            while(left<=right){
                long mid=(left+right)/2;
                double temp =mid*mid;
                if(temp>=N){
                    right=mid-1;
                }
                else {
                    left=mid+1;
                }
            }
            System.out.print(left);

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

        long nextLong(){
            return Long.parseLong(next());
        }
    }
}
