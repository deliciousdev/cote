package test;

import java.util.*;
import java.io.*;

public class P1303 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int n,m;
    static char[][] arr;

    public static void main(String[] args){
//        solve1();//bfs : 전체좌표를 2번 돌림
//        solve2();//bfs : 전체좌표를 1번돌림
        solve3();//dfs : 전체 좌표를 1번 돌림
    }

    static void solve3(){
        input();
        int[][] d={
                {-1,0},{0,1},{1,0},{0,-1}
        };
        boolean[][] visited= new boolean[n][m];
        Force answer = new Force();
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                if(visited[i][j]) continue;

                ++answer.cnt;
                visited[i][j]=true;
                dfs(i,j,visited,answer,d,arr[i][j]);
                answer.addForce(arr[i][j],answer.cnt);
            }
        }
        sb.append(answer.ourForce).append(" ").append(answer.enemyForce);
        System.out.print(sb.toString());
    }

    static void dfs(int row, int col, boolean[][] visited, Force answer,int[][] d,char color){

        for(int i=0; i<d.length; ++i){
            int nr = row+d[i][0];
            int nc= col+d[i][1];
            if(nr<0 || nr>n-1 || nc<0 || nc>m-1) continue;
            if(visited[nr][nc]) continue;
            if(arr[nr][nc]!=color) continue;

            ++answer.cnt;
            visited[nr][nc]=true;
            dfs(nr,nc,visited,answer,d,color);
        }

    }
    static void solve2(){
        input();
        boolean[][] visited= new boolean[n][m];
        Force answer = new Force();
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                if(visited[i][j]) continue;

                visited[i][j] = true;
                bfs(i,j,answer,visited);
            }
        }
        sb.append(answer.ourForce).append(" ").append(answer.enemyForce);
        System.out.print(sb.toString());
    }

    static void bfs(int startR, int startC, Force answer, boolean[][] visited){
        int[][] d= {
                {-1,0},{0,1},{1,0},{0,-1}
        };
        char color = arr[startR][startC];

        Queue<Integer> q = new LinkedList<>();
        int cnt=1;
        q.add(startR);
        q.add(startC);
        while(!q.isEmpty()){
            int r= q.poll();
            int c= q.poll();
            for(int i=0; i<d.length; ++i){
                int nr= r+d[i][0];
                int nc= c+d[i][1];
                if(nr<0 || nr>n-1 || nc<0 || nc>m-1) continue;
                if(visited[nr][nc]) continue;
                if(arr[nr][nc]!=color) continue;

                ++cnt;
                visited[nr][nc]=true;
                q.add(nr);
                q.add(nc);
            }
        }
        answer.addForce(color,cnt);
    }
    static class Force{
        int ourForce;
        int enemyForce;

        int cnt;

        void addForce(char color, int cnt){
            this.cnt=0;
            if(color=='W'){
                ourForce+=cnt*cnt;
                return;
            }
            enemyForce+=cnt*cnt;
        }
    }

    static void solve1(){
        input();

        int ourForce =calcForceByBfs('W');
        int enemyForce= calcForceByBfs('B');
        sb.append(ourForce).append(" ").append(enemyForce);
        System.out.print(sb.toString());
    }

    private static void input() {
        m=sc.nextInt();
        n= sc.nextInt();
        arr= new char[n][m];
        for(int i=0; i<n; ++i){
            arr[i]= sc.next().toCharArray();
        }
    }

    static int calcForceByBfs(char color){

        int[][] d= {
                {-1,0},{0,1},{1,0},{0,-1}
        };
        Queue<Integer> q= new LinkedList();

        boolean[][] visited= new boolean[n][m];

        int power =0;
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){

                if(arr[i][j]==color && !visited[i][j]){
                    int cnt=1;
                    visited[i][j]=true;
                    q.add(i);
                    q.add(j);
                    while(!q.isEmpty()){
                        int r= q.poll();
                        int c= q.poll();
                        for(int k=0; k<d.length; ++k){
                            int nr= r+d[k][0];
                            int nc= c+d[k][1];
                            if(nr<0 || nr>n-1 || nc<0 || nc>m-1) continue;
                            if(visited[nr][nc]) continue;
                            if(arr[nr][nc]!=color) continue;

                            ++cnt;
                            visited[nr][nc]=true;
                            q.add(nr);
                            q.add(nc);
                        }
                    }
                    power+=cnt*cnt;
                }
            }
        }
        return power;
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while (st == null || !st.hasMoreElements()) {

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
