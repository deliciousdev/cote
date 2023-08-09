package test;

import java.util.*;
import java.io.*;

/**
 * 제곱수 판별, 문제에서 요구 하는 부르트포스
 * 숫자를 만들때 필요한 데이터들이 뭐가 있을지 판단한후 그것을 부르트포스로 선택함
 * 미리 제곱수들을 배열에 만들어놓고, 배열에 존재하면 제곱수 이런식으로 안해도됨.(시간복잡도가 O(N)이라서 비효율)
 */
public class P1025 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;

    static int[][] arr;

    public static void main(String[] args) {
        solve1();
    }

    static void solve1() {
        N = sc.nextInt();
        M = sc.nextInt();
        arr= new int[N][M];
        for(int i=0; i<N; ++i){
            String s= sc.next();
            for(int j=0; j<M; ++j){
                arr[i][j]=s.charAt(j)-'0';
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int num=1; num<=Math.max(N,M); ++num){
//        for(int num=1; num<=Math.min(N,M); ++num) {//N M 중 하나가 1이면 곤란해짐
            for (int rStart = 0; rStart <= N - 1; ++rStart) {
                for (int dr = 1 - N; dr <= N - 1; ++dr) {
                    int lastIdx=rStart+dr*(num-1);
                    if(lastIdx<0||lastIdx>N-1) continue;

                    for (int cStart = 0; cStart <= M - 1; ++cStart) {
                        for (int dc = 1 - M; dc <= M - 1; ++dc) {
                            lastIdx=cStart+dc*(num-1);
                            if(lastIdx<0||lastIdx>M-1) continue;
                            if(dr==0 && dc==0 && num>1) continue;
                            //근데 사실 이렇게 같은 곳을 여러번 선택해도 그 수는 제곱수가 아니므로 답에는 영향 없긴함

                            int number = generateNumber(rStart, dr, cStart, dc, num);
                            if (!isSquareNumber(number)) continue;

                            ans = Math.max(ans, number);
                        }
                    }
                }
            }
        }
        int initValue=Integer.MIN_VALUE;
        System.out.print(ans!=initValue?ans:-1);
    }

    static boolean isSquareNumber(int x) {
        int root = (int) Math.sqrt(x);
        return root * root == x;
    }

    static int generateNumber(int rStart, int dr, int cStart, int dc, int num) {
        int number=0;
        for(int i=1; i<=num; ++i){
            int r= rStart+dr*(i-1);
            int c= cStart+dc*(i-1);
            number= number*10+arr[r][c];
        }
        return number;
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
