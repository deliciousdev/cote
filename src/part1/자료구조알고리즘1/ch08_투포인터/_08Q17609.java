package part1.자료구조알고리즘1.ch08_투포인터;

import java.util.*;
import java.io.*;

public class _08Q17609 {

    static FastReader sc= new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int T;

    public static void main(String[] args){

//        solve1();
        solve2();
    }

    static void solve1(){
        T= sc.nextInt();
        int t=T;
        while(t-->0){
            int result = validate(sc.next());
            sb.append(result).append("\n");
        }
        System.out.print(sb.toString().trim());
    }

    static int validate(String str){
        int p1 =0;
        int p2= str.length()-1;
        boolean exactly = true;

        while(p1<=p2){
            char c1= str.charAt(p1);
            char c2= str.charAt(p2);
            if(c1 != c2){
                exactly = false;
                break;
            }
            ++p1;
            --p2;
        }
        if(exactly) return 0;

        int pp1 = p1;
        int pp2= p2;
        exactly= true;
        ++p1;//p1삭제
        while(p1<=p2){
            char c1= str.charAt(p1);
            char c2= str.charAt(p2);
            if(c1 != c2){
                exactly = false;
                break;
            }
            ++p1;
            --p2;
        }
        if(exactly) return 1;

        --pp2; //p2삭제
        while(pp1<=pp2){
            char c1= str.charAt(pp1);
            char c2= str.charAt(pp2);
            if(c1 != c2){
                return 2;
            }
            ++pp1;
            --pp2;
        }

        return 1;
    }

    static void solve2(){
        int T = sc.nextInt();

        int t=T;
        while(t-->0){
            String str= sc.next();
            int result = validate2(str);
            sb.append(result).append("\n");
        }
        System.out.print(sb.toString().trim());
    }

    static int validate2(String str){
        int left=0;
        int right= str.length()-1;
        while(left<=right){
            char c1 =str.charAt(left);
            char c2= str.charAt(right);
            if(c1!=c2){
                if(isPalindrome(str,left+1,right) || isPalindrome(str,left,right-1)){
                    return 1;
                }
                return 2;
            }
            ++left;
            --right;
        }
        return 0;
    }

    static boolean isPalindrome(String str, int left, int right){

        while(left<=right){
            char c1 = str.charAt(left);
            char c2= str.charAt(right);
            if(c1!=c2) return false;

            ++left;
            --right;
        }
        return true;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());

                } catch (IOException e) {
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
