package part1.자료구조알고리즘1.ch02시간복잡도.복습;

import java.util.*;
import java.io.*;

/**
 * 2차원 격자 순환 -> 1차원으로 가로세로 나눠서 생각해 볼 수 있음
 *
 * 강의 보면 문제 그대로 구현 하는 부분 있는데 (시간초과) 이것도 구현측면에서는 좋은 코드임
 * 1. 문제 그대로를 구현  2.시뮬레이션을 돌려서 주기를 구함(수학적계산없이). 3.모듈러 연산을 이용해서 시간복잡도를 줄인후 시뮬레이션.  4.논리적으로 주기를 구함
 * 주기성 에서는 모듈러 연산을 이용하자. 모듈러 계산은 T가 아주 클때 T를 0근처로 대칭이동시켜 주는 효과임.
 */
public class _02Q10158 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int w,h;
    static int p,q;
    static int t;
    public static void main(String[] args){
        solve1();
        System.out.print(sb.toString());
    }

    static void solve1(){
        w= sc.nextInt();
        h= sc.nextInt();
        p=sc.nextInt();
        q=sc.nextInt();
        t=sc.nextInt();

        int w_t= (p+t)%(2*w);
//        int w_t= (p+t)%2*w;//괄호안하면 안됨....
        int w_position=-1;
        if(w_t/w==1){
            w_position=2*w-w_t;
        }
        else{
            w_position=w_t;
        }

        int h_t= (q+t)%(2*h);
//        int h_t=(q+t)%2*h;//괄호안하면 안됨...
        int h_position=-1;
        if(h_t/h==1){
            h_position=2*h-h_t;
        }
        else{
            h_position=h_t;
        }

        sb.append(w_position).append(" ").append(h_position);
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
