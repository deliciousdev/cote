package test;

import java.util.*;
import java.io.*;


/**
 * bfs, union and find ;disjoint set 을 구현할때 union and find 를 사용하고 경로압축도 사용함
 */
public class P1043 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N,M;
    static ArrayList<Integer>[] adj;

    static boolean[] visited;
    static int[] truePerson;
    static ArrayList<Integer>[] party;


    static int[] parentOf;
    public static void main(String[] args){
//        solve1();//bfs
        solve2();//union and find
    }

    static void solve2(){
        N=sc.nextInt();
        M=sc.nextInt();
        parentOf= new int[N+1];
        for(int i=1; i<=N; ++i){
            parentOf[i]=i;
        }

        int trueManSize=sc.nextInt();
        for(int i=1; i<=trueManSize; ++i){
            merge(0,sc.nextInt());
        }

        party= new ArrayList[M];
        for(int i=0; i<M; ++i){
            party[i]=new ArrayList<>();
        }
        for(int i=0; i<party.length; ++i){
            int partySize=sc.nextInt();
            for(int j=1; j<=partySize; ++j){
                party[i].add(sc.nextInt());
            }
        }

        for(int i=0; i<party.length; ++i){
            if(party[i].size()>1){
                for(int j=0; j<party[i].size(); ++j){
                    merge(party[i].get(0),party[i].get(j));
                }
            }
        }

        int cnt=0;
        for(int i=0; i<party.length; ++i){
            boolean haveTrueMan=false;
            for(int j=0; j<party[i].size(); ++j){
                if(find(party[i].get(j))==find(0)){ //find(0)이 아니라 ==0 혹은 ==parentOf[0] 으로 하면 안됨
                    haveTrueMan=true;
                    break;
                }
            }
            if(!haveTrueMan) ++cnt;
        }
        System.out.print(cnt);
    }

    static int find(int x){
        if(parentOf[x]==x) return x;
        return parentOf[x]=find(parentOf[x]);
    }

    static void merge(int a, int b){
        a=find(a);
        b= find(b);
        if(a!=b) parentOf[a]=b;
    }

    private static void solve1() {
        N=sc.nextInt();
        M=sc.nextInt();
        party= new ArrayList[M];
        for(int i=0; i<M; ++i){
            party[i]= new ArrayList<>();
        }

        adj= new ArrayList[N+1];
        for(int i=1; i<=N; ++i){
            adj[i] = new ArrayList<>();
        }

        int truePersonSize=sc.nextInt();
        truePerson = new int[truePersonSize+1];
        for(int i=1; i<truePerson.length; ++i){
            truePerson[i]=sc.nextInt();
        }


        for(int i=0; i<M; ++i){
            int partySize= sc.nextInt();
            int temp=partySize;
            while(temp-->0){//여기서 temp 대신 partySize로 하면 아래에서 partySize 사용하기 때문에 안됨
                party[i].add(sc.nextInt());
            }
            for(int j=0; j<partySize; ++j){
                for(int k=0; k<partySize; ++k){
                    if(j==k) continue;
                    adj[party[i].get(j)].add(party[i].get(k));
                }
            }
        }


        visited= new boolean[N+1];
        bfs();

        int cnt=0;

        for(int i=0; i<party.length; ++i){
            boolean hasVisited=false;
            for(int e: party[i]){
                if(visited[e]){
                    hasVisited=true;
                    break;
                }
            }
            if(!hasVisited) ++cnt;
        }
        System.out.print(cnt);
    }

    static void bfs(){

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<truePerson.length; ++i){
            visited[truePerson[i]]=true;
            q.add(truePerson[i]);
        }

        while(!q.isEmpty()){
            int next = q.poll();
            for(int e : adj[next]){
                if(visited[e]) continue;

                visited[e]=true;
                q.add(e);
            }
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
