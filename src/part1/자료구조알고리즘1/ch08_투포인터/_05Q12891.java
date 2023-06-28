package part1.자료구조알고리즘1.ch08_투포인터;

import java.util.*;
import java.io.*;

public class _05Q12891 {

    static FastReader sc= new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int S, P;
    static final int A =0;
    static final int C =1;
    static final int G =2;
    static final int T = 3;

    public static void main(String[] args){
        solve1(); //투포인터 : Sliding Window
//        solve2(); //누적합
    }

    static void solve1(){
        S=sc.nextInt();
        P= sc.nextInt();
        String str= sc.nextLine();

        int[] condition = new int[4];
        for(int i=0; i<4; ++i){
            condition[i] =sc.nextInt();
        }

        int[] cnt= new int[4];
        int rightP =0;
        for(; rightP<P; ++rightP){
            char c = str.charAt(rightP);
            ++cnt[convert(c)];
        }
        int ans=0;

        rightP = P-1;
        int leftP =0;

        while(rightP<=S-2){
            if(validate(cnt,condition)) ++ans;

            char rightC = str.charAt(++rightP);
            char leftC= str.charAt(leftP++);

            ++cnt[convert(rightC)];
            --cnt[convert(leftC)];
        }
        if(validate(cnt,condition)) ++ans;

        System.out.print(ans);
    }



    static int convert(char c){ //Map 을 사용해도 됨 : 물론 Map 을 사용하면 시간복잡도는 증가하긴함. 이문제에서는 Map 크기가 적어서 의미없긴하지만
        int result =-1;
        switch(c){
            case 'A': result=0; break;
            case 'C' : result=1; break;
            case 'G' : result=2; break;
            case 'T':result=3; break;
        }
        return result;
    }
    static boolean validate(int[] cnt, int[] condition){
        for(int i=0; i<4; ++i){
            if(cnt[i]<condition[i]) return false;
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
            String str= "";
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
