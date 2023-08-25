package test;

import java.util.*;
import java.io.*;

/**
 * 구현 문제
 */
public class P1283 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();
    static int n;

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        n= sc.nextInt();
        boolean[] used = new boolean['Z'+1];
        for(int i=0; i<n; ++i){
            String option = sc.nextLine();
            int shortcutIdx = chooseShortCutCharIdx(option,used);
            String reflectedWord = reflectShortcut(option,shortcutIdx);
            sb.append(reflectedWord).append("\n");
        }
        System.out.print(sb.toString());
    }

    static int chooseShortCutCharIdx(String option,boolean[] used){
        String[] words = option.split(" ");

        int idx=0;
        for(String word: words){
            char firstCharacter = Character.toUpperCase(word.charAt(0));
            if(!used[firstCharacter]) {
                used[firstCharacter]=true;
                return idx;
            }
            idx+=word.length()+1;
        }

        idx=0;
        for(String word:words){
            for(int i=0; i<word.length(); ++i){
                char c = Character.toUpperCase(word.charAt(i));
                if(!used[c]) {
                    used[c]=true;
                    return idx+i;
                }
            }
            idx+=word.length()+1;
        }
        return -1;
    }

    static String reflectShortcut(String option, int idx){
        if(idx==-1) return option;

        StringBuilder sb= new StringBuilder();
        for(int i=0; i<idx; ++i){
            sb.append(option.charAt(i));
        }

        sb.append("[").append(option.charAt(idx)).append("]");
        for(int i=idx+1; i<option.length(); ++i){
            sb.append(option.charAt(i));
        }

        return sb.toString();
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
