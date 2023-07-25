package part5.단기완성알고리즘._09동적프로그래밍;

import java.util.*;
import java.io.*;

/**
 * 완전탐색을 진행하게되면, 조건을 만족하는 한에서 현재를 선택하냐 선택을 안할것이냐 -> 동적프로그래밍의 테이블로 옮긴다.: 선택을 할것이냐 안할것이냐
 * 잘생각해보면 선택하지않는게 연속으로 2번은 올 수 있지만, 연속으로 3번은 올 수 없음(연속으로 3번오는것은 절대 최대가 될수 없으므로) 그래서 절대 xxx 는 나올수 없음
 * 선택을한후에는 선택을 할수 없고, 선택을 안한후에는 선택하기 안하기 둘다 가능 : 이런 논리를 이용해도 XXX는 나올수가 없음(3번조건을 위배하는경우)
 * Rooted tree 를 dp로 해결할경우 dfs 한번으로 가능 ; 시간복잡도 : O(V+E) -> O(N)
 */
public class _07Q1949 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static ArrayList<Integer>[] adj;
    static int N;
    static final int ROOT=1;

    static int[][] d;
    static int[] people;

    public static void main(String[] args){
        input();
        solve1();
        int ans= Math.max(d[ROOT][0],d[ROOT][1]);
        System.out.print(ans);
    }
    static void input(){
        N=sc.nextInt();
        people= new int[N+1];
        for(int i=1; i<=N; ++i){
            people[i]=sc.nextInt();
        }

        adj=new ArrayList[N+1];
        for(int i=1; i<=N; ++i) adj[i] = new ArrayList<>();

        int i=N-1;
        while(i-->0){
            int v1= sc.nextInt();
            int v2= sc.nextInt();
            adj[v1].add(v2);
            adj[v2].add(v1);
        }

        d= new int[N+1][2];
    }

    static void solve1(){
        dfs(ROOT,0);
    }

    static void dfs(int current, int parent){

        for(int next :adj[current]){
            if(next==parent) continue;

            dfs(next,current);
            d[current][1]+=d[next][0];
            d[current][0]+=Math.max(d[next][0],d[next][1]);
        }
        d[current][1]+=people[current]; //자식이 없는 맽끝에서는 이것만 수행됨
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
