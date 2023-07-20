package part5.단기완성알고리즘._05그래프와탐색;

import java.util.*;
import java.io.*;

/**
 * multiSourceBFS 를 안하고 모든 물에 대해서 각각 BFS 를 한다면 N^2 * N^2 복잡도가됨
 * multiSourceBFS 를 적용하면 N^2 복잡도 (BFS 를 한번만 하면됨)
 */
public class _07Q3055 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int R,C;
    static char[][] map= new char[50][50];
    static int[][] waterMoveCnt =new int[50][50];
    static int[][] mouseMoveCnt =new int[50][50];

    static int[][] waterPoint = new int[2500][2]; //이 사이즈를 50으로 해줬을때 런타임 났었음.
    static int waterSize;
    static int[][] mousePoint = new int[1][2];
    static int[][] cavePoint = new int[1][2];

    static int[][] move ={{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){

        input();
        initMoveCnt();
        waterBfs();
        mouseBfs();

        int r= cavePoint[0][0];
        int c= cavePoint[0][1];
        System.out.print(mouseMoveCnt[r][c]==-1 ? "KAKTUS":mouseMoveCnt[r][c]);
    }

    static void mouseBfs(){
        Queue<Integer> q = new LinkedList();
        int r= mousePoint[0][0];
        int c= mousePoint[0][1];
        q.add(r);
        q.add(c);
        mouseMoveCnt[r][c]=0;

        while(!q.isEmpty()){
            int row=q.poll();
            int col= q.poll();
            for(int m=0; m<move.length; ++m){
                int nR = row+move[m][0];
                int nC= col+move[m][1];
                if(nR<0 || nR>R-1 || nC<0 || nC > C-1) continue;
                if(map[nR][nC]!='.' && map[nR][nC]!='D') continue; //&& || 이거 때문에 헷갈림
                if(waterMoveCnt[nR][nC]!=-1 && waterMoveCnt[nR][nC]-1<=mouseMoveCnt[row][col]) continue; //!=-1 && 이게 중요함
                if(mouseMoveCnt[nR][nC]!=-1) continue;

                mouseMoveCnt[nR][nC]=mouseMoveCnt[row][col]+1;
                q.add(nR);
                q.add(nC);
            }
        }
    }
    static void waterBfs(){

        Queue<Integer> q = new LinkedList();
        for(int i=0; i<waterSize; ++i){
            int row= waterPoint[i][0];
            int col = waterPoint[i][1];
            waterMoveCnt[row][col] =0;
            q.add(row);
            q.add(col);
        }

        while(!q.isEmpty()){
            int row= q.poll();
            int col= q.poll();

            for(int m=0; m<move.length; ++m){
                int nRow= row+move[m][0];
                int nCol= col+move[m][1];
                if(nRow<0 || nRow>R-1 || nCol <0 || nCol >C-1)continue;
                if(map[nRow][nCol]=='X' ||map[nRow][nCol]== 'D') continue;
                if(waterMoveCnt[nRow][nCol]!=-1) continue;

                waterMoveCnt[nRow][nCol] = waterMoveCnt[row][col]+1;
                q.add(nRow);
                q.add(nCol);
            }
        }
    }

    static void initMoveCnt(){
        for(int i=0; i<C; ++i){
            Arrays.fill(waterMoveCnt[i],0,C,-1);
        }
        for(int i=0; i<C; ++i){
            Arrays.fill(mouseMoveCnt[i],0,C,-1);
        }
    }

    static void input(){
        R= sc.nextInt();
        C= sc.nextInt();

        for(int i=0; i<R; ++i){
            String s = sc.next();
            for(int j=0; j<C; ++j){
                char temp=s.charAt(j);
                map[i][j]=temp;
                if(temp=='*') {
                    waterPoint[waterSize][0]=i;
                    waterPoint[waterSize++][1]=j;
                }
                else if(temp=='S'){
                    mousePoint[0][0]=i;
                    mousePoint[0][1]=j;
                }
                else if( temp=='D'){
                    cavePoint[0][0]=i;
                    cavePoint[0][1]=j;
                }
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
            while (st == null || !st.hasMoreElements()) {
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
                str=  br.readLine();
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
