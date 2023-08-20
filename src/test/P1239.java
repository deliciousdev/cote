package test;

import java.util.*;
import java.io.*;

/**
 * 모든 경우의 부분합을 탐색할때 투포인터 사용하면됨.
 */
public class P1239 {

    static FastReader sc = new FastReader();
    static int n;
    static int ans = Integer.MIN_VALUE;
    static boolean[] used;
    static int[] p;
    static int[] score;

    public static void main(String[] args) {
        solve1();
    }

    static void solve1() {
        n = sc.nextInt();
        score = new int[n];
        for (int i = 0; i < score.length; ++i) {
            score[i] = sc.nextInt();
        }

        used = new boolean[n];
        p = new int[n];

//        permutation(0);//그냥 부르트포스
        permutation2(0);//투포인터
        System.out.print(ans);
    }

    static void permutation2(int k) { //투포인터
        if (k == n) {

            int cnt = 0;
            int rightIdx = 0;
            int sum = score[p[0]];
            for (int leftIdx = 0; leftIdx < p.length; ++leftIdx) {

                while(sum<50 && rightIdx+1<p.length){
                    sum+=score[p[++rightIdx]];
                }
                if(sum==50){
                    ++cnt;
                }
                else{
                    sum-=score[p[leftIdx]];
                }
            }

            ans = Math.max(ans, cnt);
            return;
        }

        for (int i = 0; i < n; ++i) {
            if (used[i]) continue;

            used[i] = true;
            p[k] = i;
            permutation(k + 1);
            used[i] = false;
        }
    }

    static void permutation(int k) { //부분합을 탐색할때 전부 탐색함.
        if (k == n) {
            int[] subSum = new int[n];

            int cnt = 0;
            subSum[0] = score[p[0]];
            for (int i = 1; i < subSum.length; ++i) {
                subSum[i] = subSum[i - 1] + score[p[i]];
            }

            for (int i = 0; i < subSum.length - 1; ++i) {
                for (int j = i + 1; j < subSum.length; ++j) {
                    int temp = subSum[j] - subSum[i];
                    if (temp == 50) ++cnt;
                }
            }

            ans = Math.max(ans, cnt);
            return;
        }

        for (int i = 0; i < n; ++i) {
            if (used[i]) continue;

            used[i] = true;
            p[k] = i;
            permutation(k + 1);
            used[i] = false;
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

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
