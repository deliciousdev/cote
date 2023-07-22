package part5.단기완성알고리즘._09동적프로그래밍;

import java.util.*;
import java.io.*;

/**
 * 완전탐색에서의 논리처럼 결국 2 or 1 선택하는것이다., 이 논리를 동적프로그래밍으로 그대로 가져간다. ( 완전 탐색을 할려면 N이 너무 클경우에 시간초과가 남)
 * 그러면 결국 d(N) 은 끝에 2로 끝나거나 1로 끝나는것. 2로 끝나는경우 : d(n-2) , 1로 끝나는경우: d(n-1)
 * 많은 경우의 완전탐색 문제들은 동적프로그래밍으로 훨씬 빠르게 풀리기도한다.
 */

public class _02Q11726 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();


    static int N;

    static int cnt;
    static int[] d;
    public static void main(String[] args){
//        solve1(); //dp : 오버플로우
//        solve2();//완전탐색
        solve3(); //dp
    }

    static void solve2(){
        N=sc.nextInt();
        d=new int[N+1];
        rec_func(0);
        System.out.print(cnt);
    }
    static void rec_func(int length){
        if(length==N) {
            ++cnt;
        }

        ++d[length];
        if(length+1<=N){
            rec_func(length+1);
        }
        if(length+2<=N){
            rec_func(length+2);
        }

    }
    static void solve1(){//오버플로우 나는듯?

        d=new int[1000+1];
        d[1]=1;
        d[2]=2;
        for(int i=3; i<d.length;++i){
            d[i]=d[i-1]+d[i-2];
        }
        N= sc.nextInt();
        int ans= d[N]%10007;
        System.out.print(ans);
    }

    static void solve3(){
        d=new int[1000+1];
        d[1]=1;
        d[2]=2;
        for(int i=3; i<d.length;++i){
            d[i]=(d[i-1]+d[i-2])%10007;
        }
        N= sc.nextInt();

        System.out.print(d[N]);
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
