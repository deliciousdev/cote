package part1.자료구조알고리즘1.ch01문자열.복습;

import java.util.*;
import java.io.*;

/**
 * String 은 String.length()
 * 아스키코드 : 대문자 < 소문자
 * Character.toUpperCase()
 * Character.toLowerCase()
 */
public class _02Q2744 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args){
//        solve1();
//        solve2();
        solve3();
        System.out.print(sb.toString());
    }
    static void solve1(){
        char[] string= sc.next().toCharArray();
        final int d= 'a'-'A';
        for(int i=0; i<string.length; ++i){
            char c= string[i];
            if('A'<=c&& c<='Z'){
                string[i]= (char) (c+d);
            }
            else{
                string[i]=(char)(c-d);
            }
        }
        for(char c : string){
            sb.append(c);
        }
    }

    static void solve2(){
        String s= sc.next();
        for(int i=0; i<s.length(); ++i){
            char c= s.charAt(i);
            if('a'<=c&&c<='z'){
                c-='a'-'A';
            }
            else{
                c+='a'-'A';
            }
            sb.append(c);
        }
    }

    static void solve3(){
        String s= sc.next();
        for(int i=0; i<s.length(); ++i){
            char c= s.charAt(i);
            if('a'<=c&&c<='z'){
                c= Character.toUpperCase(c);
            }else{
                c=Character.toLowerCase(c);
            }
            sb.append(c);
        }
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
                    st=new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        String nextLine(){
            String str="";
            try{
                str= br.readLine();
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
