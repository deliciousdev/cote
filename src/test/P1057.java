package test;

import java.util.*;
import java.io.*;

/**
 * 수학적으로 빠르게 계산할 수 있는것 같았지만 시간 복잡도가 충분하니까 그냥 시뮬레이션 돌렸음.
 * +(X%2)  : 홀수 일때 1더하고 짝수일때 안 더함
 */
public class P1057 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, p1, p2;
    static int[] round;

    public static void main(String[] args) {
        N = sc.nextInt();
        p1 = sc.nextInt();
        p2 = sc.nextInt();
        round = new int[N + 1];
//        solve1();//시뮬레이션
        solve2();//시뮬레이션 X
    }

    static void solve2(){//나도계속 이기고 상대방도 계속 이기면 토너먼트에서는 안만날수가 없긴함.
        int round=0;
        while(p1!=p2){
            ++round;
            p1= p1/2+(p1%2);
            p2= p2/2+(p2%2);

        }
        System.out.print(round);
    }
    static void solve1() {

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; ++i) {
            q.add(i);
        }
        ArrayList<Integer> temp = new ArrayList<>();


        int round = 0;

        while (!q.isEmpty()) {
            ++round;
            int cnt = 0;
            while (!q.isEmpty()) {
                ++cnt;
                if (q.size() > 1) {
                    int a = q.poll();
                    int b = q.poll();
                    if (a == p1 && b == p2 || a == p2 && b == p1) {
                        System.out.print(round);
                        System.exit(0);
                    } else if (a == p1) {
                        p1 = cnt;
                    } else if (a == p2) {
                        p2 = cnt;
                    } else if (b == p1) {
                        p1 = cnt;
                    } else if (b == p2) {
                        p2 = cnt;
                    }

                } else {
                    int c = q.poll();
                    if (c == p1) {
                        p1 = cnt;
                    } else if (c == p2) {
                        p2 = cnt;
                    }
                }
            }
            for (int i = 1; i <= cnt; ++i) {
                q.add(i);
            }
        }

        System.out.print(-1);

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
