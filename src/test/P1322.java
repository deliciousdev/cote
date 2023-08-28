package test;

import java.util.*;
import java.io.*;

/**
 * 큰비트와 작은 비트 차이가 53비트 이아여야 double 에서 오차가 없음 : 2^35 까지의 각각의 정수값은 오차없이 표현가능하지만 2^35+1 부터는 오차가 존재함.
 */
public class P1322 {

    static FastReader sc= new FastReader();
    static int x,k;
    public static void main(String[] args) {
        solve1();
//        solve2(); //Long.parseLong(number,2):2진수 문자열을 받으면 decimal로 바꿔줌
    }

    static void solve2(){
        x= sc.nextInt();
        k= sc.nextInt();
        char[] xBinary=Integer.toBinaryString(x).toCharArray();
        char[] kBinary= Integer.toBinaryString(k).toCharArray();

        StringBuilder sb= new StringBuilder();

        int xIdx=xBinary.length-1;
        int kIdx= kBinary.length-1;
        while(xIdx>=0 && kIdx>=0){
            if(xBinary[xIdx]=='1'){
                sb.append('0');
            }
            else{
                sb.append(kBinary[kIdx--]);
            }
            --xIdx;
        }

        while(kIdx>=0){
            sb.append(kBinary[kIdx--]);
        }
        while(xIdx>=0){
            if(xBinary[xIdx]=='1'){
                sb.append('0');
            }
            else{
                sb.append(xBinary[xIdx]);
            }
            --xIdx;
        }

        removeRearSerialZero(sb);

        long answer= Long.parseLong(sb.reverse().toString(),2);
        System.out.print(answer);
    }
    static void solve1(){
        x= sc.nextInt();
        k= sc.nextInt();
        char[] xBinary=Integer.toBinaryString(x).toCharArray();
        char[] kBinary= Integer.toBinaryString(k).toCharArray();

        StringBuilder sb= new StringBuilder();

        int xIdx=xBinary.length-1;
        int kIdx= kBinary.length-1;
        while(xIdx>=0 && kIdx>=0){
            if(xBinary[xIdx]=='1'){
                sb.append('0');
            }
            else{
                sb.append(kBinary[kIdx--]);
            }
            --xIdx;
        }

        while(kIdx>=0){
            sb.append(kBinary[kIdx--]);
        }
        while(xIdx>=0){
            if(xBinary[xIdx]=='1'){
                sb.append('0');
            }
            else{
                sb.append(xBinary[xIdx]);
            }
            --xIdx;
        }

        removeRearSerialZero(sb);

        long answer= convertToDecimal(sb.reverse().toString());
        System.out.print(answer);
    }

    static void removeRearSerialZero(StringBuilder sb){
        int cnt=0;
        for(int i=sb.length()-1; i>=0; --i){
            if(sb.charAt(i)=='1') break;

            ++cnt;
        }

        sb.setLength(sb.length()-cnt);
    }
    static long convertToDecimal(String binary){
        long decimal=0;
        final int L= binary.length();
        for(int i=0; i<L; ++i){
            if(binary.charAt(i)=='0') continue;
//            decimal+=Math.pow(2,L-1-i);//이건 틀렸다고 뜸
//            decimal+= 1L<<(L-1-i); //맞음
            decimal += (long)Math.pow(2,L-1-i); //맞음
        }
        return decimal;
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
    }
}
