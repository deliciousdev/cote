package test;

import java.util.*;
import java.io.*;

/**
 * bfs 할때 visited 배열 뿐아니라 갈수 있는 map 배열도 신경 꼭 써줘야함.안해주면 첫 탐색때 모든곳을 가버림
 */
public class P1012 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static ArrayList<Position> cabbagePosition;
    static boolean[][] visited;

    static int[][] d= {
            {-1,0},{0,1},{1,0},{0,-1}
    };

    public static void main(String[] args){
//        solve1(); //bfs
        solve2(); //dfs
    }

    static void solve2(){
        int t= sc.nextInt();
        while(t-->0){
            int m=sc.nextInt();
            int n= sc.nextInt();
            boolean[][] map=new boolean[n][m];
            cabbagePosition= new ArrayList<>();
            int k= sc.nextInt();
            while(k-->0){
                int col=sc.nextInt();
                int row= sc.nextInt();
                map[row][col]=true;
                cabbagePosition.add(new Position(row,col));
            }

            visited = new boolean[n][m];

            int ans=0;
            for(Position p : cabbagePosition){
                if(visited[p.row][p.col]) continue;

                ++ans;
                visited[p.row][p.col]=true;
                dfs(map,p.row,p.col);
            }

            sb.append(ans).append("\n");
        }
        System.out.print(sb.toString());
    }
    static void dfs(boolean[][] map,int row, int col){
        for(int i=0; i<d.length; ++i){
            int nextRow=row+d[i][0];
            int nextCol= col+d[i][1];
            if(nextRow<0 || nextRow>=map.length || nextCol<0 || nextCol>=map[0].length) continue;
            if(visited[nextRow][nextCol]) continue;
            if(!map[nextRow][nextCol]) continue;

            visited[nextRow][nextCol]=true;
            dfs(map,nextRow,nextCol);
        }
    }

    static void solve1(){
        int t= sc.nextInt();
        while(t-->0){
            int m=sc.nextInt();
            int n= sc.nextInt();
            boolean[][] map=new boolean[n][m];
            cabbagePosition= new ArrayList<>();
            int k= sc.nextInt();
            while(k-->0){
                int col=sc.nextInt();
                int row= sc.nextInt();
                map[row][col]=true;
                cabbagePosition.add(new Position(row,col));
            }

            int ans= bfs(map);
            sb.append(ans).append("\n");
        }
        System.out.print(sb.toString());

    }

    static int bfs(boolean[][] map){



        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<Integer> q = new LinkedList();
        int cnt=0;

        for(int cabbageIdx=0; cabbageIdx<cabbagePosition.size(); ++cabbageIdx) {

            Position p =cabbagePosition.get(cabbageIdx);
            if(visited[p.row][p.col]) continue;

            ++cnt;
            visited[p.row][p.col]=true;//이건 없어도 답은 나옴
            q.add(p.row);
            q.add(p.col);

            while (!q.isEmpty()) {
                int row = q.poll();
                int col = q.poll();
                for (int i = 0; i < d.length; ++i) {
                    int nextRow = row + d[i][0];
                    int nextCol = col + d[i][1];
                    if (nextRow < 0 || nextRow >= map.length || nextCol < 0 || nextCol >= map[0].length) continue;
                    if (visited[nextRow][nextCol]) continue;
                    if(!map[nextRow][nextCol]) continue;

                    visited[nextRow][nextCol] = true;
                    q.add(nextRow);
                    q.add(nextCol);
                }

            }
        }
        return cnt;
    }

    static class Position{
        int row;
        int col;
        Position(int row, int col){
            this.row= row;
            this.col = col;
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
