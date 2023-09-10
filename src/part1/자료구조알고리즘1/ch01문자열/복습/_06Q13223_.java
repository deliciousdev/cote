package part1.자료구조알고리즘1.ch01문자열.복습;

import java.util.*;
import java.io.*;

/**
 * 수학, 구현, 사칙연산
 * 정해진 포맷으로 문자열읆 만들때 : String.format()
 */
public class _06Q13223_ {

    static FastReader sc= new FastReader();

    public static void main(String[] args){
//        solve1();//String.format()
        solve2(); //String.format() 사용안하고 StringBuilder 로 직접 구현
    }

    static void solve2(){
        String current=sc.next();
        String target= sc.next();

        int currentTotalSecond=convertToSecond(current);
        int targetTotalSecond= convertToSecond(target);

        if(targetTotalSecond<=currentTotalSecond){
            targetTotalSecond+=24*60*60;
        }

        int requiredTotalSecond=targetTotalSecond-currentTotalSecond;

        String formatTime = convertToFormat2(requiredTotalSecond);
        System.out.print(formatTime);
    }
    static void solve1(){
        String current=sc.next();
        String target= sc.next();

        int currentTotalSecond=convertToSecond(current);
        int targetTotalSecond= convertToSecond(target);

        if(targetTotalSecond<=currentTotalSecond){
            targetTotalSecond+=24*60*60;
        }

        int requiredTotalSecond=targetTotalSecond-currentTotalSecond;

        String formatTime = convertToFormat(requiredTotalSecond);
        System.out.print(formatTime);
    }

    static String convertToFormat2(int totalSecond){
        int s= totalSecond%60;
        int temp=totalSecond/60;

        int m= temp%60;
        temp/=60;

        int h= temp%60;
        StringBuilder sb= new StringBuilder();
        if(h<10){
            sb.append(0);
        }
        sb.append(h).append(":");

        if(m<10){
            sb.append(0);
        }
        sb.append(m).append(":");

        if(s<10){
            sb.append(0);
        }
        sb.append(s);
        return sb.toString();
    }
    static String convertToFormat(int totalSecond){
        int s= totalSecond%60;
        int temp=totalSecond/60;

        int m= temp%60;
        temp/=60;

        int h= temp%60;
        return String.format("%02d:%02d:%02d",h,m,s);
    }
    static int convertToSecond(String time){
        String[] split = time.split(":");
        int h=Integer.parseInt(split[0]);
        int m=Integer.parseInt(split[1]);
        int s=Integer.parseInt(split[2]);

        return h*60*60 + m*60 + s;
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
    }
}
