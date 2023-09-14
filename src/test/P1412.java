package test;

import java.util.*;
import java.io.*;

/**
 * 부르트포스
 * 문제 풀기전에 꼭... 변수 범위들 파악
 */
public class P1412 {

    static FastReader sc = new FastReader();
    static int n, c, w;

    public static void main(String[] args) {
        solve1();
    }

    static void solve1() {
        n = sc.nextInt();
        c = sc.nextInt();
        w = sc.nextInt();

        int[] tree = new int[n];
        int mxTree = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            tree[i] = sc.nextInt();
            mxTree = Math.max(mxTree, tree[i]);
        }

        long mxProfit = 0;
        for (int length = 1; length <= mxTree; ++length) {
            long profit = calcProfit(tree, length);
            mxProfit = Math.max(mxProfit, profit);
        }

        System.out.print(mxProfit);
    }

    static long calcProfit(int[] tree, int length) {

        int ableSellCnt = 0;
        int cutCnt = 0;
        long profit = 0;
        for (int i = 0; i < tree.length; ++i) {
            if (length > tree[i]) continue;

            cutCnt= tree[i]%length==0? tree[i]/length-1 : tree[i]/length;
            ableSellCnt = tree[i] / length;

            long tempCutCost = (long) c * cutCnt;
            long tempEarn = (long) ableSellCnt * w * length;
            if (tempCutCost < tempEarn) {
                profit += (tempEarn - tempCutCost);
            }
        }

        return profit;
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
