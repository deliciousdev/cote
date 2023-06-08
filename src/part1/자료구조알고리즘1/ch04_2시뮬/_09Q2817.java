package part1.자료구조알고리즘1.ch04_2시뮬;

import java.io.*;
import java.util.StringTokenizer;


/**
 * 최대값 구하는 탐색 부분을 정렬로 바꾸기
 */
public class _09Q2817 {

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();

    static int X ;
    static int N ;
    static double[][] score;
    static int[] total;

    static final int VALID =-2;
    public static void main(String[] args) {
        init();

        int temp=14;
        while(temp-->0){

            int maxStaffIndex=-1;
            int maxIndex=-1;
            double mx=0;
            for(int i=0; i<='Z'-'A'; ++i){
                if(score[i][0]!= VALID) continue;

                for(int j=1; j<=14; ++j){
                    if(score[i][j]>mx){
                        mx= score[i][j];
                        maxStaffIndex=i;
                        maxIndex=j;
                    }
                }
            }
            ++total[maxStaffIndex];
            score[maxStaffIndex][maxIndex]=-1;
        }

        print();
    }

    public static void init(){
        X = sc.nextInt();
        N= sc.nextInt();
        score= new double['Z'-'A'+1][15];
        total= new int['Z'-'A'+1];


        int n= N;
        while(n-->0){
            char staffName = sc.next().charAt(0);
            int voteCnt = sc.nextInt();
            if (voteCnt < X * 0.05) continue;

            score[staffName-'A'][0]= VALID;
            for(int i=1; i<=14; ++i){
                score[staffName-'A'][i]=(double)voteCnt/i;
            }
        }
    }

    static void print(){
        for(int i=0; i<='Z'-'A'; ++i){
            if(score[i][0]!= VALID) continue;

            sb.append((char)(i + 'A')).append(" ").append(total[i]).append("\n");
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
