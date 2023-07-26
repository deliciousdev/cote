package part1.자료구조알고리즘1.ch01문자열.복습;

import java.util.*;
import java.io.*;

public class _03Q1919 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int[] cnt= new int['z'-'A'+1]; //대문자 소문자 둘다 대응가능하지만 문제에서 소문자라고 조건이 주어졌엇네...
    public static void main(String[] args){
//        solve1();
        solve2();
    }

    static void solve2(){
        String s1= sc.next();
        String s2= sc.next();

        int i1=0;
        int i2=0;
        while(i1<s1.length() && i2<s2.length()){
            ++cnt[s1.charAt(i1++)-'a'];
            --cnt[s2.charAt(i2++)-'a'];
        }
        while(i1<s1.length()){
            ++cnt[s1.charAt(i1++)-'a'];
        }
        while(i2<s2.length()){
            --cnt[s2.charAt(i2++)-'a'];
        }

        int ans=0;
        for(int i=0; i<cnt.length; ++i){
            if(cnt[i]!=0){
                ans+=Math.abs(cnt[i]);
            }
        }
        System.out.print(ans);
    }

    static void solve1(){
        String s1= sc.next();
        String s2= sc.next();

        for(int i=0; i<s1.length(); ++i){
            char c= s1.charAt(i);
            ++cnt[c-'A'];
        }
        for(int i=0; i<s2.length(); ++i){
            char c= s2.charAt(i);
            --cnt[c-'A'];
        }

        int ans=0;
        for(int i=0; i<cnt.length; ++i){
            if(cnt[i]!=0) {
                ans+=Math.abs(cnt[i]);
            }
        }
        System.out.print(ans);
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null||!st.hasMoreElements()){
                try{
                    st= new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        String nextLine(){
            String str="";
            try{
                str=br.readLine();
            }catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
