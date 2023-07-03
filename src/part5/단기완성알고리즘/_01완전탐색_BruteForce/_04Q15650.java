package part5.단기완성알고리즘._01완전탐색_BruteForce;


import java.util.*;
import java.io.*;

/**
 * 조합
 * 시간복잡도 : nCm
 */
public class _04Q15650 {

    static FastReader sc= new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N,M;
    static int[] result;

    public static void main(String[] args){
//        solve1();//뭘 선택했는지 파라미터로 넘겨줌
        solve2(); //뭘 선택했는지 배열을 참조함
    }

    static void solve1(){
        N= sc.nextInt();
        M= sc.nextInt();

        result= new int[M+1];

        rec_func(1,0);
        System.out.print(sb.toString().trim());
    }

    static void rec_func(int k, int s){
        if(k>M){

            for(int i=1; i<=M; ++i){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return ;
        }


        for(int i=s+1; i<=N; ++i){
            result[k]=i;
            rec_func(k+1,i);
        }
    }

    static void solve2(){
        N= sc.nextInt();
        M= sc.nextInt();

        result= new int[M+1];

        rec_func2(1);
        System.out.print(sb.toString().trim());
    }

    static void rec_func2(int k){
        if(k>M){
            for(int i=1; i<=M; ++i){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return ;
        }


        for(int i=result[k-1]+1; i<=N; ++i){
            result[k] =i;
            rec_func2(k+1);
        }
    }
    static class FastReader{
        BufferedReader br ;
        StringTokenizer st;
        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st==null|| !st.hasMoreElements()){
                try{
                    st= new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine(){
            String str ="";
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
