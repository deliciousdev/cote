package part5.단기완성알고리즘._07위상정렬;

import java.util.*;
import java.io.*;

/**
 * 위상 정렬 : Topological Sort
 * Directed Acyclic Graph (DAG)
 * Directed : 방향성이 있음
 * Acyclic : 사이클이 없다
 * Graph : 정점 + 간선
 * 방향그래프에서 degree -> indegree / outdegree
 *
 * 위상정렬이란 DAG 에 대해서만 가능함
 * 위상에 맞게 정렬 한다 == 간선의 방향을 토대로 정렬을함(to 가 from 보다 먼저 오도록 정렬을 함) : to-from 개념이 없어 지기 때문에 사이클이 있다면 위상정렬을 할 수가 없음
 * 정렬된순서에서 첫번째로 올 정점은 indegree 가 0 이어야함.
 *
 */
public class _01Q2252 {


    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();
    static int N,M;

    static ArrayList<Integer>[] adj;
    static int[] inDegree;

    public static void main(String[] args){
        solve1();
        System.out.print(sb.toString().trim());
    }

    static void solve1(){
        input();

        Deque<Integer> dq = new LinkedList();


        //시간복잡도 V
        for(int i=1; i<inDegree.length; ++i){
            if(inDegree[i]==0) {
                dq.add(i);
            }
        }

        //시간복잡도 E
        while(!dq.isEmpty()){
            int node= dq.poll();
            sb.append(node).append(" ");
            for(int e: adj[node]){
                --inDegree[e];
                if(inDegree[e]==0){
                    dq.add(e);
                }
            }
        }
    }

    private static void input() {
        N= sc.nextInt();
        M=sc.nextInt();
        adj=new ArrayList[N+1];
        for(int i=1; i<=N; ++i){
            adj[i]=new ArrayList<>();
        }
        inDegree = new int[N+1];

        int m= M;
        while(m-->0){
            int previous= sc.nextInt();
            int next= sc.nextInt();
            adj[previous].add(next);
            ++inDegree[next];
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
