package part1.자료구조알고리즘1.ch03배열;

import java.io.*;
import java.util.StringTokenizer;

public class _05Q3273 {


    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int n, x;
    static int[] arr;
    static boolean[] check;
    static int ans;

    public static void main(String[] args) {

//        solve();
//        solve2();
//        solve3();
        solve4();

        System.out.println(ans);
    }

    public static void solve() {
        n = sc.nextInt();
        check = new boolean[1000001];

        for (int i = 0; i < n; ++i) {
            check[sc.nextInt()] = true;
        }
        x = sc.nextInt();

        for (int i = 1; i <= x / 2; ++i) {
            if (!check[i]) continue;

            if (1 <= x - i && x - i <= 1000000 && x - i != i && check[x - i]) {

                ++ans;
            }
        }
    }

    public static void solve2() {
        n = sc.nextInt();
        check = new boolean[1000001];

        for (int i = 0; i < n; ++i) {
            check[sc.nextInt()] = true;
        }
        x = sc.nextInt();

        for (int i = 1; i < x / 2; ++i) { //잘 생각해보면 x가 홀수 일때도 오류가 있고, x가 짝수일때는  x-i!=i 를 보장못함
            if (!check[i]) continue;

            if (1 <= x - i && x - i <= 1000000 /*&& x - i != i*/ && check[x - i]) {

                ++ans;
            }
        }
    }

    public static void solve3() {
        n = sc.nextInt();
        check = new boolean[1000001];

        for (int i = 0; i < n; ++i) {
            check[sc.nextInt()] = true;
        }
        x = sc.nextInt();

        for (int i = 1; i <= x / 2; ++i) {
            if (x - i < 1 || x - i > 1000000 || x - i == i) continue;

            if (check[i] && check[x - i]) { //이런식으로 하는게 solve1() 보다 좀 더 깔끔
                ++ans;
            }
        }
    }

    public static void solve4() {
        n = sc.nextInt();
        check = new boolean[1000001];

        for (int i = 0; i < n; ++i) {
            check[sc.nextInt()] = true;
        }
        x = sc.nextInt();

        for (int i = 1; i <= (x - 1) / 2; ++i) { //solve2 에서 시도할려했던거 이런식으로 하면됨
            if (x - i < 1 || x - i > 1000000) continue;

            ans += (check[i] && check[x - i]) ? 1 : 0;
        }
    }

    static class FastReader {
        BufferedReader br;

        BufferedWriter bw;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
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

        void write(String source) throws IOException { //BufferedWriter 보다 StringBuilder 가 더 빠르다고 하는것 같음
            bw.write(source);
//            bw.flush();
        }
        //flush 는 write 를 여러번 하고 나중에 한번만 해주면됨
        //write 은 기본적으로 String or int 를 받기 때문에 개행문자는 스트링으로해줘야함
    }
}

