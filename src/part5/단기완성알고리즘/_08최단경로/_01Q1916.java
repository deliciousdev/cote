package part5.단기완성알고리즘._08최단경로;

import java.util.*;
import java.io.*;

/**
 * 최단거리를 구하는 알고리즘들은 각각 장단점이 있으므로 숙지 하고 적절히 사용해야함
 * 대표적으로 6가지가 있고, 코테에서는 BFS, 다익스트라 정도만 알면됨
 * BFS
 * 간선가중치 :양수 1 , O(V+E)
 *
 * 다익스트라
 * 간선가중치 : 양수 , O(ElogV)
 * BFS가 다익스트라보다 더 빠름.
 *
 * 다익스트라에서 음수 간선이 있으면 첫번째 최단거리 방문이후 갱신이 되는 가능성이 있으므로 시간복잡도가 보장이 안됨.
 *
 * 한곳을 여러번 반복한것이 최소경로가 되기위해서는 사이클이 이득이 있어야하는데, 그러기 위해서는 사이클의 총 비용이 음수이어야함.
 * 애초에 이런경우는 사이클을 계속 돌면 비용이 작아지므로 최단거리 개념이 없음
 * 하지만 애초에 전제조건이 양수이므로, 이럴때는 최소비용을 구하는데 있어서 한정점에 대해서 한번만 방문함.
 * 결론적으로 각 정점들은 한번씩만 방문하므로, ans 의 최대상한값을 구하는 근거가됨
 */
public class _01Q1916 {

    static FastReader sc= new FastReader();
    static StringBuilder sdb= new StringBuilder();

    static int N;
    static int M;

    static int[] dist;
    static ArrayList<Data>[] adj;
    static int start,dest;
    public static void main(String[] args){
        input();
        solve1();
        System.out.print(dist[dest]);
    }

    static void input(){
        N=sc.nextInt();
        M=sc.nextInt();
        dist= new int[N+1];
        adj= new ArrayList[N+1];
        for(int i=1; i<=N; ++i){
            adj[i]= new ArrayList<>();
        }
        Arrays.fill(dist,-1);
        int m= M;
        while(m-->0){
            int from =sc.nextInt();
            int to = sc.nextInt();
            int cost= sc.nextInt();
            adj[from].add(new Data(to,cost));
        }
        start= sc.nextInt();
        dest= sc.nextInt();
    }
    static void solve1(){

        PriorityQueue<Data> pq = new PriorityQueue<>((d1,d2)->Integer.compare(d1.cost,d2.cost));

        pq.add(new Data(start,0));

        //모범답안이랑 비교해서 봐볼것 : dist를 갱신하는 위치 , 최소힙 등
        while(!pq.isEmpty()){
            Data d =pq.poll();
            int to= d.to;
            int cost = d.cost;
            if(dist[to]!=-1) continue;

            dist[to]=cost;
            for(Data e : adj[to]){
                if(dist[e.to]!=-1) continue;
                pq.add(new Data(e.to,e.cost+dist[to]));
            }
        }
    }

    static class Data{
        int to;
        int cost;
        Data(int to, int cost){
            this.to=to;
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
