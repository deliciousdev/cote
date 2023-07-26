package part1.자료구조알고리즘1.ch01문자열.복습;

import java.util.*;
import java.io.*;

/**
 * String 에서 String 을 검색 할때 indexOf() : 해당 target 문자열의 시작 index 를 반환. 없으면 -1반환
 * 이런문제는 인덱스 범위 조심
 */
public class _05Q1543 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args){
//        solve1(); //함수호출로 검증
//        solve2(); //함수호출하지않고 검증 (함수호출하는 오버헤드가 크나 비교해봤는데 차이 없음) : 가독성 엄청 떨어짐
//        solve3(); //indexOf 사용
        solve4();//replace 사용
    }

    static void solve2(){
        String s= sc.nextLine();
        String target= sc.nextLine();
        if(target.length()>s.length()){
            System.out.print(0);
            System.exit(0);
        }

        int ans=0;
        int idx=0;
        while(idx<=s.length()-target.length()){
            boolean isAllMatch=true;
            if(s.charAt(idx)==target.charAt(0)){
                for(int i=0; i<target.length(); ++i){
                    if(s.charAt(idx+i)!=target.charAt(i)){
                        isAllMatch=false;
                        break;
                    }
                }

            }
            else{
                isAllMatch=false;
            }

            if(isAllMatch){
                ++ans;
                idx+=target.length();
            }
            else{
                ++idx;
            }
        }
        System.out.print(ans);
    }
    static void solve1(){
        String s= sc.nextLine();
        String target= sc.nextLine();

        //while 조건문에서 걸러지므로 필요없는 로직임
//        if(target.length()>s.length()){
//            System.out.print(0);
//            System.exit(0);
//        }

        int ans=0;
        int idx=0;
        while(idx<=s.length()-target.length()){
            if(s.charAt(idx)==target.charAt(0) && contains(s,target,idx)){
                ++ans;
                idx+=target.length();
            }
            else{
                ++idx;
            }
        }
        System.out.print(ans);
    }
    static void solve3(){
        String base= sc.nextLine();
        String target =sc.nextLine();
        int ans=0;
        for(int i=0; i<=base.length()-target.length(); ++i){
            int idx=base.indexOf(target,i);
            if(idx<0){
                break;
            }
            ++ans;
//            i+= target.length()-1;//틀린코드
            i= idx+target.length()-1;
        }
        System.out.print(ans);
    }
    static void solve4(){
        String base= sc.nextLine();
        String target=sc.nextLine();
        String replace = base.replace(target, "");

        int ans= (base.length()-replace.length())/target.length();
        System.out.print(ans);
    }

    static boolean contains(String base,String target,int fromIdx){
        String sub=base.substring(fromIdx,fromIdx+target.length());
        return sub.equals(target);
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
