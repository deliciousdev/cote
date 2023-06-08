package part1.자료구조알고리즘1.ch04_2시뮬;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 인덱스 +로 올라가면 %연산하면되고
 * 인덱스가 -로 내려가면 양수끝으로 땡겨줘야함
 *
 * 자바 모듈러는 음수를 리턴 할 수 있음. 인덱스 모듈러 연산 했을때 음수의 가능성이 있다면 ....
 *
 * 배열 초기화 할때 Arrays.fill
 */
public class _08Q2840 {

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();

    static int N, K;
    static char[] circleBoard;
    static int index;
    static boolean check[];

    public static void main(String[] args) {

        init();

        boolean collision = false;
        boolean twice = false;
        while (K-- > 0) {
            int cnt = sc.nextInt();
            char stopAt = sc.next().charAt(0);

            index = (index + cnt) % N;

            if (existInOtherDivision(stopAt)) {//이미 나온 알파벳인데 다른칸에 또 나올때
                twice =true;
                break;
            }

            if (collisionInSingleDivision(stopAt)) {//같은 칸에 2개의 문자가 충돌
                collision = true;
                break;
            }

            circleBoard[index] = stopAt;
            check[stopAt-'A']=true;
        }

        if (collision || twice) {
            System.out.print('!');
            System.exit(0);
        }

//        print();
        print2();
    }

    private static boolean collisionInSingleDivision(char stopAt) {
        return circleBoard[index] != '?' && circleBoard[index] != stopAt;
    }

    private static boolean existInOtherDivision(char stopAt) {
        return check[stopAt-'A'] && circleBoard[index]!=stopAt;
    }

    static void init() {
        N = sc.nextInt();
        K = sc.nextInt();
        circleBoard = new char[N];
//        for (int i = 0; i < N; ++i) {
//            circleBoard[i] = '?';
//        }
        Arrays.fill(circleBoard,'?'); //배열 초기화 할때
        check = new boolean['Z'-'A'+1];
    }

    static void print() {

        int cnt = circleBoard.length;
        while(cnt-->0) {
            index = Math.abs(index);
            sb.append(circleBoard[index]);
            if(--index<0){
                index=N-1;
            }
        }

        System.out.println(sb.toString());
    }

    static void print2() {

        int cnt = circleBoard.length;
        while(cnt-->0) {
            index = Math.abs(index);
            sb.append(circleBoard[index]);
            index = ((index-1)%N+N)%N; //음수 가능성이 있는 인덱스
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
