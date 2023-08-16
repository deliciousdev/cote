package test;

import java.util.*;
import java.io.*;

/**
 * startsWith() 를 해도되고 indexOf() 를 해도되고
 * //https://www.acmicpc.net/source/64623087 :참고
 */
public class P1141 {

    static FastReader sc = new FastReader();

    static int n;

    public static void main(String[] args) {
        solve1();
    }

    static void solve1() {
        n = sc.nextInt();
        ArrayList<String> wordsStartWith[] = new ArrayList['z' + 1];
        for (int i = 'a'; i <= 'z'; ++i) {
            wordsStartWith[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; ++i) {
            String s = sc.next();
            wordsStartWith[s.charAt(0)].add(s);
        }

        int cnt = 0;
        for (int i = 'a'; i <= 'z'; ++i) {
            wordsStartWith[i].sort((s1, s2) -> Integer.compare(s1.length(), s2.length())*-1);
            for (int j = 0; j < wordsStartWith[i].size(); ++j) {
//                if (validate(wordsStartWith[i], j)) {
                if (validate2(wordsStartWith[i], j)) {
                    ++cnt;
                }
            }
        }
        System.out.print(cnt);
    }

    static boolean validate(ArrayList<String> words, int testIdx) {
        for (int i = 0; i < testIdx; ++i) {
            if (words.get(i).startsWith(words.get(testIdx))) return false;
        }
        return true;
    }

    static boolean validate2(ArrayList<String> words, int testIdx) {
        for (int i = 0; i < testIdx; ++i) {
            if (words.get(i).indexOf(words.get(testIdx))==0) return false;
        }
        return true;
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

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
