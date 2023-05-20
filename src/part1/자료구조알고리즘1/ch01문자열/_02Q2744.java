package part1.자료구조알고리즘1.ch01문자열;

import java.io.*;
import java.util.StringTokenizer;

public class _02Q2744 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static String input;
    public static void main(String[] args) throws IOException {
        input();

//        solve1();
        solve2();

        sc.write(sb.toString());

    }

    private static void solve1() {
        char result;
        for(int i = 0; i< input.length(); ++i){

            char c = input.charAt(i);
            if('a'<= c && c <='z' ) {//소문자일때
                result = Character.toUpperCase(c);
            }
            else{
                result = Character.toLowerCase(c);
            }
            sb.append(result);
        }
    }

    private static void solve2(){
        char result;
        for(int i=0; i< input.length(); ++i){
            char c = input.charAt(i);

            if ('a' <= c && c <= 'z') {
                c -= 'a' - 'A';
            }
            else{
                c += 'a' - 'A';
            }
            sb.append(c);
        }
    }


    public static void input(){
        input = sc.next();
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
