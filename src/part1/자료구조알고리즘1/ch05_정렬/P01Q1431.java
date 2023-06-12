package part1.자료구조알고리즘1.ch05_정렬;


import java.util.*;
import java.io.*;

public class P01Q1431 {

    static FastReader sc = new FastReader();
    static int N;
    static String[] serialNumbers;

    public static void main(String[] args){
        init();

        for(int i=0; i<N; ++i){
            serialNumbers[i] = sc.next();
        }

        Arrays.sort(serialNumbers, new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    return Integer.compare(s1.length(), s2.length());
                }
                int s1Digit = sumDigit(s1);
                int s2Digit = sumDigit(s2);

                if (s1Digit != s2Digit) {
                    return Integer.compare(s1Digit, s2Digit);
                }

                return s1.compareTo(s2);
            }

            private int sumDigit(String s) {
                int result = 0;
                for (int i = 0; i < s.length(); ++i) {
                    char c = s.charAt(i);
                    if ('0' <= c && c <= '9') {
                        result += c - '0';
                    }
                }
                return result;
            }
        });

        print(serialNumbers);
    }

    static void init(){
        N= sc.nextInt();
        serialNumbers= new String[N];
    }

    static void print(String[] serial){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<serial.length; ++i){
            sb.append(serial[i]).append("\n");
        }
        System.out.print(sb.toString());
    }

    static class FastReader{
        BufferedReader br ;
        StringTokenizer st;

        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st == null || !st.hasMoreElements()) {
                try{
                    st= new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
