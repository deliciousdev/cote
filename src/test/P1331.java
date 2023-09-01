package test;

import java.util.*;
import java.io.*;


/**
 * 좌표 이동 .. 생각이 안난다면 그냥 배열로, 발견 가능 하다면 수식으로
 */
public class P1331 {

    static FastReader sc= new FastReader();
    static final String VALID="Valid";
    static final String INVALID="Invalid";

    static int[][] d= {
            {-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}
    };

    static boolean[][] visited= new boolean[7][7];

    public static void main(String[] args) {
//        solve1();
        solve2();//이동좌표를 배열로 잡지않고 2차이,1차이 로 함
    }

    static void solve2(){
        String start = sc.next();
        int startRow= start.charAt(0)-'A'+1;
        int startCol = start.charAt(1)-'1'+1;
        visited[startRow][startCol]=true;
        int currentRow = startRow;
        int currentCol= startCol;

        int temp=35;
        while(temp-->0){
            String position = sc.next();
            int nextRow= position.charAt(0)-'A'+1;
            int nextCol = position.charAt(1)-'1'+1;
            if(visited[nextRow][nextCol] ||!validateMove2(currentRow,currentCol,nextRow,nextCol)){
                System.out.print(INVALID);
                System.exit(0);
            }

            visited[nextRow][nextCol]=true;
            currentRow=nextRow;
            currentCol=nextCol;
        }

        if(!canMoveToStart2(currentRow,currentCol,startRow,startCol)){
            System.out.print(INVALID);
            System.exit(0);
        }

        System.out.print(VALID);
    }

    static void solve1(){
        String start = sc.next();
        int startRow= start.charAt(0)-'A'+1;
        int startCol = start.charAt(1)-'1'+1;
        visited[startRow][startCol]=true;
        int currentRow = startRow;
        int currentCol= startCol;

        int temp=35;
        while(temp-->0){
            String position = sc.next();
            int nextRow= position.charAt(0)-'A'+1;
            int nextCol = position.charAt(1)-'1'+1;
            if(visited[nextRow][nextCol] ||!validateMove(currentRow,currentCol,nextRow,nextCol)){
                System.out.print(INVALID);
                System.exit(0);
            }

            visited[nextRow][nextCol]=true;
            currentRow=nextRow;
            currentCol=nextCol;
        }

        if(!canMoveToStart(currentRow,currentCol,startRow,startCol)){
            System.out.print(INVALID);
            System.exit(0);
        }

        System.out.print(VALID);
    }

    static boolean canMoveToStart(int currentRow,int currentCol, int startRow, int startCol){
        return validateMove(currentRow,currentCol,startRow,startCol);
    }
    static boolean validateMove(int currentRow, int currentCol,int nextRow, int nextCol){
        boolean canMove=false;
        for(int i=0; i<d.length; ++i){
            int nr=currentRow+d[i][0];
            int nc=currentCol+d[i][1];
            if(nr==nextRow&& nc==nextCol) return true;
        }
        return canMove;
    }

    static boolean canMoveToStart2(int currentRow,int currentCol, int startRow, int startCol){
        return validateMove2(currentRow,currentCol,startRow,startCol);
    }
    static boolean validateMove2(int currentRow, int currentCol,int nextRow, int nextCol){
        int sub1= Math.abs(currentRow-nextRow);
        int sub2= Math.abs(currentCol-nextCol);
        if(sub1==1 &&sub2==2) return true;
        if(sub1==2 && sub2==1) return true;
        return false;
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
        int nextInt(){
            return Integer.parseInt(next());
        }

    }
}
