package part5.단기완성알고리즘._06트리;

/**
 *
 * 트리의 조건 :
 * 1.임의의 점에서 어디로든 이동 가능해야함     2.사이클이 존재하지않음       3.정점개수=간선개수+1
 * 3개의 조건중 2개 이상을 만족하면 트리임.
 *
 * 트리 문제의 키워드
 * "모든 두 정점 사이에 이들을 잇는 경로가 존재하면서 (1번조건)사이클이 존재하지 않는 경우만 고려한다(2번조건)."
 * "마을과 마을 사이를 직접 잇는 N-1개의 길이 있으며(3번조건), 모든 마을은 연결되어 있다(1번조건)."
 * "일반 적인 그래프가 아니라 트리(연결되어 있고, 사이클이 없는 그래프) : 문제에서 트리라고 명시를 해줌"
 * 이러한 구절들을 보면 트리라는것을 떠올려야함
 *
 * 트리는 대부분 인접행렬이 아니라 인접리스트로 데이터를 저장하게됨. 공간복잡도 면에서 인접행렬보다 인접리스트가 유리함
 * DFS 이든 BFS 이든 인접리스트를 사용한다면 시간복잡도 : (V+E)
 * 트리는 대부분 DFS 가 더 적합함
 */

import java.util.*;
import java.io.*;

public class _01Q11725 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N;
    static ArrayList<Integer>[] adjList;
    static int[] parent;

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        N=sc.nextInt();
        adjList= new ArrayList[N+1];
        for(int i=1; i<=N; ++i){
            adjList[i]=new ArrayList<>();
        }

        parent= new int[N+1];

        for(int i=1; i<=N-1; ++i){
            int temp1=sc.nextInt();
            int temp2= sc.nextInt();
            adjList[temp1].add(temp2);
            adjList[temp2].add(temp1);
        }

        dfs(1,-1);

        for(int i=2; i<=N; ++i){
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb.toString().trim());
    }

    static void dfs(int currentNode,int parentNode){
        for(int e: adjList[currentNode]){
            if(e==parentNode) continue;
            parent[e]=currentNode;
            dfs(e,currentNode);
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
