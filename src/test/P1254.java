package test;

import java.util.*;
import java.io.*;

public class P1254 {

    static FastReader sc= new FastReader();

    public static void main(String[] args){
//        solve1();//부르트포스 : 0개 추가해보고, 1개 추가해 보고, 2가 추가해보고....
//        solve2(); //solve1()을 조금더 이쁘게
        solve3();//문자열중에서 팰린드롬인 부분과 아닌 부분을 찾아서 정확히 몇개가 추가로 필요한지 찾아냄
    }

    static void solve3(){
        String s=sc.next();

        int ans=-1;
        for(int i=0; i<s.length(); ++i){
            if(isPalindrome(s.substring(i))){
                ans=s.length()+i;
                break;
            }
        }
        System.out.print(ans);
    }

    static boolean isPalindrome(String s){
        final int L = s.length();
        for(int i=0; i<L/2; ++i){
            if(s.charAt(i)!=s.charAt(L-1-i)) return false;
        }
        return true;
    }
    static void solve2(){
        String s= sc.next();
        final int L = s.length();
        int ans=-1;
        for(int extra=0; extra<=L; ++extra){
            if(isPalindrome(s,extra)){
                ans=extra+L;
                break;
            }
        }
        System.out.print(ans);
    }

    static boolean isPalindrome(String s, int extra){
        final int L =s.length();
        for(int i=extra; i<=(L+extra-1)/2; ++i){
            if(s.charAt(i)!=s.charAt(L-1+extra-i)) return false;
        }
        return true;
    }

    static void solve1(){
        String s= sc.next();

        int ans=-1;
        final int L=s.length();

        for(int extra=0; extra<=L; ++extra){
            boolean isPalindrome=true;
            for(int i=extra; i<=(L-1+extra)/2; ++i){
                if(s.charAt(i)!=s.charAt((L-1+extra-i))){
                    isPalindrome=false;
                    break;
                }
            }
            if(isPalindrome){
                ans=extra+L;
                break;
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
                    st= new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

    }
}
