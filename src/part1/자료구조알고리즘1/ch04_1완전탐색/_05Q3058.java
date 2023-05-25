package part1.자료구조알고리즘1.ch04_1완전탐색;

import java.io.*;
import java.util.StringTokenizer;

public class _05Q3058 {

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static char[][] arr;
    static int ans;
    static int N;
    static int max;

    public static void main(String[] args) {

        init();


        //i,j 에 대해서 4방향으로 탐색하면 중복이 되기 때문에 위에꺼 밑에꺼만 교환하는걸로.... : 격자 형태일대는 이점을 참고 하자
        Loop1:
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N - 1; ++j) {
                if (i + 1 < N && arr[i][j]!= arr[i+1][j]) {
                    //i,j & i+1,j
                    swap(i,j,i+1,j);
                    countMaxCandy(arr);
                    swap(i,j,i+1,j);
                }

                if (j + 1 < N && arr[i][j] != arr[i][j+1]) {
                    //i,j & i,j+1
                    swap(i,j,i,j+1);
                    countMaxCandy(arr);
                    swap(i,j,i,j+1);
                }

                if (max==N) break Loop1;
            }
        }

        System.out.println(max);
    }

    public static void countMaxCandy(char[][] arr) {

        for(int i=0; i<arr.length; ++i){
            int maxLength=1; //이거 초기값 0 으로 하면안됨.. 예제 돌려 봤을때 전부 1씩 차이나면 눈치 챘어야함
            for(int j=0; j<arr[i].length-1; ++j){
                if(arr[i][j]==arr[i][j+1]){
                    ++maxLength;
                    max = Math.max(maxLength, max);
                }
                else{
                    maxLength=1;
                }
            }
        }

        if(max ==N) return ;

        for(int j=0; j<N; ++j){
            int maxLength=1;
            for (int i = 0; i < N - 1; ++i) {
                if(arr[i][j]==arr[i+1][j]){
                    ++maxLength;
                    max = Math.max(maxLength, max);
                }
                else{
                    maxLength=1;
                }
            }
        }
    }

    public static void swap(int i1, int j1, int i2, int j2) {
        char temp = arr[i1][j1];
        arr[i1][j1] = arr[i2][j2];
        arr[i2][j2] = temp;
    }

    public static void init(){
        N = sc.nextInt();
        arr = new char[N][N];

        for(int i=0; i<N; ++i){
            arr[i] = sc.next().toCharArray();
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
