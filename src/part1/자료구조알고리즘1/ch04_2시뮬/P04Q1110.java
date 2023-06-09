package part1.자료구조알고리즘1.ch04_2시뮬;

import java.io.*;
import java.util.StringTokenizer;

public class P04Q1110 {


    static FastReader sc = new FastReader();

    static int N;

//    public static void main(String[] args) {
//
//        init();
//
//        int cnt=0;
//
//        int result=N;
//        do {
//            ++cnt;
//            result= getLastDigit(result)*10+ getLastDigit(sumDigit(result));
//        }while(result!=N);
//
//        System.out.println(cnt);
//    }

    public static void main(String[] args) {

        init();

        int cnt = 0;

        int result = N;
        do {
            ++cnt;
            result = (result % 10) * 10 + (result / 10 + result % 10) % 10;
        } while (result != N);

        System.out.println(cnt);
    }

    public static void init() {
        N = sc.nextInt();
    }

    static int getLastDigit(int x) {
        return x % 10;
    }

    static int sumDigit(int x) {
        int result = 0;
        while (x > 0) {
            result += x % 10;
            x /= 10;
        }
        return result;
    }

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        public String next() {

            while (st == null || !st.hasMoreElements()) { // || 연산의 오른쪽을 점검할때는 st가 null 이 아닌것이 보장됨.
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public String nextLine() {
            String str = "";

            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }
}
