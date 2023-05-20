package part1.자료구조알고리즘1.ch01문자열;

import java.io.*;
import java.util.StringTokenizer;

public class _04Q1157 {

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();


    static String input;
    static int[] cnt = new int['Z' + 1];
    static int maxCnt = 0;
    static char ans = '?';


    public static void main(String[] args) {
//        input();
//        solve1();

        input2();
        solve2();
        System.out.println(ans);
    }


    public static void input() {
        input = sc.next();
    }

    public static void input2() {
        input = sc.next().toUpperCase(); //입력 받을때 전환
    }

    public static void solve1() {

        for (int i = 0; i < input.length(); ++i) {
            char c = convert(input.charAt(i));
            ++cnt[c];
            if (cnt[c] > maxCnt) {
                maxCnt = cnt[c];
                ans = c;
            } else if (cnt[c] == maxCnt) {
                ans = '?';
            }
        }
    }

    public static void solve2() {

        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);
            ++cnt[c];
            if (cnt[c] > maxCnt) {
                maxCnt = cnt[c];
                ans = c;
            } else if (cnt[c] == maxCnt) {
                ans = '?';
            }
        }
    }


    public static char convert(char source) {
        if ('a' <= source && source <= 'z') {
            source -= 'a' - 'A';
        }
        return source;
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
