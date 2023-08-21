package test;

import java.util.*;
import java.io.*;

/**
 * 플로이드 워셜은 n^3 이라서 안해봄
 */
public class P1240 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int n,m;
    static int distance;
    static boolean[] visited;

    static int start;
    static int desti;
    static boolean find;
    static ArrayList<Edge>[] adj;
    public static void main(String[] args){
        solve1();//dfs
//        solve2();//bfs
//        solve3();//dfs without visited
//        solve4();//bfs without visited
    }

    static void solve1(){
        input();

        while(m-->0){
            start= sc.nextInt();
            desti= sc.nextInt();
            distance=0;
            visited= new boolean[n+1];
            visited[start]=true;
            find=false;
            calcDistanceByDfs(start,0);
            sb.append(distance).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static void input() {
        n= sc.nextInt();
        m= sc.nextInt();
        adj= new ArrayList[n+1];
        for(int i=1; i<=n; ++i){
            adj[i]= new ArrayList<>();
        }
        for(int i=1; i<=n-1; ++i){
            int node1 = sc.nextInt();
            int node2= sc.nextInt();
            int cost= sc.nextInt();
            adj[node1].add(new Edge(node2,cost));
            adj[node2].add(new Edge(node1,cost));
        }
    }

    static void solve2(){
        input();

        while(m-->0){
            start= sc.nextInt();
            desti= sc.nextInt();
            int distance=calcDistanceByBfs(start,desti);
            sb.append(distance).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void solve3(){
        input();

        while(m-->0){
            start= sc.nextInt();
            desti= sc.nextInt();
            distance=0;
            find=false;
            calcDistanceByDfs(start,0,-1);
            sb.append(distance).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void solve4(){
        input();

        while(m-->0){
            start= sc.nextInt();
            desti= sc.nextInt();

            int distance=calcDistanceByBfs2(start,desti);
            sb.append(distance).append("\n");
        }
        System.out.print(sb.toString());
    }
    static void calcDistanceByDfs(int current, int sum, int prev){
        if(current==desti){
            distance=sum;
            find=true;
            return;
        }

        for(Edge e: adj[current]){
            int next= e.to;
            int cost= e.cost;
            if(next==prev || find) continue;

            calcDistanceByDfs(next,sum+cost,current);
        }
    }


    static int calcDistanceByBfs(int start, int desti){
        visited = new boolean[n+1];

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        q.add(0);
        visited[start]=true;

        while(!q.isEmpty()){
            int currentNode=q.poll();
            int sum= q.poll();
            for(Edge e: adj[currentNode]){
                int to = e.to;
                int cost= e.cost;
                if(visited[to]) continue;

                if(to==desti){
                    return sum+cost;
                }
                visited[to]=true;
                q.add(to);
                q.add(sum+cost);
            }
        }
        return -1;
    }


    static int calcDistanceByBfs2(int start, int desti){

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        q.add(0);
        q.add(-1);

        while(!q.isEmpty()){
            int currentNode=q.poll();
            int sum= q.poll();
            int prev= q.poll();
            for(Edge e: adj[currentNode]){
                int to = e.to;
                int cost= e.cost;

                if(to==desti){
                    return sum+cost;
                }
                if(to==prev) continue;

                q.add(to);
                q.add(sum+cost);
                q.add(currentNode);
            }
        }
        return -1;
    }

    static void calcDistanceByDfs(int node,int sum){
        if(node==desti){
            distance=sum;
            find=true;
            return;
        }

        for(Edge e : adj[node]){
            int next= e.to;
            int cost= e.cost;

            if(find || visited[next]) continue;

            visited[next]=true;
            calcDistanceByDfs(next,sum+cost);
            visited[next]=false;
        }
    }

    static class Edge{
        int to;
        int cost;
        Edge(int to, int cost){
            this.to = to;
            this.cost= cost;
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
                try {
                    st = new StringTokenizer(br.readLine());
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
