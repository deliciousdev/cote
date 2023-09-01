package test;

import java.util.*;
import java.io.*;

public class P1326 {

    static FastReader sc = new FastReader();
    static int n, a, b;
    static int[] sumCost;
    static int[] numberOnStone;

    public static void main(String[] args) {
        solve1();
    }

    static void solve1() {
        n = sc.nextInt();

        sumCost = new int[n + 1];
        numberOnStone = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            numberOnStone[i] = sc.nextInt();
        }
        a = sc.nextInt();
        b = sc.nextInt();
        if (a == b) {
            System.out.print(0);
            System.exit(0);
        }

        Arrays.fill(sumCost, -1);
        sumCost[a] = 0;

        bfs(a);

        System.out.print(sumCost[b]);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        int[] positiveOrNegative = {1, -1};

        q.add(start);
        while (!q.isEmpty()) {
            int idx = q.poll();
            int number = numberOnStone[idx];

            for (int i = 0; i < positiveOrNegative.length; ++i) {
                int direction = positiveOrNegative[i];
                for (int d = number; idx + direction * d <= n && idx + direction * d >= 1; d += number) {
                    int nextIdx = idx + direction * d;
                    if (sumCost[nextIdx] != -1) continue;

                    sumCost[nextIdx] = sumCost[idx] + 1;
                    q.add(nextIdx);
                    if (nextIdx == b) return;
                }
            }
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
