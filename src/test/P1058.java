package test;

import java.util.*;
import java.io.*;

/**
 *
 * bfs,플로이드워샬 : 모든 정점에서 모든 정점으로의 거리를 구하는 알고리즘.
 * cf)다익스트라, 벨만포드는 한 정점에서 다른 정점으로 가는 알고리즘임
 * 문제를 읽고 해당 노드에서 길이가 2보다 작은부분을 탐색해서 노드의 개수를 구하는것을 간파해야함
 */
public class P1058 {

    static FastReader sc= new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static ArrayList<Integer>[] adj;
    static int[] distance;
    static int[][] dp;
    public static void main(String[] args){
//        solve1();//단순 bfs
        solve2();//플로이드워셜
    }

    static void solve2(){
        N= sc.nextInt();
        dp =new int[N+1][N+1];
        for(int i=1; i<=N; ++i){
            for(int j=1; j<=N; ++j){
                dp[i][j]=100000;
            }
        }
        for(int i=1; i<=N; ++i){
            String s= sc.next();
            for(int j=1; j<=N; ++j){
                if(s.charAt(j-1)=='Y'){
                    dp[i][j]=1;
                }
            }
        }
        for(int i=1; i<=N; ++i){
            for(int j=1; j<=N; ++j){
                for(int k=1; k<=N; ++k){
                    dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k][j]);
                }
            }
        }

        int ans=-1;
        for(int i=1; i<=N; ++i){
            ans=Math.max(ans,count(i));
        }
        System.out.print(ans);
    }

    static int count(int start){
        int cnt=0;
        for(int i=1; i<=N; ++i){
            if(i==start) continue; //이것을 꼭해줘야함 dp[i][i]는 의미없는 값임

            if(dp[start][i]<=2){
                ++cnt;
            }
        }
        return cnt;
    }
    static void solve1(){
        N=sc.nextInt();
        adj= new ArrayList[N+1];
        for(int i=1; i<adj.length; ++i){
            adj[i]=new ArrayList<>();
        }
        for(int i=1; i<=N; ++i){
            String s= sc.next();
            for(int j=1; j<=N; ++j){
                if(s.charAt(j-1)=='Y'){
                    adj[i].add(j);
                }
            }
        }

        int ans=-1;
        for(int i=1; i<=N; ++i){
            distance= new int[N+1];
            Arrays.fill(distance,-1);
            ans=Math.max(ans,bfs(i));
        }
        System.out.print(ans);
    }

    static int bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        int cnt=0;
        distance[start]=0;
        q.add(start);
        while(!q.isEmpty()){
            int current=q.poll();
            for(int next : adj[current]){
                if(distance[next]!=-1) continue;
                if(distance[current]+1>2) continue;

                ++cnt;
                distance[next]=distance[current]+1;
                q.add(next);
            }
        }
        return cnt;
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
