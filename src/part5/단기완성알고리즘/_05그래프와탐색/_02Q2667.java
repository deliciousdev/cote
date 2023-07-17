package part5.단기완성알고리즘._05그래프와탐색;

import java.util.*;
import java.io.*;

/**
 * 정답의 최대치도 고려 했었어야함. : 단지의 최대 개수, 집의 최대개수
 * 시간 복잡도도 계산해야함.
 */
public class _02Q2667 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N;
    static boolean[][] arr;
    static boolean[][] visit;

//    static int[] dr={-1,0,1,0};
//    static int[] dc={0,1,0,-1};
    static int[][] d = { {-1,0},{0,1},{1,0},{0,-1}};
    static ArrayList<Integer> ans = new ArrayList<>();

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        N= sc.nextInt();

        arr= new boolean[N][N];
        visit = new boolean[N][N];
        for(int i=0; i<N; ++i){
            char[] temp = sc.next().toCharArray();
            for(int j=0; j<N; ++j){
                if(temp[j]=='1'){
                    arr[i][j]=true;
                }
            }
        }


        int townCnt=0;
        Queue<Point> q = new LinkedList<Point>();
        for(int i=0; i<N; ++i){
            for(int j=0; j<N; ++j){
                if(arr[i][j]==false || visit[i][j]) continue;

                int homeCnt=0;

                visit[i][j]=true;
                q.add(new Point(i,j));
                ++townCnt;
                while(!q.isEmpty()){
                    Point p = q.poll();
                    ++homeCnt;
                    int row=p.row;
                    int col= p.col;

                    for(int k=0; k<4; ++k){
//                        int nextRow= row+dr[k];
//                        int nextCol =col+dc[k];
                        int nextRow= row+d[k][0];
                        int nextCol=col+d[k][1];
                        if(nextRow<0 || nextRow>N-1 || nextCol<0 || nextCol >N-1) continue; //이것을 꼭 기억하자
                        if(arr[nextRow][nextCol]==false || visit[nextRow][nextCol]) continue;

                        visit[nextRow][nextCol]=true;
                        q.add(new Point(nextRow,nextCol));
                    }
                }
                ans.add(homeCnt);
            }
        }

        Collections.sort(ans);

//        sb.append(townCnt).append("\n"); //굳이 townCnt 를 안구해도 ans.size()를 하면됨
        sb.append(ans.size()).append("\n");
        for(int e : ans){
            sb.append(e).append("\n");
        }
        System.out.print(sb.toString().trim());
    }

    static class Point{
        int row;
        int col;
        Point(int row, int col){
            this.row= row;
            this.col= col;
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
            String str= "";
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
