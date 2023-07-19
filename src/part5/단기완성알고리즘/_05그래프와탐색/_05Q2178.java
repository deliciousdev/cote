package part5.단기완성알고리즘._05그래프와탐색;

import java.io.*;
import java.util.*;

/**
 * BFS 는 DFS 와 다르게 다른 정점까지 최소 이동 횟수도 계산가능 ( 가중치와는 다른 개념)
 * 문제속 키워드 : "최소 이동 횟수", "최단 시간" , "가장빠른"
 *
 * 아무리 많이 탐색해도 N^2 개의 탐색을 넘을 수 없음. : 정답은 int 로 충분함
 */
public class _05Q2178 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N,M;

    static int[][] moveCnt =new int[101][101];
    static int[][] map = new int[101][101];

    static int[][] next = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        N= sc.nextInt();
        M= sc.nextInt();

        for(int i=1; i<=N; ++i){
            String input = sc.next(); //이렇게 받을때 꼭 int 로 변환 해줘야함
            for(int j=1; j<=M; ++j){
                map[i][j]=input.charAt(j-1)-'0'; //문자열로 받고, one base 배열에 넣을때 j-1 도 신경 써줘야함
            }
        }
        moveCnt[1][1]=1;

        bfs();

        System.out.print(moveCnt[N][M]);
    }

    static void bfs(){

        Queue<Integer> q = new LinkedList();

        q.add(1);
        q.add(1);
        while(!q.isEmpty()){
            int row= q.poll();
            int col =q.poll();
            for(int i = 0; i< next.length; ++i){
                int nextRow= row+ next[i][0];
                int nextCol= col+ next[i][1];
                if(nextRow<1 || nextRow>N || nextCol <1 || nextCol>M) continue;
                if(map[nextRow][nextCol]!=1) continue;
                if(moveCnt[nextRow][nextCol]!=0) continue;

                moveCnt[nextRow][nextCol] = moveCnt[row][col]+1;
                q.add(nextRow);
                q.add(nextCol);
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
