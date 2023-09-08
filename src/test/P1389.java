package test;

import java.util.*;
import java.io.*;

/**
 * 플로이드워샬, bfs, 다익스트라
 */

public class P1389 {

    static FastReader sc= new FastReader();
    static int n,m;
    static int[][] arr;
    static ArrayList<Integer>[] adj;
    public static void main(String[] args){
//        solve1();//플로이드워샬
//        solve2();//bfs : 가중치가 1이기때문에 bfs 로 최소비용을 하기 유리
        solve3();//다익스트라
    }

    static void solve3(){
        n=sc.nextInt();
        m=sc.nextInt();
        arr=new int[n+1][n+1];
        adj=new ArrayList[n+1];
        for(int i=1; i<=n; ++i){
            adj[i] = new ArrayList<>();
        }
        while(m-->0){
            int a= sc.nextInt();
            int b= sc.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }
        for(int start=1; start<=n; ++start){
            dijkstra(start);
        }
        System.out.print(findMinPerson());
    }

    static void dijkstra(int start){

        for(int i=1; i<=n; ++i){
            arr[start][i]=10000;
        }
        arr[start][start]=0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));

       pq.add(new Edge(start,0));

        while(!pq.isEmpty()){
            Edge e=pq.poll();
            int now=e.node;
            int sumCost=e.cost;

            if(sumCost>arr[start][now]) continue;
            for(int canGo:adj[now]){
                int newCanGoCost=arr[start][now]+1;

                if(arr[start][canGo]>newCanGoCost) {
                    arr[start][canGo]=newCanGoCost;
                    pq.add(new Edge(canGo,newCanGoCost));
                }
            }
        }
    }

    static class Edge{
        int node;
        int cost;
        Edge(int node, int cost){
            this.node= node;
            this.cost= cost;
        }
    }
    static void solve2(){
        n=sc.nextInt();
        m=sc.nextInt();
        arr=new int[n+1][n+1];
        adj= new ArrayList[n+1];
        for(int i=1; i<=n; ++i){
            adj[i] = new ArrayList<>();
        }
        while(m-->0){
            int a= sc.nextInt();
            int b= sc.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }

        for(int start=1; start<=n; ++start){
            bfs(start);
        }

        System.out.print(findMinPerson());
    }

    static void bfs(int start){
        boolean[] visited=new boolean[n+1];

        Queue<Integer> q= new LinkedList<>();
        q.add(start);
        visited[start]=true;

        while(!q.isEmpty()){
            int node= q.poll();
            for(int next: adj[node]){
                if(visited[next]) continue;

                visited[next]=true;
                arr[start][next]=arr[start][node]+1;
                q.add(next);
            }
        }
    }

    static void input1(){
        n=sc.nextInt();
        m=sc.nextInt();
        arr= new int[n+1][n+1];
        init(arr);

        while(m-->0){
            int a=sc.nextInt();
            int b= sc.nextInt();

            arr[a][b]=1;
            arr[b][a]=1;
        }
    }
    static int findMinPerson(){

        int sum=-1;
        int mnSum=Integer.MAX_VALUE;
        int mnPerson=-1;
        for(int i=1; i<=n; ++i){
            sum=0;
            for(int j=1; j<=n; ++j){
                sum+=arr[i][j];
            }
            if(mnSum>sum){
                mnSum=sum;
                mnPerson=i;
            }
        }
        return mnPerson;
    }


    static void solve1(){
        input1();
        for(int k=1;k<=n; ++k){
            for(int i=1; i<=n; ++i){
                for(int j=1; j<=n; ++j){
                    arr[i][j]=Math.min(arr[i][j],arr[i][k]+arr[k][j]);
                }
            }
        }

        int person = findMinPerson();
        System.out.print(person);
    }

    static void init(int[][] arr){
        for(int i=1; i<arr.length; ++i){
            for(int j=1; j<arr[i].length; ++j){
                arr[i][j]=100000;
            }
        }
        for(int i=1; i<arr.length; ++i){
            arr[i][i]=0;
        }
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
                    st=new StringTokenizer(br.readLine());
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
