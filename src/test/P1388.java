package test;

import java.util.*;
import java.io.*;

/**
 * 전통적인 탐새 bfs dfs 문제
 */
public class P1388 {

    static FastReader sc= new FastReader();

    static int N,M;
    static char[][] arr;
    static boolean[][] visited;
    public static void main(String[] args){
        solve1();
    }

    public static void solve1(){
        N=sc.nextInt();
        M=sc.nextInt();
        arr= new char[N][M];
        visited=new boolean[N][M];
        for(int i=0; i<arr.length; ++i){
            arr[i]=sc.next().toCharArray();
        }

        int ans= bfs();
        System.out.print(ans);
    }

    static int bfs(){
        Queue<Integer> q= new LinkedList<>();

        int[][] d={
                {-1,0},
                {0,1},
                {1,0},
                {0,-1}
        };

        int cnt=0;
        for(int i=0; i<N; ++i){
            for(int j=0; j<M; ++j){
                if(visited[i][j]) continue;

                visited[i][j]=true;
                q.add(i);
                q.add(j);
                ++cnt;
                while(!q.isEmpty()){
                    int r=q.poll();
                    int c= q.poll();

                    int k= arr[r][c]=='|'? 0 :1;
                    for(; k<d.length; k+=2){
                        int nextR=r+d[k][0];
                        int nextC=c+d[k][1];
                        if(nextR<0 || nextR>N-1 || nextC<0 || nextC>M-1) continue;
                        if(visited[nextR][nextC]) continue;
                        if(arr[r][c]!=arr[nextR][nextC]) continue;

                        visited[nextR][nextC]=true;
                        q.add(nextR);
                        q.add(nextC);
                    }
                }
            }
        }
        return cnt;
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
