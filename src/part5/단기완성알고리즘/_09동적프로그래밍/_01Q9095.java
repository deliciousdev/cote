package part5.단기완성알고리즘._09동적프로그래밍;

import java.util.*;
import java.io.*;


public class _01Q9095 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N;
    static int T;
    static int cnt;

    public static void main(String[] args){
//        solve1();//완전탐색 : N 이 작기 때문에 가능 : 완전탐색 으로 할려면 시간이 너무 오래 걸리는데..?? -> dp를 떠올리자
//        solve2(); //매번 다이내틱 테이블을 계산함.
        solve3(); //맨처음 다이내믹 테이블을 계산해두고 테이스케이스마다 정답을 조회함
    }

    static void solve3(){
        T=sc.nextInt();
        int[] d= new int[1000];
        d[1]=1;
        d[2]=2;
        d[3]=4;
        for(int i=4; i<d.length; ++i){
            d[i]=d[i-1]+d[i-2]+d[i-3];
        }

        int t= T;
        while(t-->0){
            N=sc.nextInt();
            sb.append(d[N]).append("\n");
        }
        System.out.print(sb.toString().trim());
    }

    static void solve2(){
        T= sc.nextInt();

        int t= T;
//        int[] d= new int[N+1];
        int[] d= new int[1000]; //이것을 N으로 하면 N이 1,2 라면 d[3] 접근때문에 런타임 예외
        while(t-->0){
            N=sc.nextInt();
//            d= new int[N+1];
            d[1]=1;
            d[2]=2;
            d[3]=4;

            for(int i=4; i<=N; ++i){
                d[i]=d[i-1]+d[i-2]+d[i-3];
            }
            sb.append(d[N]).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void solve1(){
        T= sc.nextInt();

        int t= T;
        while(t-->0){
            N=sc.nextInt();
            cnt=0;
            dfs(0);
            sb.append(cnt).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void dfs(int sum){
        if(sum>N) return;

        if(sum==N) ++cnt;

        dfs(sum+1);

        dfs(sum+2);

        dfs(sum+3);

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
                }catch(IOException e ){
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
