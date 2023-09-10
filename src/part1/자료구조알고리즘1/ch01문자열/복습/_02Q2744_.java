package part1.자료구조알고리즘1.ch01문자열.복습;

import java.util.*;
import java.io.*;


/**
 * 문자변환시 대칭이동, Character.toLowerCase, Character.toUpperCase()
 */
public class _02Q2744_ {

    static FastReader sc= new FastReader();

    public static void main(String[] args){
//        solve1();//Character.toLowerCase() , character.toUpperCase()
//        solve2(); //+- 변위
        solve3(); //대문자: 'A' 대칭이동후 'a' 대칭이동 하면 소문자로 변환
    }

    static void solve3(){
        char[] input=sc.next().toCharArray();

        for(int i=0; i<input.length; ++i){
            if('A'<=input[i]&&input[i]<='Z'){
                input[i]= (char)(input[i]-'A'+'a'); //대문자 대칭이동후 소문자 대칭이동
            }
            else{
                input[i]=(char)(input[i]-'a'+'A');//소문자 대칭이동후 소문자 대칭이동
            }
        }
    }

    static void solve2(){
        char[] input = sc.next().toCharArray();

        for(int i=0; i<input.length; ++i){
            if('A'<=input[i]&& input[i]<='Z'){
                input[i]=Character.toLowerCase(input[i]);
            }
            else{
                input[i]=Character.toUpperCase(input[i]);
            }
        }
        print(input);
    }

    static void solve1(){
        char[] input =sc.next().toCharArray();

        final int d = 'a'-'A';
        for(int i=0; i<input.length; ++i){
            if('A'<=input[i] && input[i]<='Z'){
                input[i] += d;
            }
            else{
                input[i] -=d;
            }
        }
        print(input);
    }

    static void print(char[] input){
        StringBuilder sb= new StringBuilder();
        for(char e : input){
            sb.append(e);
        }
        System.out.print(sb.toString());
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
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }
}
