package test;

import java.util.*;
import java.io.*;

/**
 * 구현
 */
public class P1316 {

    static FastReader sc= new FastReader();
    static int n;

    public static void main(String[] args){
//        solve1();//효율고려안함
        solve2(); //효율 고려
    }

    static void solve2(){
        n= sc.nextInt();
        int cnt=n;
        while(n-->0){
            boolean[] checked = new boolean['z'+1];
            char[] word= sc.next().toCharArray();

            checked[word[0]]=true;
            for(int i=1; i<word.length; ++i){
                if(word[i]!=word[i-1] && checked[word[i]]){
                    --cnt;
                    break;
                }
                checked[word[i]]=true;
            }
        }
        System.out.print(cnt);
    }

    static void solve1(){
        n= sc.nextInt();
        int cnt=0;
        while(n-->0){
            char[] word= sc.next().toCharArray();
            int originGroupCnt= countGroup(word);
            Arrays.sort(word);
            int sortedGroupCnt= countGroup(word);

            if(originGroupCnt==sortedGroupCnt) ++cnt;
        }
        System.out.print(cnt);
    }

    static int countGroup(char[] word){
        int cnt=1;
        for(int i=1; i<word.length; ++i){
            if(word[i]!=word[i-1]) ++cnt;
        }
        return cnt;
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
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
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
