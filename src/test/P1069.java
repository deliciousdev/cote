package test;

import java.util.*;
import java.io.*;

/**
 * 생각을 잘해야하고, 엣지케이스도 고려해야함. 다른 사람들은 풀이도 참고해볼것.
 */
public class P1069 {

    static FastReader sc= new FastReader();
    static int x,y,d,t;
    public static void main(String[] args){
        x=sc.nextInt();
        y=sc.nextInt();
        d=sc.nextInt();
        t=sc.nextInt();

        solve1();
    }

    static void solve1(){

        double distance= Math.sqrt(x*x+y*y);

        if(distance<d){
            double oneJumpAndWalkTime= t+d-distance;
            double onlyWalkTime = distance;
            double twoJumpTime = 2*t;
            double ans = Math.min(onlyWalkTime,Math.min(oneJumpAndWalkTime,twoJumpTime));

            System.out.print(ans);
            System.exit(0);
        }

        double onlyWalkTime=distance;
        int n= (int)(distance/d);

        double jumpAndWalkTime = (t*n) + distance-(d*n);
        double onlyJumpTime = t*(n+1);

        double ans = Math.min(onlyWalkTime, Math.min(jumpAndWalkTime, onlyJumpTime));
        System.out.print(ans);
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
