package part1.자료구조알고리즘1.ch04_2시뮬;

import java.io.*;
import java.util.StringTokenizer;

public class _06Q10250 {

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int T;
    static int H,W,N;//층,방,몇번째손님

    public static void main(String[] args) {

        T=sc.nextInt();
        while(T-->0){
            H = sc.nextInt();
            W = sc.nextInt();
            N = sc.nextInt();

//            int floor = calcFloor(H, N);
//            int roomNumber = calcRoomNumber(H, N);

            int floor = calcFloor2(H, N);
            int roomNumber = calcRoomNumber2(H, N);
//            sb.append(convertToString(floor, roomNumber)).append("\n");
            sb.append(String.format("%d%02d\n", floor, roomNumber));
        }
        System.out.println(sb.toString());

    }


    public static int calcFloor(int H, int N){
        int temp = N%H;
        if(temp==0){
            return H;
        }
        return temp;
    }

    public static int calcFloor2(int H, int N){
        return (N - 1) % H + 1;
    }

    public static int calcRoomNumber(int H, int N){
        if(N%H==0){
            return N/H;
        }
        return N/H+1;
    }

    public static int calcRoomNumber2(int H, int N){
        return (N-1)/H +1;
    }

    public static String convertToString(int floor, int roomNumber){//formatting 을 이용하면 간단함
        String f = String.valueOf(floor);
        String rm = String.valueOf(roomNumber);
        if(roomNumber>=1 && roomNumber<=9){
            rm = "0" + String.valueOf(roomNumber);
        }
        return f+rm;

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
