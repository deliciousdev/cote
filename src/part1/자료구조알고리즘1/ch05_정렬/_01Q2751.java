package part1.자료구조알고리즘1.ch05_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * N^2 정렬 알고리즘으로는 시간초과뜸.
 * NlogN 정렬로 풀어야함
 */
public class _01Q2751 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] arr;

    public static void main(String[] args) {
        init();

        Arrays.sort(arr);

        print();
    }

    private static void print() {

        for(int i=0; i<arr.length; ++i){
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void init(){
        N = sc.nextInt();
        arr= new int[N];

        for(int i=0; i<arr.length; ++i){
            arr[i] = sc.nextInt();
        }
    }
    static class FastReader{

        BufferedReader bw ;
        StringTokenizer st;

        public FastReader(){
            bw = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st == null || !st.hasMoreElements()) {
                try{
                    st= new StringTokenizer(bw.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        String nextLine(){
            String str="";

            try{
                str = bw.readLine();
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
