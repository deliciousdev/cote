package test;

import java.util.*;
import java.io.*;

/**
 * 부르트포스, 문자열
 */
public class P1411 {

    static FastReader sc= new FastReader();
    static String[] words;
    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        int n= sc.nextInt();
        words= new String[n];

        for(int i=0; i<n; ++i){
            words[i]=sc.next();
        }

        int cnt=0;
        for(int i=0; i<n; ++i){
            for(int j=i+1; j<n; ++j){
                if(validate(i,j)){
                    ++cnt;
                }
            }
        }
        System.out.print(cnt);
    }

    static boolean validate(int idx1, int idx2){
        final int L = words[idx1].length();
        char[] matching = new char['z'+1];
        char[] matching2 =new char['z'+1];
        boolean[] visited= new boolean['z'+1];
        boolean[] visited2= new boolean['z'+1];
        for(int i=0; i<L; ++i){
            char c1= words[idx1].charAt(i);
            char c2= words[idx2].charAt(i);
            if(!visited[c1]){
                visited[c1]=true;
                matching[c1]=c2;
            }
            else{
                if(matching[c1]!=c2) return false;
            }
            if(!visited2[c2]){
                visited2[c2]=true;
                matching2[c2]=c1;
            }
            else{
                if(matching2[c2]!=c1) return false;
            }


        }
        return true;
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while (st == null || !st.hasMoreElements()) {
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
