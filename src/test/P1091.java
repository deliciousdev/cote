package test;

import java.util.*;
import java.io.*;

/**
 * 배열을 여러번 연산하는거 익히기좋음
 * https://injae-kim.github.io/problem_solving/2020/02/20/baekjoon-1091.html
 * 사이클 관련 증명
 */
public class P1091 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] p;
    static int[] s;

    public static void main(String[] args) {
//        solve1();//비효율적인코드
        solve2();//효율높임
    }

    static void solve2(){
        N = sc.nextInt();
        p = new int[N];
        s = new int[N];
        int[] goal= new int[N];
        for (int i = 0; i < N; ++i) {
            p[i] = sc.nextInt();
            goal[i]=p[i];
        }

        for (int i = 0; i < N; ++i) {
            s[i] = sc.nextInt();
        }

        int cnt =0;
        int[] card=new int[N];
        for(int i=0; i<N; ++i) {
            card[i]=i;
        }

        while (!validate2(card)) {
            ++cnt;
            card=shuffle2(card);
            if(haveCycle(card)){
                cnt=-1;
                break;
            }
        }
        System.out.print(cnt);
    }
    static void solve1() {
        N = sc.nextInt();
        p = new int[N];
        s = new int[N];
        int[] goal= new int[N];
        for (int i = 0; i < N; ++i) {
            p[i] = sc.nextInt();
            goal[i]=p[i];
        }

        for (int i = 0; i < N; ++i) {
            s[i] = sc.nextInt();
        }

        int cnt =0;
        int[] card=new int[N];
        for(int i=0; i<N; ++i) {
            card[i]=i;
        }

        while (!validate(card,goal)) {
            ++cnt;
            card=shuffle(card);
            if(haveCycle(card)){
                cnt=-1;
                break;
            }
        }
        System.out.print(cnt);
    }

    static boolean haveCycle(int[] card){
        for(int i=0; i<N; ++i){
            if(card[i]!=i) return false;
        }
        return true;
    }

    static int[] shuffle2(int[] card){
        int[] temp= new int[N];
        for(int i=0; i<N; ++i){
            int idx= s[i];
            int value= card[i];
            temp[idx]=value;
        }
        return temp;
    }
    static int[] shuffle(int[] card){
        int[] temp= new int[N];
        for(int i=0; i<N; ++i){
            temp[i]=card[i];
        }
        for(int i=0; i<N; ++i){
            int idx= s[i];
            int value= temp[i];
            card[idx]=value;
        }
        return card;
    }


    static boolean validate(int[] card,int[] goal) {
        int[] temp=new int[N];

        for(int i=0; i<N; ++i){
            int cardValue= card[i];
            temp[cardValue]=i%3;
        }
        for(int i=0; i<N; ++i){
            if(goal[i]!=temp[i]) return false;
        }
        return true;
    }

    static boolean validate2(int[] card){
        for(int i=0; i<N; ++i){
            int originGoalPerson=p[card[i]];
            int actualPerson=i%3;

            if(originGoalPerson!=actualPerson) return false;
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
