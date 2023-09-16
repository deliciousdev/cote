package test;

import java.util.*;
import java.io.*;

/**
 * 브루트포스
 */
public class P1522 {

    static FastReader sc= new FastReader();
    static char[] arr;
    public static void main(String[] args){
//        solve1();//원형을 배열 2배로 구현
        solve2();//원형을 인덱스 관리로 구현
    }

    static void solve2(){
        arr= sc.next().toCharArray();
        int aNum=0;
        for(int i=0; i<arr.length; ++i){
            if(arr[i]=='a')++aNum;
        }

        int L= arr.length;
        int ans=Integer.MAX_VALUE;
        for(int start=0; start<arr.length; ++start){
            int end=start+aNum-1;
            int bCnt = countB(arr,start,end);
            ans= Math.min(ans,bCnt);
        }
        System.out.print(ans);
    }

    static int countB(char[] arr, int sIdx, int eIdx){
        int cnt=0;
        for(int i=sIdx; i<=eIdx; ++i){
            if(arr[i%arr.length]=='b') ++cnt;
        }
        return cnt;
    }

    static void solve1(){
        String s= sc.next();
        arr= new char[s.length()*2];
        for(int i=0; i<arr.length; ++i){
            arr[i]=s.charAt(i%s.length());
        }
        int aNum=0;
        for(int i=0; i<s.length(); ++i){
            if(s.charAt(i)=='a'){
                ++aNum;
            }
        }

        int ans=Integer.MAX_VALUE;
        for(int i=0; i<s.length(); ++i){
            int endIdx=(i+aNum-1);
            int bCnt=countB(i,endIdx);
            ans=Math.min(ans,bCnt);
        }
        System.out.print(ans);
    }

    static int countB(int startIdx, int endIdx){
        int cnt=0;
        for(int i=startIdx;i<=endIdx; ++i){
            if(arr[i]=='b') ++cnt;
        }
        return cnt;
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
