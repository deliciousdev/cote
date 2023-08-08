package test;

import java.io.*;
import java.util.*;

/**
 * 어떤 수의 각자리 숫자를 볼때는 String 으로 바꿔서 하는게 편하긴함.
 */
public class P1065 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N;
    static ArrayList<Integer> hansu = new ArrayList<>();


    public static void main(String[] args){
        solve1();//브루트포스 : 진짜로 무식함
    }

    static void solve1(){
        N=sc.nextInt();
        int cnt=0;
        for(int i=1; i<=N; ++i){
//            if(validate(i)) ++cnt;
            if(validate2(i)) ++cnt;
        }
        System.out.print(cnt);
    }
    static boolean validate(int x){
        if(x<100) return true;

        int length=0;
        int[] digit=new int[4];
        while(x>0){
            int digitNum=x%10;
            x/=10;
            digit[length++]=digitNum;
        }
        int d=digit[1]-digit[0];
        for(int i=2; i<length; ++i){
            if(digit[i]-digit[i-1] !=d) return false;
        }
        return true;
    }

    static boolean validate2(int x){
        if(x<100) return true;

        String s=String.valueOf(x);
        int d= s.charAt(1)-s.charAt(0);
        for(int i=2; i<s.length(); ++i){
            if(s.charAt(i)-s.charAt(i-1)!=d) return false;
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
