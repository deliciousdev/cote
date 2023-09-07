package test;

import java.util.*;
import java.io.*;

/**
 * 부르트포스, 부동소수점 오차, 이분탐색
 */
public class P1206 {

    static FastReader sc= new FastReader();
    static int[] arr;
    static int n;

    public static void main(String[] args){
        n= sc.nextInt();
        arr= new int[n];
        for(int i=0; i<n; ++i){

            arr[i]=extractThreeDigitNumber(sc.next());
        }
        solve1();
    }

    static void solve1(){

        for(int people=1; people<=1000; ++people){
            boolean ok=true;
            for(int i=0; i<n; ++i){
                if(arr[i]==0 || arr[i]==10000) continue;

//                if(!validateSum(arr[i],people)){
                if(!validateSum2(arr[i],people)){
                    ok=false;
                    break;
                }
            }
            if(ok){
                System.out.print(people);
                System.exit(0);
            }
        }

    }

    static boolean validateSum(int average,int people){
        int mn=0;
        int mx= 10*people;

        for(int base=mn; base<=mx; ++base){
            int sum= base*1000;
            if(sum/people==average){
                return true;
            }
        }
        return false;
    }

    static boolean validateSum2(int average, int people){
        int mn=0;
        int mx=10*people;

        int left= mn;
        int right= mx;
        while(left<=right){
            int mid=(left+right)/2;
            int sum= mid*1000;
            int ave= sum/people;
            if(ave<average){
                left=mid+1;
            }
            else if (ave>average){
                right=mid-1;
            }
            else{
                return true;
            }
        }

        return false;
    }
    static int extractThreeDigitNumber(String s){
        if(s.equals("10.000")) return 10000;
        return Integer.parseInt(s.substring(2));
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
        int nextInt(){
            return Integer.parseInt(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
    }
}
