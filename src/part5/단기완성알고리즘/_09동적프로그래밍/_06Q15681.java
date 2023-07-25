package part5.단기완성알고리즘._09동적프로그래밍;

import java.util.*;
import java.io.*;

/**
 * 다이내믹 프로그래밍 이라는 기법 자체가. 작은문제를 푼후 그것을 토대로 큰 문제를 해결하는 형태이다.
 * 이러한 형태는 rooted tree 와 아주 이쁜 궁합임.
 *  Rooted tree 문제를 dp로 풀경우 대부분 DFS 한번에 해결이됨. 시간복잡도 ; O(V+E) = O(V + V-1) -> O(N)
 *
 */

public class _06Q15681 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static ArrayList<Integer>[] adj;
    static int N,R,Q;
    static int[] d;
    public static void main(String[] args){
        input();
        solve1();
        int q=Q;
        while(q-->0){
            int query=sc.nextInt();
            sb.append(d[query]).append("\n");
        }
        System.out.print(sb.toString().trim());
    }

    static void input(){
        N=sc.nextInt();
        R=sc.nextInt();
        Q=sc.nextInt();
        adj= new ArrayList[N+1];
        d= new int[N+1];
        for(int i=1; i<=N; ++i){
            adj[i]= new ArrayList<>();
        }
        int i= N-1;
        while(i-->0){
            int v1=sc.nextInt();
            int v2= sc.nextInt();
            adj[v1].add(v2);
            adj[v2].add(v1);
        }
    }

    static void solve1(){
//        dfs(R,0); //880ms
        dfs2(R,0); //700ms : 조금더 효율적인풀이
    }

    static void dfs2(int current, int parent){
        for(int next:adj[current]){
            if(next==parent) continue;

            dfs2(next,current);
            d[current]+=d[next];
        }
        ++d[current];
    }
    static void dfs(int current,int parent){
        if(adj[current].isEmpty()){ //굳이 이 if가 없어도되긴함
            d[current]=1;
            return ;
        }

        for(int next:adj[current]){
            if(next==parent) continue;

            dfs(next,current);
            d[current]+=d[next];
        }
        ++d[current];
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
