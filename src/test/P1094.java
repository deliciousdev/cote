package test;

import java.io.*;
import java.util.*;

/**
 * Integer.toBinaryString(int x)
 */
public class P1094 {

    static FastReader sc= new FastReader();

    static int X;
    public static void main(String[] args){
//        solve1();//문제 그대로 구현
//        solve2();//이진수이용
        solve3(); //replace 이용
    }

    static void solve3(){
        String s= Integer.toBinaryString(sc.nextInt());
        int ans = s.length()-s.replace("1","").length();
        System.out.print(ans);
    }

    static void solve2(){
        String s= Integer.toBinaryString(sc.nextInt());
        int cnt=0;
        for(int i=0; i<s.length(); ++i){
            if(s.charAt(i)=='1') ++cnt;
        }
        System.out.print(cnt);
    }

    static void solve1(){
        X=sc.nextInt();
        if(X==64){
            System.out.print(1);
            System.exit(0);
        }

        int cnt=0;
        int sum=64;
        int stick=64;

        while(true){
            stick/=2;
            if(sum-stick>X){
                sum-=stick;
            }
            else if(sum-stick<X){
                ++cnt;
            }
            else{
                ++cnt;
                break;
            }
        }
        System.out.print(cnt);
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

        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
