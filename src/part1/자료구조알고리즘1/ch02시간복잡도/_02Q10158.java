package part1.자료구조알고리즘1.ch02시간복잡도;

import java.io.*;
import java.util.StringTokenizer;

public class _02Q10158 {

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int w, h;
    static int p, q;
    static int t;

    static int[][][] arr;

    public static void main(String[] args) {

    }

    public static void init() {
        w = sc.nextInt();
        h = sc.nextInt();
        p = sc.nextInt();
        q = sc.nextInt();
        t = sc.nextInt();
        arr = new int[h+1][w+1][5];
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

        void write(String source) throws IOException {
            bw.write(source);
            bw.flush();
        }
    }
}

