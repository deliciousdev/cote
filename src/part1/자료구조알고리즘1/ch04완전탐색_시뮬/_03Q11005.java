package part1.자료구조알고리즘1.ch04완전탐색_시뮬;

import java.io.*;
import java.util.StringTokenizer;

public class _03Q11005 {

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();

    static char[] num = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    static int N, B;

    public static void main(String[] args) {
        N = sc.nextInt();
        B = sc.nextInt();

        int length = 0;
        while (N > 0) {
            ++length;
            sb.append(num[N % B]);
            N/=B;
        }
        String temp = sb.toString();
        sb.setLength(0);
        for(int i = length-1; i>=0; --i){
            sb.append(temp.charAt(i));
        }
        System.out.println(sb.toString());
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
