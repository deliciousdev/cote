package test;

import java.util.*;
import java.io.*;

/**
 * 수학, 그리디, 문자열, 파싱
 */
public class P1541 {

    static FastReader sc= new FastReader();
    static String input;
    static ArrayList<Integer> numbers= new ArrayList<>();
    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        input= sc.next();

        String[] plusExpression = input.split("-");
        int sum=calcExpression(plusExpression[0]);
        for(int i=1; i<plusExpression.length; ++i){
            sum-= calcExpression(plusExpression[i]);
        }
        System.out.print(sum);
    }

    static int calcExpression(String expression){
        String[] split = expression.split("\\+");
        int sum=0;
        for(int i=0; i<split.length; ++i){
            sum+=Integer.parseInt(split[i]);
        }
        return sum;
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
