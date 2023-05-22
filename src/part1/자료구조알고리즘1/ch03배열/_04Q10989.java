package part1.자료구조알고리즘1.ch03배열;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _04Q10989 {

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();

    static int N ;
    static int[] arr;

    public static void main(String[] args) {
        N = sc.nextInt();


//        solve1();

        solve2();

        System.out.println(sb.toString());
    }

    private static void solve1() {
        arr = new int[N];
        for(int i=0; i<N; ++i){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for(int i=0; i<arr.length; ++i){
            sb.append(arr[i]).append("\n");
        }
    }

    private static void solve2(){
        int[] cnt = new int[10001];
        for(int i=0; i<N; ++i){
            ++cnt[sc.nextInt()];
        }
        for(int i=1; i<=10000; ++i){
//            for(int j=1; j<=cnt[i]; ++j){
//                sb.append(i).append("\n");
//            }
            while(cnt[i]-->0){//이거만큼 반복해라
                sb.append(i).append("\n");
            }
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
