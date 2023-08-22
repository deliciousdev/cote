package test;

import java.util.*;
import java.io.*;

/**
 * 이것저거 생각 해야할거 많은경우(중복, 순서 등등) 는 그냥 시간복잡도 허용되면 부르트포스로 하는게 최고임...
 * 실수의 최소 최대 구하듯이 문자열의 최대 최소 구할때...
 * 반례리스트 : https://www.acmicpc.net/board/view/102902
 */
public class P1251 {

    static FastReader sc= new FastReader();
    public static void main(String[] args){
//        solve1();//틀린풀이... 너무 생각할게 많은듯.
        solve2();//부르트포스
    }

    static void solve2(){
        String s= sc.next();

        char[] ans = new char[50];
        Arrays.fill(ans,'z');
        for(int i=0; i<s.length()-2; ++i){
            for(int j=i+1; j<s.length()-1; ++j){
                int idx1= i;
                int idx2= j;
                StringBuilder sb1=new StringBuilder(s.substring(0,idx1+1));
                StringBuilder sb2=new StringBuilder(s.substring(idx1+1,idx2+1));
                StringBuilder sb3= new StringBuilder(s.substring(idx2+1));
                String result= sb1.reverse().toString()+sb2.reverse()+sb3.reverse();
                if(result.compareTo(new String(ans))<0){
                    ans=result.toCharArray();
                }
            }
        }

        StringBuilder sb= new StringBuilder();
        for(int i=0; i<ans.length; ++i){
            sb.append(ans[i]);
        }
        System.out.print(sb.toString());
    }

    static void solve1(){

        String s= sc.next();
        char[] c= s.toCharArray();
        Arrays.sort(c);

        int target1=-1;
        int idx1=-1;
        while(idx1==-1){
            ++target1;
            for(int i=0; i<s.length()-2; ++i){
                if(c[target1]==s.charAt(i)){
                    idx1=i;
                    break;
                }
            }
        }

        int idx2=-1;
        int target2=-1;
        while(idx2==-1){
            ++target2;
            if(target2==target1) continue;
            for(int i=idx1+1; i<s.length()-1; ++i){
                if(c[target2]==s.charAt(i)){
                    idx2=i;
                    break;
                }
            }
        }

        StringBuilder sb1= new StringBuilder(s.substring(0,idx1+1));
        StringBuilder sb2= new StringBuilder(s.substring(idx1+1,idx2+1));
        StringBuilder sb3= new StringBuilder(s.substring(idx2+1));
        String result = sb1.reverse().toString()+sb2.reverse()+sb3.reverse();

        System.out.print(result);
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
