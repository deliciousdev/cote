package part1.자료구조알고리즘1.ch02시간복잡도.복습;

import java.util.*;
import java.io.*;

/**
 * 수학, 애드 혹, 사칙연산
 * 대칭적인좌표 처리...
 */
public class _02Q10158_ {


    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();
    static int w,h,p,q,t;
    public static void main(String[] args) {
        solve1();
    }

    static void solve1(){
        w=sc.nextInt();
        h=sc.nextInt();
        p=sc.nextInt();
        q=sc.nextInt();
        t=sc.nextInt();

        //int x=t%(2*w)+p : 이렇게 하면 0~2w 사이에 값이 나온다는 보장이없음.
        int x= (t+p)%(2*w);
        int y= (t+q)%(2*h);
        if(x>w){
//            x=w-(x%w);
            x=2*w-x; //대칭적인 좌표처리
        }
        if(y>h){
            y=h-(y%h);
        }
        sb.append(x).append(" ").append(y);
        System.out.print(sb.toString());
//        System.out.print(x+" "+y); //이렇게 하면 시간초과....
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while (st == null || !st.hasMoreElements()) {
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
