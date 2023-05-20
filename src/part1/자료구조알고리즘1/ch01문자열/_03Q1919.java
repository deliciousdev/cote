package part1.자료구조알고리즘1.ch01문자열;


import java.io.*;
import java.util.StringTokenizer;

public class _03Q1919 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[] cnt = new int[(int)'z'+1];
    static String input1;
    static String input2;

    static int result=0;

    public static void main(String[] args) throws IOException {
        input();
        solve1();

        sc.write(String.valueOf(result));
    }

    public static void input(){
        input1 = sc.next();
        input2 = sc.next();
    }

    public static void solve1(){
        int i=0;
        for(i=0; i<input1.length() && i<input2.length(); ++i){
            ++cnt[input1.charAt(i)];
            --cnt[input2.charAt(i)];
        }

        for(;i<input1.length(); ++i){
            ++cnt[input1.charAt(i)];
        }

        for (; i < input2.length(); ++i) {
            --cnt[input2.charAt(i)];
        }

        for(int j='A'; j<='z'; ++j){
            if( cnt[j]==0) continue;

            result += Math.abs(cnt[j]);
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

        void write(String source) throws IOException {
            bw.write(source);
            bw.flush();
        }
    }
}
