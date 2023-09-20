package test;

import java.util.*;
import java.io.*;


/**
 * 구현 문자열 정렬 파싱
 */
public class P1706 {

    static FastReader sc = new FastReader();

    static int r, c;
    static char[][] arr;
    static ArrayList<String> words= new ArrayList<>();
    public static void main(String[] args) {
        solve1();
    }

    static void solve1() {
        r = sc.nextInt();
        c = sc.nextInt();
        arr = new char[r][c];

        for (int i = 0; i < r; ++i) {
            arr[i] = sc.next().toCharArray();
        }

        StringBuilder sb= new StringBuilder();
        //가로 탐색
        for(int i=0; i<r; ++i){
            for(int j=0; j<c; ++j){
                if(arr[i][j]=='#') {
                    if(sb.length()>1) {
                        words.add(sb.toString());
                    }
                    sb.setLength(0);
                    continue;
                }

                sb.append(arr[i][j]);
            }
            if(sb.length()>1){
                words.add(sb.toString());
            }
            sb.setLength(0);
        }

        //세로탐색
        for(int i=0; i<c; ++i){
            for(int j=0; j<r; ++j){
                if(arr[j][i]=='#'){
                    if(sb.length()>1){
                        words.add(sb.toString());
                    }
                    sb.setLength(0);
                    continue;
                }

                sb.append(arr[j][i]);
            }
            if(sb.length()>1){
               words.add(sb.toString());
            }
            sb.setLength(0);
        }

        Collections.sort(words);
        System.out.print(words.get(0));
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
