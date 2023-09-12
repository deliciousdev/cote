package test;

import java.util.*;
import java.io.*;

/**
 * dp ,완전탐색
 * 현재위치에서 어디로 갈수 있는지를 계산하는 로직이 아니라(틀린로직), 현재 위치에 올수 있는 모든 경우들을 고려하는 로직임
 */
public class P1446 {

    static FastReader sc= new FastReader();
    static int n,D;
    static int[] dp; //dp[i] : i까지 오는데 최소 비용
    public static void main(String[] args){
//        solve1();//dp
        solve2();
//        solve2();//완전탐색
    }

    static void solve2(){
        n=sc.nextInt();
        D= sc.nextInt();

        dp= new int[D+1];
        ArrayList<ArrayList<Data>> arriveAt = new ArrayList<>();

        for(int i=0; i<=D; ++i){
            arriveAt.add(new ArrayList<>());
        }
        while (n-- > 0) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost=sc.nextInt();
            if(to>D) continue;

            arriveAt.get(to).add(new Data(from, cost));
        }

        for(int i=1; i<dp.length; ++i){
            dp[i]=dp[i-1]+1;

            for (Data d : arriveAt.get(i)) {
                dp[i]=Math.min(dp[d.from]+d.cost,dp[i]);
            }
        }
        System.out.print(dp[D]);
    }

    static void solve1(){
        n=sc.nextInt();
        D= sc.nextInt();

        dp= new int[D+1];
        ArrayList[] arriveAt = new ArrayList[D+1];
//        Arrays.fill(arriveAt,new ArrayList<Data>());//이렇게 하면 다 같은 객체네...?
        for(int i=0; i<=D; ++i){
            arriveAt[i]=new ArrayList<Data>();
        }
        while (n-- > 0) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost=sc.nextInt();
            if(to>D) continue;

            arriveAt[to].add(new Data(from, cost));
        }

        for(int i=1; i<dp.length; ++i){
            dp[i]=dp[i-1]+1;

            for (Object datas : arriveAt[i]) {
                Data d= (Data)datas;
                dp[i]=Math.min(dp[d.from]+d.cost,dp[i]);
            }
        }

        System.out.print(dp[D]);
    }

    static class Data{
        int from;
        int cost;
        Data(int from, int cost){
            this.from=from;
            this.cost=cost;
        }
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
