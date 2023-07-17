package part5.단기완성알고리즘._05그래프와탐색;

import java.util.*;
import java.io.*;

public class _01Q1260 {

    static FastReader sc = new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N,M,V;

    static int[][] adjArr;

    static boolean[] visit;

    static ArrayList<Integer>[] adjList;

    public static void main(String[] args){

//        solve1();//인접 행렬
        solve2();//인접리스트 : 인접리스트에서 작은순으로 탐색 하기 위해서는 정렬이 필요함
    }

    static void solve1(){
        N=sc.nextInt();
        M=sc.nextInt();
        V=sc.nextInt();

        adjArr =new int[N+1][N+1];
        int m=M;
        while(m-->0){
            int v1= sc.nextInt();
            int v2= sc.nextInt();
            adjArr[v1][v2]=1;
            adjArr[v2][v1]=1;
        }

        visit= new boolean[N+1];

        visit[V]=true;
        dfs(V); //방문하기전 visit 체크

//        dfs2(V); //방문 한후 visit 체크
        sb.append("\n");

        Arrays.fill(visit,false);

        visit[V]=true;
        bfs(V);
        System.out.print(sb.toString());
    }

    static void solve2(){
        N=sc.nextInt();
        M=sc.nextInt();
        V=sc.nextInt();

        adjList = new ArrayList[N+1];
        for(int i=1; i<=N; ++i){
            adjList[i]=new ArrayList<Integer>();
        }
        int m= M;
        while(m-->0){
            int v1= sc.nextInt();
            int v2= sc.nextInt();
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }



        for(int i=1; i<=N; ++i){
            Collections.sort(adjList[i]);
        }

        visit= new boolean[N+1];

        visit[V]=true;
        listDfs(V);
        sb.append("\n");

        Arrays.fill(visit,false);
        listBfs(V);
        System.out.print(sb.toString());
    }

    static void listDfs(int currentNode){
        sb.append(currentNode).append(" ");

        /*for(int i=0; i<adjList[currentNode].size(); ++i){
            int nextNode= adjList[currentNode].get(i);
            if(visit[nextNode]) continue;

            visit[nextNode]=true;
            listDfs(nextNode);
        }*/
        for(int nextNode : adjList[currentNode]){
            if(visit[nextNode]) continue;

            visit[nextNode]=true;
            listDfs(nextNode);
        }
    }

    static void listBfs(int startNode){

        Queue<Integer> q = new LinkedList();

        visit[startNode]=true;
        q.add(startNode);

        while(!q.isEmpty()){
            int currentNode= q.poll();
            sb.append(currentNode).append(" ");

            /*for(int i=0; i<adjList[currentNode].size(); ++i){
                int next= adjList[currentNode].get(i);
                if(visit[next]) continue;

                visit[next]=true;
                q.add(next);
            }*/

            for(int next : adjList[currentNode]){
                if(visit[next]) continue;

                visit[next]=true;
                q.add(next);
            }
        }
    }
    static void bfs(int startNode){

        Queue<Integer> q = new LinkedList<>();

        visit[startNode]=true;
        q.add(startNode);

        while (!q.isEmpty()) {
            int currentNode= q.poll();
            sb.append(currentNode).append(" ");

            for(int i = 1; i< adjArr[currentNode].length; ++i){
                if(adjArr[currentNode][i]==0 || visit[i]) continue;

                visit[i]=true;
                q.add(i);
            }
        }
    }

    static void dfs(int currentNode){

        sb.append(currentNode).append(" ");

        for(int next = 1; next< adjArr[currentNode].length; ++next){
            if(adjArr[currentNode][next]==0 || visit[next]) continue;

            visit[next]=true;
            dfs(next);
        }
    }

    static void dfs2(int currentNode){
        visit[currentNode]=true;

        sb.append(currentNode).append(" ");
        for(int next = 1; next< adjArr[currentNode].length; ++next){
            if(adjArr[currentNode][next]==0 || visit[next]) continue;

            dfs2(next);
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
            String str= "";
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
