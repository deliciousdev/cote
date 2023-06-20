package part1.자료구조알고리즘1.ch06_누적합;

import java.io.*;
import java.util.*;

/**
 * 반복 작업에 대해서 반복적으로 하는것이 아니라. 반복적으로 하는거라고 기록만 해둠. 그리고 그 기록들을 누적함.
 * 반복 작업마다 결과를 구하는것이 아니라 , 마지막 누적된 결과만 구하는것이라면 이런 누적하는 방법을 이용할 수 있음
 */
public class _04Q19951 {


    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N,M;
    static int[] arr;
    static int[] d;
    static int[] accD;

    public static void main(String[] args){
        N= sc.nextInt();
        M= sc.nextInt();
        arr= new int[N+1];

        solve1();

        System.out.print(sb.toString());
    }

    static void solve1(){
        for(int i=1; i<=N; ++i){
            arr[i] = sc.nextInt();
        }

        d= new int[N+2]; //b+1 인덱스 벗어나는거 피할려고 N+1이 아니라 N+2로 해줌
        int m= M;
        while(m-->0){
            int a= sc.nextInt();
            int b= sc.nextInt();
            int k= sc.nextInt();

            d[a]+=k;
            d[b+1]-=k;
        }

        accD= new int[N+1];
        for(int i=1; i<=N; ++i){
            accD[i]=d[i]+accD[i-1];
            arr[i]+=accD[i];
            sb.append(arr[i]).append(" ");
        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}