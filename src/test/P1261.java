package test;

import java.util.*;
import java.io.*;


/**
 * 이문제는 각 cost 가 1로 고정이므로 visit 으로 다익스트라를 해도되긴함.( 첫 방문이 무조건 최소 비용)
 * 정석 다익스트라를 꼼꼼히 숙지하자.. 각 조건에서 등호 같은거 주의..
 */
public class P1261 {

    static FastReader sc = new FastReader();
    static int n, m;
    static int[][] map;

    static int[][] costArr;

    public static void main(String[] args) {
//        solve1();//그냥 bfs 부르트포스 하여 최소값 구하기
//        solve2();//다익스트라 정석
//        solve3(); //visited + 다익스트라
        solve4();//반례있는 다익스트라 : 1 1 0 이 반례임
    }

    static void solve4(){
        m= sc.nextInt();
        n= sc.nextInt();
        map = new int[n+1][m+1];
        for(int i=1; i<=n; ++i){
            char[] c= sc.next().toCharArray();
            for(int j=1; j<=m; ++j){
                map[i][j]=c[j-1]-'0';
            }
        }

        int ans= dijkstra3();
        System.out.print(ans);
    }

    static void solve3(){
        m= sc.nextInt();
        n= sc.nextInt();
        map = new int[n+1][m+1];
        for(int i=1; i<=n; ++i){
            char[] c= sc.next().toCharArray();
            for(int j=1; j<=m; ++j){
                map[i][j]=c[j-1]-'0';
            }
        }

        int ans= dijkstra2();
        System.out.print(ans);
    }
    static void solve2(){
        m= sc.nextInt();
        n= sc.nextInt();
        map = new int[n+1][m+1];
        for(int i=1; i<=n; ++i){
            char[] c= sc.next().toCharArray();
            for(int j=1; j<=m; ++j){
                map[i][j]=c[j-1]-'0';
            }
        }

        int ans= dijkstra();
        System.out.print(ans);
    }

    static int dijkstra3(){
        int[][] d= {
                {-1,0},{0,1},{1,0},{0,-1}
        };

        boolean[][] confirmedCost = new boolean[n+1][m+1];
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.cost));

        confirmedCost[1][1]=true;
        pq.add(new Point(1,1,0));

        while(!pq.isEmpty()){
            Point p = pq.poll();
            int r= p.row;
            int c= p.col;
            int cost= p.cost;
//            if( r==n && c==m) return cost;

            for(int i=0; i<d.length; ++i){
                int nextR=r+d[i][0];
                int nextC= c+d[i][1];
                if(nextR<1 || nextR>n || nextC<1 || nextC>m) continue;
                if(confirmedCost[nextR][nextC])continue;

                confirmedCost[nextR][nextC]=true;
                if(nextR==n &&nextC==m) return cost; // 1 1 0 이 반례임
                if(map[nextR][nextC]==1){
                    pq.add(new Point(nextR,nextC,cost+1));
                }
                else{
                    if( nextR==n && nextC==m) return cost;
                    pq.add(new Point(nextR,nextC,cost));
                }
            }
        }
        return -1; //return 0 으로 해주면 반례가 잡히긴함
    }
    static int dijkstra2(){
        int[][] d= {
                {-1,0},{0,1},{1,0},{0,-1}
        };

        boolean[][] confirmedCost = new boolean[n+1][m+1];
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.cost));

        confirmedCost[1][1]=true;
        pq.add(new Point(1,1,0));

        while(!pq.isEmpty()){
            Point p = pq.poll();
            int r= p.row;
            int c= p.col;
            int cost= p.cost;
            if( r==n && c==m) return cost;

            for(int i=0; i<d.length; ++i){
                int nextR=r+d[i][0];
                int nextC= c+d[i][1];
                if(nextR<1 || nextR>n || nextC<1 || nextC>m) continue;
                if(confirmedCost[nextR][nextC])continue;

                confirmedCost[nextR][nextC]=true;
                if(map[nextR][nextC]==1){
                    pq.add(new Point(nextR,nextC,cost+1));
                }
                else{
                    if( nextR==n && nextC==m) return cost;
                    pq.add(new Point(nextR,nextC,cost));
                }
            }
        }
        return -1;
    }
    static int dijkstra(){
        int[][] d= {
                {-1,0},{0,1},{1,0},{0,-1}
        };
        costArr =new int[n+1][m+1];
        for(int i=1; i<=n; ++i){
            for(int j=1; j<=m; ++j){
                costArr[i][j]=1000000;
            }
        }

        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.cost));

        pq.add(new Point(1,1,0));

