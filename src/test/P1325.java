package test;


import java.util.*;
import java.io.*;

public class P1325 {

    static FastReader sc = new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int n,m;
    static ArrayList<Integer>[] adj;
    static ArrayList<Integer> result;
    static int mxCnt =Integer.MIN_VALUE;
    static int[] count;
    static int cnt;
    static boolean[] visited;
    static boolean[] visitedInOtherGroup;


    public static void main(String[] args) {
//        solve1(); //당연 시간초과 : O( V(V+E))
//        solve2(); //사이클이문제가됨.... https://www.acmicpc.net/board/view/60970
//        solve3();//dfs 인데 시간초과 : 그룹수 카운팅
//        solve4();//bfs 시간 초과 : 그룹수 카운팅
//        solve5();//dfs 신뢰받는수 카운팅 : 머냐 이건 왜 되냐? https://www.acmicpc.net/board/view/123040
        solve6();//bfs 신뢰받는수 카운팅 : 이것도 되네...
    }

    static void solve6(){
        input6();

        for(int i=1; i<=n; ++i){
            visited = new boolean[n+1];
            bfs6(i,visited);
        }
        printResult();
    }

    static void bfs6(int start,boolean[] visited){
        visited[start]=true;

        Queue<Integer> q= new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int node= q.poll();
            for(int next: adj[node]){
                if(visited[next]) continue;

                visited[next]=true;
                ++count[next];
                q.add(next);
            }
        }
    }
    static void input6(){
        input5();
    }

    static void solve5(){
        input5();

        for(int i=1; i<=n; ++i){
            visited= new boolean[n+1];

            visited[i]=true;
            dfs5(i);
        }
        printResult();
    }

    static void dfs5(int node){

        for(int next:adj[node]){
            if(visited[next]) continue;

            visited[next]=true;
            ++count[next];
            dfs5(next);
        }
    }

    static void printResult(){
        int mxCnt=-1;
        for(int i=1; i<=n; ++i){
            if(mxCnt<count[i]){
                mxCnt=count[i];
                sb.setLength(0);
                sb.append(i).append(" ");
            }
            else if(mxCnt==count[i]){
                sb.append(i).append(" ");
            }
        }
        System.out.print(sb.toString());
    }



    static void input5(){
        n=sc.nextInt();
        m= sc.nextInt();
        adj= new ArrayList[n+1];
        for(int i=1; i<=n; ++i){
            adj[i]=new ArrayList<>();
        }
        for(int i=1; i<=m; ++i){
            int from= sc.nextInt();
            int to = sc.nextInt();
            adj[from].add(to);
        }

        count=new int[n+1];
    }

    static void input4(){
        input3();
    }
    static void solve4(){
        input4();
        for(int i=1; i<=n; ++i){
            visited=new boolean[n+1];
            if(visitedInOtherGroup[i]) continue;

            visitedInOtherGroup[i]=true;
            int cnt=bfs(i,visited);
            if(cnt>mxCnt){
                mxCnt=cnt;
                result.clear();
                result.add(i);
            }
            else if(cnt==mxCnt){
                result.add(i);
            }
        }

        print();
    }

    static int bfs(int start, boolean[] visited){
        int cnt=1;
        visited[start]=true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int node= q.poll();
            for(int next:adj[node]){
                if(visited[next]) continue;

                ++cnt;
                visited[next]=true;
                visitedInOtherGroup[next]=true;
                q.add(next);
            }
        }
        return cnt;
    }

    static void solve3(){
        input3();

        for(int i=1; i<=n; ++i){
            visited=new boolean[n+1];
            if(visitedInOtherGroup[i]) continue;

            visitedInOtherGroup[i]=true;
            visited[i]=true;
            cnt=1;
            dfs3(i);
            if(cnt>mxCnt){
                mxCnt=cnt;
                result.clear();
                result.add(i);
            }
            else if(cnt==mxCnt){
                result.add(i);
            }
        }

        print();
    }
    static void dfs3(int node){

        for(int next:adj[node]){
            if(visited[next]) continue;

            visited[next]=true;
            visitedInOtherGroup[next]=true;
            ++cnt;
            dfs3(next);
        }
    }

    static void input2(){
        input();
    }
    static void solve2(){
        input2();
        visited= new boolean[n+1];
        for(int i=1; i<=n; ++i){
            if(visited[i]) continue;

            visited[i]=true;
            count[i]=1;
            dfs2(i);
        }
        print();
    }
    static void dfs2(int node){

        for(int next: adj[node]){
            if(visited[next]){
                count[node]+=count[next];
            }
            else{
                visited[next]=true;
                count[next]=1;

                dfs2(next);
                count[node]+=count[next];
            }
        }

        if(mxCnt<count[node]){
            mxCnt=count[node];
            result.clear();
            result.add(node);
        }
        else if(mxCnt==count[node]){
            result.add(node);
        }
    }

    static void solve1(){
        input();

        for(int i=1; i<=n; ++i){
            visited= new boolean[n+1];
            cnt=0;

            visited[i]=true;
            ++cnt;
            dfs(i);
            if(cnt> mxCnt){
                mxCnt=cnt;
                result.clear();
                result.add(i);
            }
            else if( cnt==mxCnt){
                result.add(i);
            }
        }

        print();

    }

    private static void print() {
//        Collections.sort(result);
        for(int e: result){
            sb.append(e).append(" ");
        }
        System.out.print(sb.toString());
    }

    static void dfs(int node){
        for(int next: adj[node]){
            if(visited[next]) continue;

            ++cnt;
            visited[next]=true;
            dfs(next);
            visited[next]=false;
        }
    }

    private static void input() {
        n=sc.nextInt();
        m=sc.nextInt();
        result= new ArrayList<>();
        count=new int[n+1];

        adj= new ArrayList[n+1];
        for(int i=1; i<=n; ++i){
            adj[i]=new ArrayList<>();
        }
        for(int i=1; i<=m; ++i){
            int to= sc.nextInt();
            int from = sc.nextInt();
            adj[from].add(to);
        }
    }

    private static void input3() {
        n=sc.nextInt();
        m=sc.nextInt();
        result= new ArrayList<>();
        count=new int[n+1];

        adj= new ArrayList[n+1];
        for(int i=1; i<=n; ++i){
            adj[i]=new ArrayList<>();
        }

        for(int i=1; i<=m; ++i){
            int to= sc.nextInt();
            int from = sc.nextInt();
            adj[from].add(to);
        }
        visitedInOtherGroup =new boolean[n+1];
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
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
