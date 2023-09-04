package test;

import java.util.*;
import java.io.*;


/**
 * 달팽이, 소용돌이
 */
public class P1913 {


    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int[][] map;
    static int n;
    static int q;
    static int[][] d={
            {1,0},{0,1},{-1,0},{0,-1}
    };

    public static void main(String[] args){
//        solve1(); //현재 위치를 기준으로 방향을 설정
//        solve2(); //다음위치를 탐색해서 방향을 설정 : 충돌하면 방향 수정 : 밖에서 돌리기
        solve3();//안에서 돌리기
    }

    static void solve3(){

    }
    static void solve2(){
        n=sc.nextInt();
        q=sc.nextInt();
        map=new int[n+2][n+2];
        for(int i=0; i<=n+1; ++i){
            map[0][i]=-1;
            map[n+1][i]=-1;
            map[i][0]=-1;
            map[i][n+1]=-1;
        }

        int num=n*n;
        int dIndex=0;

        int nextRow=1;
        int nextCol=1;
        int row=0;
        int col=1;

        while(num>0){
            nextRow= row+d[dIndex][0];
            nextCol= col+d[dIndex][1];
            if(map[nextRow][nextCol] != 0){
                dIndex= (dIndex+1)%4;
                continue;
            }

            row=nextRow;
            col=nextCol;
            map[row][col]=num--;
        }

        print();

    }
    static void solve1(){
        n= sc.nextInt();
        q= sc.nextInt();
        map=new int[n+1][n+1];

        int num=n*n;
        int row=0;
        int col=1;
        while(num>0){

            while(row+col!=n+1){
                row=row+d[0][0];
                col=col+d[0][1];
                map[row][col]=num--;
            }

            if(num==0) break;
            while(row!=col){
                row=row+d[1][0];
                col=col+d[1][1];
                map[row][col]=num--;
            }

            while(row+col!=n+1){
                row=row+d[2][0];
                col=col+d[2][1];
                map[row][col]=num--;
            }

            while(col-row!=1){
                row=row+d[3][0];
                col=col+d[3][1];
                map[row][col]=num--;
            }
        }
            print();
    }

    static void print()  {
        int r=0;
        int c=0;

        for(int i=1; i<=n; ++i){
            for(int j=1; j<=n; ++j){
                sb.append(map[i][j]).append(" ");
                if(map[i][j]==q){
                    r=i;c=j;
                }
            }
            sb.append("\n");
        }
        sb.append(r).append(" ").append(c);
        System.out.print(sb.toString());
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
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

        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
