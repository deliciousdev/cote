package part1.자료구조알고리즘1.ch01문자열;

import java.io.*;
import java.util.StringTokenizer;

public class _05Q1543 {


    static FastReader sc = new FastReader();

    static String input;
    static String target;

    static int cnt = 0;

    public static void main(String[] args) {

        input();
//        solve();
//        solve2();
//        solve3();
        solve4();
        System.out.println(cnt);
    }

    static void input() {
        input = sc.nextLine();
        target = sc.nextLine();
    }

    static void solve() {
        char startCharOfTarget = target.charAt(0);
        for (int inputIndex = 0; inputIndex <= input.length() - target.length(); ++inputIndex) {
            if (input.charAt(inputIndex) != startCharOfTarget) continue;

            boolean allMatch = false;

            int targetIndex = 0;
            for (; targetIndex < target.length(); ++targetIndex) {
                allMatch = true;
                if (input.charAt(inputIndex + targetIndex) != target.charAt(targetIndex)) {

                    allMatch = false;
                    break;
                }
            }
            if (allMatch) {
                ++cnt;
                inputIndex += target.length()-1;
            }
        }
    }

    static void solve2(){
        for(int nextIndex=0; nextIndex<= input.length()-target.length(); ++nextIndex) {
            int findIndex = input.indexOf(target, nextIndex); //nextIndex 부터 target 을 찾아서 index 반환
            if (findIndex >= 0) { //찾음
                ++cnt;
                nextIndex = findIndex + target.length() - 1;
            }
//            else{
//                break;
//            }
            //else break; 를 해줘야 훨씬 효율적임 안해줘도 답은 맞음
        }
    }

    static void solve3(){
        int nextIndex=0;
        while(true){
            int findIndex = input.indexOf(target, nextIndex);
            if(findIndex<0){
                break;
            }
            ++cnt;
            nextIndex = findIndex + target.length();
        }
    }


    static void solve4(){

        String result= input.replace(target, ""); //replace 는 엔트리에서 전부 찾아서 바꿔주고 그 결과의 String 을 반환

        cnt = (input.length() - result.length()) / target.length();
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
