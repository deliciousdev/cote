package part1.자료구조알고리즘1.ch04완전탐색_시뮬;

import java.io.*;
import java.util.StringTokenizer;

public class _04Q11068 {

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static StringBuilder ans = new StringBuilder();
    static int T;
    static int X;
    static char[] result= new char[21];

    public static void main(String[] args) {
        T = sc.nextInt();

        while(T-->0){
            X = sc.nextInt();
            boolean isPalindrome=true;

            for(int i=2; i<=64; ++i){
                sb.setLength(0);
                int length=0;
                int temp=X;
                while(temp>0){

                    result[length++]=(char)(temp%i);//String 으로 할려고 하면 자동으로 형변환 되어서 잘 안되는것 같음
                    temp/=i;
                }
                isPalindrome =true;
                for(int j=0; j<=(length+1)/2; ++j){
                    if (result[j] != result[length - 1 - j]) {
                        isPalindrome=false;
                        break;
                    }
                }
                if(isPalindrome) break;
            }
            ans.append(isPalindrome ? "1" : "0").append("\n");
        }

        System.out.println(ans.toString());
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
