package test;

import java.util.*;
import java.io.*;

/**
 * bfs,dfs 인데 조금은 생각해야하는 : bfs가 더 간단함 dfs 일때는 생각할게 좀 있음
 */
public class P1245 {

    static FastReader sc = new FastReader();

    static int n, m;

    static int[][] map;

    static int[][] isPeak; // 1: 확실히 봉우리 , -1: 확실히 봉우리아님 , 0 : 아직 탐색 안함



    public static void main(String[] args) {
//        solve1();//bfs
//        solve2();//bfs
        solve3();//dfs
    }

    static void solve3(){
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        isPeak = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                map[i][j] = sc.nextInt();
            }
        }

        int[][] d= {
                {-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},
        };
        int cnt=0;
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                if(isPeak[i][j]==1 || isPeak[i][j]==-1) continue;

                boolean[][] visited= new boolean[n][m];
                Queue<Integer> peak = new LinkedList<>();
                Queue<Integer> noPeak = new LinkedList<>();
                visited[i][j]=true;
                peak.add(i);
                peak.add(j);
                dfs(i,j,visited,d,i,j,peak,noPeak,0);
                if(isPeak[i][j]==1) ++cnt;
            }
        }
        System.out.print(cnt);
    }


    static void dfs(int row, int col,boolean[][] visited,int[][] d,int startR,int startC,Queue<Integer> peak,Queue<Integer> noPeak,int k){
        if(isPeak[startR][startC]==-1) return;

        int h = map[row][col];
        for(int i=0; i<d.length; ++i){
            int nextR= row+d[i][0];
            int nextC= col+d[i][1];
            if(nextR<0 || nextR>n-1 || nextC<0 || nextC>m-1) continue;
            if(visited[nextR][nextC]) continue;

            visited[nextR][nextC]=true;
            if(map[nextR][nextC]==h){
                peak.add(nextR);
                peak.add(nextC);
                dfs(nextR,nextC, visited, d,startR,startC,peak,noPeak,k+1);

            }
            else if(map[nextR][nextC]<h){
                noPeak.add(nextR);
                noPeak.add(nextC);
            }
            else{
                isPeak[startR][startC]=-1;
                return;
            }
        }
        if(k==0 && isPeak[startR][startC]!=-1){
            while(!peak.isEmpty()){
                isPeak[peak.poll()][peak.poll()]=1;
            }
            while(!noPeak.isEmpty()){
                isPeak[noPeak.poll()][noPeak.poll()]=-1;
            }
        }
    }


    static void solve2(){
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        isPeak = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                map[i][j] = sc.nextInt();
            }
        }

        int cnt=0;
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                if(isPeak[i][j]==1 || isPeak[i][j]==-1) continue;

                if(validate(i,j)){
                    ++cnt;
                }
            }
        }
        System.out.print(cnt);
    }

    static boolean validate(int row, int col){
        int[][] d= {
                {-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},
        };

        int h= map[row][col];
        boolean[][] visited = new boolean[n][m];

        Queue<Integer> q = new LinkedList<>();

        visited[row][col]=true;
        q.add(row);
        q.add(col);

        Queue<Integer> peak = new LinkedList<>();
        Queue<Integer> noPeak = new LinkedList<>();
        while(!q.isEmpty()){
            int r=q.poll();
            int c= q.poll();

            for(int i=0; i<d.length; ++i){
                int nextR= r+d[i][0];
                int nextC= c+d[i][1];
                if(nextR<0 || nextR>n-1 || nextC<0 || nextC>m-1) continue;
                if(visited[nextR][nextC]) continue;

                visited[nextR][nextC]=true;
                if(map[nextR][nextC]==h){
                    q.add(nextR);
                    q.add(nextC);
                    peak.add(nextR);
                    peak.add(nextC);
                }
                else if( map[nextR][nextC]<h){
                    noPeak.add(nextR);
                    noPeak.add(nextC);
                }
                else{
                    return false;
                }
            }
        }

        while(!peak.isEmpty()){
            isPeak[peak.poll()][peak.poll()]=1;
        }
        while(!noPeak.isEmpty()){
            isPeak[noPeak.poll()][noPeak.poll()]=-1;
        }
        return true;
    }

    static void solve1() {
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        isPeak = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                map[i][j] = sc.nextInt();
            }
        }

        int cnt = countPeakByBfs();

        System.out.print(cnt);

    }

    static int countPeakByBfs() {
        int[][] d = {
                {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}
        };

        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (isPeak[i][j] == 1 || isPeak[i][j] == -1) continue;

                boolean[][] visited = new boolean[n][m];
                visited[i][j] = true;
                int h = map[i][j];
                q.add(i);
                q.add(j);

                Queue<Integer> peak=new LinkedList();
                Queue<Integer> noPeak= new LinkedList();
                boolean find=true;
                Loop1:
                while (!q.isEmpty()) {
                    int row = q.poll();
                    int col = q.poll();
                    for (int k = 0; k < d.length; ++k) {
                        int nextR = row + d[k][0];
                        int nextC = col + d[k][1];
                        if (nextR < 0 || nextR > n - 1 || nextC < 0 || nextC > m - 1) continue;
                        if (visited[nextR][nextC]) continue;

                        visited[nextR][nextC] = true;
                        if(map[nextR][nextC]==h){
                            peak.add(nextR);
                            peak.add(nextC);
                            q.add(nextR);
                            q.add(nextC);
                        }
                        else if(map[nextR][nextC]<h){
                            noPeak.add(nextR);
                            noPeak.add(nextC);
                        }
                        else{
                            find=false;
                        }
                    }
                }
                if(find) {
                    ++cnt;
                    while(!peak.isEmpty()){
                        isPeak[peak.poll()][peak.poll()]=1;
                    }
                    while(!noPeak.isEmpty()){
                        isPeak[noPeak.poll()][noPeak.poll()]=-1;
                    }
                }

            }
        }

        return cnt;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
