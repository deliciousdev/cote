package part5.단기완성알고리즘._04투포인터;


import java.util.*;
import java.io.*;

/**
 * 문제속 키워드 : "연속한 1개 이상의 수를 뽑았을때" -> 투포인터 가능 할 지도?
 * <p>
 * ans 를 int로 하면 오버플로우 발생 : 처음에 최대상한값을 파악 해야함.
 */
public class _03Q13144 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;

    public static void main(String[] args) {
//        solve1();
        solve2();//solve1() 과 같은 코드
    }

    static void solve2() {
        N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = sc.nextInt();
        }

        boolean[] exist = new boolean[100001];

        int p1 = 0;
        int p2 = 0;
        int l = 1;
        exist[arr[0]] = true;

        long ans = 0;
        for (p1 = 0; p1 < arr.length; ++p1) {

            while (p2 + 1 < arr.length && !exist[arr[p2 + 1]]) {
                ++p2;
                exist[arr[p2]] = true;
                ++l;
            }
            ans += l;
            exist[arr[p1]] = false;
            --l;
        }

        System.out.print(ans);
    }

    static void solve1() {
        N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = sc.nextInt();
        }

//        boolean[] exist =new boolean[N+1];
        boolean[] exist = new boolean[100001];

        int p1 = 0;
        int p2 = 0;
        int l = 1;
        exist[arr[0]] = true;

        long ans = 0;
        for (p1 = 0; p1 < arr.length; ++p1) {

            while (p2 + 1 < arr.length) {
                int num = arr[p2 + 1];

                if (exist[num]) {
                    break;

                } else {
                    exist[num] = true;
                    ++p2;
                    ++l;
                }
            }
            ans += l;
            exist[arr[p1]] = false;
            --l;
        }

        System.out.print(ans);
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
