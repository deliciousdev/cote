package part1.자료구조알고리즘1.ch01문자열.복습;

import java.util.*;
import java.io.*;

/**
 * 구현,문자열
 * 배열에 관한 반복문이 여러개 있다면 같은 반복문안에서 같이 돌릴 수 있음.
 */
public class _03Q1919_ {


    static FastReader sc= new FastReader();
    public static void main(String[] args){
//        solve1();
        solve2();//조금더 효율적인 반복문 : 인덱스를 같이 돌릴수 있음
    }

    static void solve2(){
        char[] input1= sc.next().toCharArray();
        char[] input2= sc.next().toCharArray();

        int[] cnt=new int['z'-'a'+1];
        int i1=0;
        int i2=0;
        while(i1<input1.length && i2<input2.length){
            ++cnt[input1[i1++]-'a'];
            --cnt[input2[i2++]-'a'];
        }
        while(i1<input1.length){
            ++cnt[input1[i1++]-'a'];
        }
        while(i2<input2.length){
            --cnt[input2[i2++]-'a'];
        }

        int ans=0;
        for(int i=0; i<cnt.length; ++i){
            ans+=Math.abs(cnt[i]);
        }
        System.out.print(ans);
    }
    static void solve1(){
        char[] input1= sc.next().toCharArray();
        char[] input2= sc.next().toCharArray();

        int[] cnt=new int['z'-'a'+1];
        for(char c :input1){
//            ++cnt[c];//캐릭터 개수만큼 배열을 잡았을때 캐릭터만큼 이동시켜줘야함
            ++cnt[c-'a'];
        }
        for(char c:input2){
            --cnt[c-'a'];
        }
        int ans=0;
        for(int i=0; i<cnt.length; ++i){
            ans+=Math.abs(cnt[i]);
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

    }
}
