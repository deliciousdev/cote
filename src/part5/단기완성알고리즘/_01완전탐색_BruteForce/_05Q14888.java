package part5.단기완성알고리즘._01완전탐색_BruteForce;


import java.util.*;
import java.io.*;

public class _05Q14888 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] numbers;
    static int[] op = new int[4]; //+ - * /
    static int mx = Integer.MIN_VALUE;
    static int mn = Integer.MAX_VALUE;

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        N= sc.nextInt();
        numbers= new int[N];
        for(int i=0; i<N; ++i){
            numbers[i]=sc.nextInt();
        }
        for(int i=0; i<4; ++i){
            op[i] = sc.nextInt();
        }


        rec_func(1,numbers[0]);
        sb.append(mx).append("\n").append(mn);
        System.out.print(sb.toString().trim());
    }


    //이부분 함수로 빼보자
    static void rec_func(int k, int calc){
        if(k==N){
            mx= Math.max(mx,calc);
            mn=Math.min(mn,calc);
            return ;
        }

        if(op[0]>0){
            --op[0];
            rec_func(k+1, calc+numbers[k]);
            ++op[0];
        }

        if(op[1]>0){
            --op[1];
            rec_func(k+1, calc-numbers[k]);
            ++op[1];
        }

        if(op[2]>0){
            --op[2];
            rec_func(k+1, calc*numbers[k]);
            ++op[2];
        }

        if(op[3]>0){
            --op[3];
            rec_func(k+1, calc/numbers[k]);
            ++op[3];
        }
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st==null ||!st.hasMoreElements()){
                try{
                    st= new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        String nextLIne(){
            String str= "";
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
