package part5.단기완성알고리즘._01완전탐색_BruteForce;

import java.util.*;
import java.io.*;

public class _08Q1759 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static final String VOWELS = "aeiou";
    static char[] arr;
    static char[] result;

    static int L, C;

    public static void main(String[] args) {
        solve1();
    }

    static void solve1() {
        L = sc.nextInt();
        C = sc.nextInt();

        for(int i=0; i<C; ++i){
            sb.append(sc.next());
        }
        arr=sb.toString().toCharArray();
        Arrays.sort(arr);
        sb.setLength(0);

        result=new char[L];

        cCombinationL();

        System.out.print(sb.toString());
    }

    static void cCombinationL(){
        rec_func(0,-1);
    }
    static void rec_func(int k,int s){
        if(k==L){
            if(inValid()) return;

            for(int i=0; i<result.length; ++i){
                sb.append(result[i]);
            }
            sb.append("\n");
            return ;
        }

        for(int i=s+1; i<C; ++i){
            result[k]=arr[i];
            rec_func(k+1,i);
        }
    }

    static boolean inValid(){
        int vowelsCnt=0;
        for(int i=0; i<result.length; ++i){
            for(int j=0; j<VOWELS.length(); ++j){
                if(result[i]==VOWELS.charAt(j)){
                    ++vowelsCnt;
                    break;
                }
            }
        }

        int consonantCnt= result.length-vowelsCnt;

        return vowelsCnt<1 || consonantCnt<2;
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
