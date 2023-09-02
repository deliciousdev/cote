package test;

import java.util.*;
import java.io.*;

//567123
public class P1334 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) {
        solve1();
    }

    static void solve1() {
        String n = sc.next();
        arr = new int[n.length()];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = n.charAt(i) - '0';
        }

        String palindrome = makePalindrome(n);
        if(palindrome.compareTo(n)>0){
            System.out.print(palindrome);
            System.exit(0);
        }

        final int L = arr.length;
        //i , L-1-i

        int idx= findAbleIncreaseFrontIdx(arr);
        if(idx!=-1){
            ++arr[idx];
            for(int i=idx+1; i<arr.length; ++i){
                arr[i]=0;
            }
            for(int i=0; i<arr.length; ++i){
                arr[L-1-i]=arr[i];
            }
            print();
            System.exit(0);
        }

        sb.append(1);
        for(int i=0; i<=arr.length-2; ++i){
            sb.append(0);
        }
        sb.append(1);
        System.out.print(sb.toString());
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; ++i) {
            sb.append(arr[i]);
        }
        System.out.print(sb.toString());
    }

    static int findAbleIncreaseFrontIdx(int[] arr){
        final int L = arr.length;
        for(int i=(L-1)/2; i>=0; --i){
            if(arr[i]!=9) return i;
        }
        return -1;
    }
    static String makePalindrome(String s){
        final int L = s.length();
        char[] c = s.toCharArray();
        for(int i=0; i<L/2; ++i){
            c[L-1-i]=c[i];
        }
        return String.valueOf(c);
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
    }
}
