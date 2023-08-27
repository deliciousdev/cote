package test;

import java.util.*;
import java.io.*;

/**
 * 구현 문제
 */

public class P1308 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        Day today = new Day(sc.nextInt(),sc.nextInt(),sc.nextInt());
        Day target = new Day(sc.nextInt(),sc.nextInt(),sc.nextInt());

        if(overThousandYear(today,target)){
            System.out.print("gg");
            System.exit(0);
        }

        int todayCnt= today.calcElapseDayFromBeginning();
        int targetCnt= target.calcElapseDayFromBeginning();
        int result= targetCnt-todayCnt;
        sb.append("D-").append(result);
        System.out.print(sb.toString());
    }

    static boolean overThousandYear(Day today, Day target){
        if(target.year-today.year<1000) return false;
        if(target.year-today.year>1000) return true;

        if(target.month<today.month) return false;
        if(target.month>today.month) return true;

        if(target.day>=today.day) return true;
        return false;
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

    static class Day{

        static int[] dayLength= {0,31,28,31,30,31,30,31,31,30,31,30,31};
        int year;
        int month;
        int day;
        Day(int year, int month, int day){
            this.year= year;
            this.month = month;
            this.day= day;
        }

        int calcElapseDayFromBeginning(){
            int count=0;

            int y=1;
            while(y<this.year) {
                count += isNormalYear(y) ? 365 : 366;
                ++y;
            }
            int m=1;
            while(m<this.month){
                count+= dayLength[m];
                if(!isNormalYear(this.year)&&m==2){
                    ++count;
                }
                ++m;
            }

            int d=1;
            while(d<this.day){
                ++count;
                ++d;
            }
            return count;
        }

        boolean isNormalYear(int y){
            if(y%400==0) return false;
            if(y%100==0) return true;
            if(y%4==0) return false;
            return true;
        }
    }
}
