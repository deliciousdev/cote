package part1.자료구조알고리즘1.ch01문자열.복습;

import java.util.*;
import java.io.*;

/**
 * Integer.parseInt("08") -> 8을 리턴함.
 * 포맷이 정해져있기 때문에 split 으로 파싱을 안하고 charAt()으로 파싱해도됨.
 * 혹은
 * Integer.parseInt(time.subString()) <<<이것을 이용했어도됨
 *
 * 정리: Integer.parseInt("09")
 * String.split() , String.subString() , StringCharAt() 이렇게 3가지 각각 이용해서 파싱 해보자.
 * String.format()
 *
 * 시간 이나 바이트를 연산할때는 가장작은 단위로 전환후 연산을 하면 편할 수 있음.
 */
public class _06Q13223 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        String current=sc.next();
        String target = sc.next();

        int currentToSec= convertToSec(current);
        int targetToSec= convertToSec(target);

        if(targetToSec<=currentToSec){
            targetToSec+=convertToSec("24:00:00");
        }

        int requiredSec= targetToSec-currentToSec;

        String ans= convertToString(requiredSec);

        System.out.print(ans);
    }

    static String convertToString(int accSec){
        int sec= accSec%60;
        accSec/=60;
        int minute= accSec%60;

        accSec/=60;
        int hour=accSec;

        StringBuilder s= new StringBuilder();
        if(hour<10){
            sb.append("0");
        }
        sb.append(hour).append(":");
        if(minute<10){
            sb.append("0");
        }
        sb.append(minute).append(":");
        if(sec<10){
            sb.append("0");
        }
        sb.append(sec);
//        return sb.toString();
        return String.format("%02d:%02d:%02d",hour,minute,sec);//두자리 정수로 맞추고 부족한것은 0 으로 채운다.
    }
    static int convertToSec(String time){
        String[] split = time.split(":");
        int hour=Integer.parseInt(split[0]);//08 도 8로 변환되네 고려해줘야함
        int minute =Integer.parseInt(split[1]);
        int sec= Integer.parseInt(split[2]);

        return sec+minute*60+hour*60*60;
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
