package part5.단기완성알고리즘._04투포인터;

import java.io.*;
import java.util.*;

/**
 * 그냥 전부 탐색으로 해결 할려고 하면 시간 복잡도가 N^3 이라서 시간초과 -> 시간을 줄여서 탐색 해야함 : 투포인터
 */
public class _04Q1253 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;

    public static void main(String[] args) {
        solve1();
    }

    static void solve1() {
        N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); //최대값, 최소값을 찾고, 투포인터 논리의 진행을 위해 정렬을 해줘야함

        int cnt = 0;
        for (int i = 0; i < N; ++i) {
            int target = arr[i];
            int p1 = 0;
            int p2 = arr.length - 1;

            if (p1 == i) ++p1;
            if (p2 == i) --p2;
            while (p1 < p2) {

                int sum = arr[p1] + arr[p2];
                if (sum == target) {
                    ++cnt;
                    break;
                } else if (sum < target) {
                    ++p1;
                    if (p1 == i) ++p1;
                } else {
                    --p2;
                    if (p2 == i) --p2;
                }
            }
        }
        System.out.print(cnt);
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
