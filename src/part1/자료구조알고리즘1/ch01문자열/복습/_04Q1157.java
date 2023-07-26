package part1.자료구조알고리즘1.ch01문자열.복습;

import java.util.*;
import java.io.*;

/**
 * Character.toUpperCase();
 * String.toUpperCase();
 */
public class _04Q1157 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();


    public static void main(String[] args){
//        solve1();//Character.toUpperCase()
        solve2();//String.toUpperCase();
    }

    static void solve2(){

        int[] cnt=new int['Z'-'A'+1];
        int mxCnt=0;
        char ans=0;
        String s=sc.next().toUpperCase();
        for(int i=0; i<s.length(); ++i){
            char c= s.charAt(i);
            ++cnt[c-'A'];
            if(cnt[c-'A']>mxCnt){
                mxCnt=cnt[c-'A'];
                ans=c;
            }
            else if(cnt[c-'A']==mxCnt){
                ans='?';
            }
        }
        System.out.print(ans);
    }

    static void solve1(){
        String s= sc.next();
        int[] cnt= new int['Z'-'A'+1];
        char ans=0; //인덱스 정보를 갖고있어도되긴한데, 물음표 처리를 위해서는 그냥 알파벳 정보를 들고 있는게 더 나음
        int mxCnt=0;
        for(int i=0; i<s.length(); ++i){
            char c= Character.toUpperCase(s.charAt(i));
            ++cnt[c-'A'];
            if(cnt[c-'A']>mxCnt){
                mxCnt=cnt[c-'A'];
                ans=c;
            }
            else if(cnt[c-'A']==mxCnt){
                ans='?';
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
