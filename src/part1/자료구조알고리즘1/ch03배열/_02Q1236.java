package part1.자료구조알고리즘1.ch03배열;

import java.io.*;
import java.util.StringTokenizer;

public class _02Q1236 {

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int n,m,ans;

    static boolean[] exist_row;
    static boolean[] exist_col;


    public static void main(String[] args) {
        init();

//        solve();
        solve2();

        System.out.println(ans);
    }

    public static void init(){
        n = sc.nextInt();
        m = sc.nextInt();

        exist_row = new boolean[n];
        exist_col = new boolean[m];
    }

    public static void solve(){

        for(int i=0; i<n; ++i){
            String temp = sc.next();
            for (int j=0; j<m; ++j){
                char c = temp.charAt(j);
                if (exist_row[i] && exist_col[j]) continue;;

                if (c == 'X') {
                    exist_row[i]=true;
                    exist_col[j]=true;
                }

            }
        }

        int row_cnt =n;
        for(int i=0; i<exist_row.length; ++i){
            if(exist_row[i]==true){
                --row_cnt;
            }
        }
        int col_cnt =m;
        for(int j=0; j<exist_col.length; ++j){
            if(exist_col[j]==true){
                --col_cnt;
            }
        }
        ans = Math.max(row_cnt, col_cnt);
    }


    public static void solve2(){

        for(int i=0; i<n; ++i){
            char[] temp = sc.next().toCharArray();
            for (int j=0; j<m; ++j){
                char c = temp[j];
                if (exist_row[i] && exist_col[j]) continue;;

                if (c == 'X') {
                    exist_row[i]=true;
                    exist_col[j]=true;
                }

            }
        }

        int row_cnt =n;
        for(int i=0; i<exist_row.length; ++i){
            if(exist_row[i]==true){
                --row_cnt;
            }
        }
        int col_cnt =m;
        for(int j=0; j<exist_col.length; ++j){
            if(exist_col[j]==true){
                --col_cnt;
            }
        }
        ans = Math.max(row_cnt, col_cnt);
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
