package test;


import java.util.*;
import java.io.*;

/**
 * 최소스패닝 트리 :
 * 크루스칼 알고리즘 , union and find : 회로없이 가장 작은 가중치의 간선을 n-1개 선택 : 간선을 추가해나감
 *
 * 프림 알고리즘 : 임의의 시작점을 선택하고 점점 정복해나아감 : 간선의 후보중 가중치가 가장 작은 간선을 선택해가면서 정점을 정복하고(이미 정복된 정점이면 무시함),
 * 정복한 정점에 간선들을 다음에 갈 후보로 넣어둠 : 정점을 추가해나감
 *
 * union, find 구현은 확실히 숙지하자...
 *
 * PriorityQueue 나 treeSet 를 개념적으로 배열처럼 생겼다고 봐도됨. (정렬후 어떤게 제일 먼저 나오게될지를 생각해볼때)
 */
public class P1197 {


    static FastReader sc= new FastReader();

    static int v,e;
    static int[] parentOf;

    static Edge[] edges;

    public static void main(String[] args){
//        solve1();//크루스칼
        solve2();//프림 : pq
//        solve3(); //프림 : treeSet : 왜 npe 뜨는질 몰겠네...
    }

    static void solve3(){
        v= sc.nextInt();
        e= sc.nextInt();
        ArrayList<Edge>[] adj = new ArrayList[v+1];
        for(int i=1; i<=v; ++i){
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<e; ++i){
            int v1= sc.nextInt();
            int v2 = sc.nextInt();
            int cost= sc.nextInt();
            adj[v1].add(new Edge(v1,v2,cost));
            adj[v2].add(new Edge(v2,v1,cost));
        }

        TreeSet<Edge> ts = new TreeSet<>(Comparator.comparingInt(e2 -> e2.cost));

        boolean[] selected= new boolean[v+1];

        selected[1]=true;
        ts.addAll(adj[1]);
        int cnt=1;
        int sum=0;
        while(cnt<v){
            Edge e = ts.pollFirst();
            int nextNode=e.to;
            if(selected[nextNode]) continue;

            selected[nextNode]=true;
            ts.addAll(adj[nextNode]);
            sum+=e.cost;
            ++cnt;
        }
        System.out.print(sum);
    }
    static void solve2(){
        v= sc.nextInt();
        e= sc.nextInt();
        ArrayList<Edge>[] adj = new ArrayList[v+1];
        for(int i=1; i<=v; ++i){
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<e; ++i){
            int v1= sc.nextInt();
            int v2 = sc.nextInt();
            int cost= sc.nextInt();
            adj[v1].add(new Edge(v1,v2,cost));
            adj[v2].add(new Edge(v2,v1,cost));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e2 -> e2.cost));

        boolean[] selected= new boolean[v+1];

        selected[1]=true;
        pq.addAll(adj[1]);
        int cnt=1;
        int sum=0;
        while(cnt<v){
            Edge e = pq.poll();
            int nextNode=e.to;
            if(selected[nextNode]) continue;

            selected[nextNode]=true;
            pq.addAll(adj[nextNode]);
            sum+=e.cost;
            ++cnt;
        }
        System.out.print(sum);
    }

    static void solve1(){
        input1();

        Arrays.sort(edges, Comparator.comparingInt(e -> e.cost));

        long sum=0;
        int cnt=0;
        for(int i=0; i<edges.length; ++i){
            Edge e= edges[i];
            if(find(e.from)==find(e.to)) continue;

            union(e.from,e.to);
            sum+=e.cost;

            ++cnt;
            if(cnt==v-1) break;
        }

        System.out.print(sum);
    }

    private static void input1() {
        v=sc.nextInt();
        e= sc.nextInt();
        edges = new Edge[e];

        for(int i=0; i<edges.length; ++i){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost= sc.nextInt();
            edges[i]= new Edge(from,to,cost);
        }

        parentOf= new int[v+1];
        for(int i=1; i<=v; ++i){
            parentOf[i]=i;
        }
    }

    static int find(int a){
        if(parentOf[a]==a) return a;

        return parentOf[a]= find(parentOf[a]);
    }

    static void union(int a, int b){
//        if(parentOf[a]!=parentOf[b]){
//            parentOf[a]=b;
//        }

        a= find(a);
        b= find(b);
        if(a!=b) parentOf[b]=a;
    }

    static class Edge{
        int from;
        int to;
        int cost;
        Edge(int from, int to, int cost){
            this.from=from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public boolean equals(Object o) {
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to, cost);
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
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
