package test;

import java.util.*;
import java.io.*;

/**
 * dfs문제
 */
public class P1189 {

    static FastReader sc = new FastReader();

    static int r, c, k;
    static int cnt;


    static int[][] d = {
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };

    static boolean[][] visited;
    static char[][] map;

    public static void main(String[] args) {
        solve1();
    }

    static void solve1() {
        input1();
        visited[r - 1][0] = true;
        dfs1(1, r - 1, 0);
        System.out.print(cnt);
    }

    static void dfs1(int distance, int row, int col) {
        if (distance == k && row == 0 && col == c - 1) {
            ++cnt;
            return;
        }

        if(distance==k) return;

        for (int i = 0; i < d.length; ++i) {
            int nextR = row + d[i][0];
            int nextC = col + d[i][1];
            if (nextR < 0 || nextR > r - 1 || nextC < 0 || nextC > c - 1) continue;
            if(visited[nextR][nextC]) continue; //이거때문에 디버깅 오래 걸림...
            if (map[nextR][nextC] == 'T') continue;

            visited[nextR][nextC] = true;
            dfs1(distance + 1, nextR, nextC);
            visited[nextR][nextC] = false;
        }
    }

    private static void input1() {
        r = sc.nextInt();
        c = sc.nextInt();
        k = sc.nextInt();

        map = new char[r][c];
        for (int i = 0; i < r; ++i) {
            map[i] = sc.next().toCharArray();
        }
        visited = new boolean[r][c];
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