//        costArr[1][1]=0; //해도되고 안해도되고
        while(!pq.isEmpty()){
            Point p = pq.poll();
            int r= p.row;
            int c= p.col;
            int cost= p.cost;
            if( r==n && c==m) return cost;
//            if(costArr[r][c]<=cost) continue; //costArr은 후보이고 cost를 확정해주는 단계이므로 같은것은 무시하면안됨
            if(costArr[r][c]<cost) continue; //부등호 주의

            for(int i=0; i<d.length; ++i){
                int nextR=r+d[i][0];
                int nextC= c+d[i][1];
                if(nextR<1 || nextR>n || nextC<1 || nextC>m) continue;

                if(map[nextR][nextC]==1){
                    if(costArr[nextR][nextC]<=cost+1) continue; //메모리 초과 때문에 메모리를 줄일려고 억지로 이것을 추가함 : 이거 추가해주는게 다익스트라 정석임.

                    costArr[nextR][nextC]= cost+1;
                    pq.add(new Point(nextR,nextC,cost+1));
                }
                else{
                    if(costArr[nextR][nextC]<=cost) continue; ////메모리 초과 때문에 메모리를 줄일려고 억지로 이것을 추가함 : 이거 추가해주는게 다익스트라 정석임

                    costArr[nextR][nextC]=cost;
                    pq.add(new Point(nextR,nextC,cost));
                }
            }
        }
        return -1;
    }
    static int wrongDijkstra(){

        int[][] d= {
                {-1,0},{0,1},{1,0},{0,-1}
        };

        boolean[][] confirmedCost = new boolean[n+1][m+1];
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.cost));

        confirmedCost[1][1]=true;//빼먹지 안도록 주의
        pq.add(new Point(1,1,0));

        while(!pq.isEmpty()){
            Point p = pq.poll();
            int r= p.row;
            int c= p.col;
            int cost= p.cost;


            for(int i=0; i<d.length; ++i){
                int nextR=r+d[i][0];
                int nextC= c+d[i][1];
                if(nextR<1 || nextR>n || nextC<1 || nextC>m) continue;
                if(confirmedCost[nextR][nextC])continue;

                confirmedCost[nextR][nextC]=true; //여기는 cost 가 확정되는 곳이 아님
                if(map[nextR][nextC]==1){
                    pq.add(new Point(nextR,nextC,cost+1));
                }
                else{
                    if(nextR==n && nextC ==m) return cost; //들어갈때는 cost 가 확정되는지 안되는지 몰름. 꺼낼때 cost가 확정됨

                    pq.add(new Point(nextR,nextC,cost));
                }
            }
        }
        return -1;
    }
    static class Point{
        int row;
        int col;
        int cost;
        Point(int r, int c, int cost){
            this.row= r;
            this.col = c;
            this.cost = cost;
        }
    }

    static void solve1() {
        m = sc.nextInt();
        n = sc.nextInt();
        map = new int[n + 1][m + 1];
        for (int i = 1; i <= n; ++i) {
            char[] c = sc.next().toCharArray();
            for (int j = 1; j <= m; ++j) {
                map[i][j] = c[j - 1] - '0';
            }
        }
        costArr = new int[n + 1][m + 1];
        for(int i=1; i<=n; ++i){
            for(int j=1; j<=m; ++j){
                costArr[i][j]=100000;
            }
        }

        bfs();

        System.out.print(costArr[n][m]);
    }

    static void bfs() {

        int[][] d = {
                {-1, 0}, {0, 1}, {1, 0}, {0, -1}
        };

        Queue<Integer> q = new LinkedList<>();

        costArr[1][1]=0;
        q.add(1);
        q.add(1);
        while (!q.isEmpty()) {
            int r = q.poll();
            int c = q.poll();
            for (int i = 0; i < d.length; ++i) {
                int nextR = r + d[i][0];
                int nextC = c + d[i][1];
                if(nextR<1 || nextR>n || nextC<1 || nextC>m) continue;

                if(map[nextR][nextC]==1){
                    if(costArr[nextR][nextC]> costArr[r][c]+1){
                        costArr[nextR][nextC]= costArr[r][c]+1;
                        q.add(nextR);
                        q.add(nextC);
                    }
                }
                else{
                    if(costArr[nextR][nextC]> costArr[r][c]){
                        costArr[nextR][nextC] = costArr[r][c];
                        q.add(nextR);
                        q.add(nextC);
                    }
                }
            }
        }
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
