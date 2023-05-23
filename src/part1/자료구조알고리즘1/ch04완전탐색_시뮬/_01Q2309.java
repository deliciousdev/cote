package part1.자료구조알고리즘1.ch04완전탐색_시뮬;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _01Q2309 {

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();

    static int N =9;
    static Integer[] arr;
    static int[] result;
    static boolean find;
    static int input_sum=0;

    public static void main(String[] args) {
        init();
//        Arrays.sort(arr);
//        recurs(0,0,-1);

//        Arrays.sort(arr, Collections.reverseOrder());
        Arrays.sort(arr);
        complementary();

        System.out.println(sb.toString());

    }

    static void recurs(int sum, int depth, int select) {
        if(find) return ;

        //탐색끝
        if (depth >= 7) {
            if(sum!=100){
                return ;
            }
            find= true;
            for(int i=0; i<7; ++i){
                sb.append(result[i]).append("\n");
            }

            return;
        }

        //탐색
        for(int i=select+1; i<arr.length; ++i){

            if(sum+arr[i]<=100){
                result[depth]=arr[i];
                recurs(sum+arr[i],depth+1,i);
            }
        }

    }

    static void complementary(){
        int i=0;
        int j=0;
        Loop1:
        for(; i<N; ++i){
            for(j=i+1; j<N; ++j){

                if (input_sum - (arr[i] + arr[j]) == 100) {

                    break Loop1;
                }
            }
        }
        for(int k=0; k<N; ++k){
            if( k ==i || k== j ) continue;

            sb.append(arr[k]).append("\n");
        }
    }

    static void init(){
        arr = new Integer[N];
        for(int i=0; i<N; ++i){
            arr[i] = sc.nextInt();
            input_sum+=arr[i];
        }
        result = new int[7];

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
