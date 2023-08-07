package test;

import java.util.*;
import java.io.*;

/**
 * 브루트포스 구현 , bfs,조합,순열
 * 재귀로 check 해줄때 복귀한후 꼭 check 를 풀어줘야함. 꼭 꼭
 */
public class P1035 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static char[][] map= new char[5][5];

    static int[] selected;

    static ArrayList<Point> star=new ArrayList<>();
    static int ans=Integer.MAX_VALUE;
    public static void main(String[] args){
        input();
        solve1();
    }

    static void solve1(){
        bruteForce_combination(0,-1);
        System.out.print(ans);
    }

    static void bruteForce_combination(int k,int s){
        if(k==star.size()){
            if(linked()){
                ans=Math.min(ans,calcMinCost());
            }
            return;
        }

        for(int i=s+1; i<25; ++i){
            selected[k]=i;
            bruteForce_combination(k+1,i);
        }
    }

    static boolean linked(){

        boolean[][] isSelectedPoint = new boolean[5][5];
        boolean[][] visited= new boolean[5][5];

        for(int i=0; i<selected.length; ++i){
            int row=selected[i]/5;
            int col= selected[i]%5;

            isSelectedPoint[row][col]=true;
        }


        int cnt=0;
        int[][] d={
                {-1,0},{0,1},{1,0},{0,-1}
        };

        Queue<Point> q= new LinkedList<>();
        ++cnt;
        int startRow=selected[0]/5;
        int startCol=selected[0]%5;
        q.add(new Point(startRow,startCol));
        visited[startRow][startCol]=true;

        while(!q.isEmpty()){
            Point p=q.poll();
            int r=p.row;
            int c=p.col;
            for(int i=0; i<d.length; ++i){
                int nextR=r+d[i][0];
                int nextC= c+d[i][1];
                if(nextR<0|| nextR>4 || nextC<0 || nextC>4) continue;
                if(!isSelectedPoint[nextR][nextC]) continue;
                if(visited[nextR][nextC]) continue;

                visited[nextR][nextC]=true;
                ++cnt;
                q.add(new Point(nextR,nextC));
            }
        }

        return cnt==star.size();
    }
    static int calcMinCost(){
        int[] mnCost={Integer.MAX_VALUE};
        boolean[] check= new boolean[star.size()];
        int[] permutation=new int[star.size()];
        bruteForce_permutation(0,check,permutation,mnCost);
        return mnCost[0];
    }

    static void bruteForce_permutation(int k,boolean[] check,int[] permutation,int[] mnCost){
        if(k==star.size()){
            int sum=0;
            for(int i=0; i<star.size(); ++i){
//                sum+=calcCost(new Point(selected[i]/5,selected[i]%5),new Point(star.get(i).row,star.get(i).col));
                sum+=calcCost(new Point(selected[i]/5,selected[i]%5),star.get(permutation[i]));//이것도 퍼뮤테이션 구해놓고 사용도 안했었음...
            }
            mnCost[0]=Math.min(mnCost[0],sum);
            return;
        }
        for(int i=0; i<star.size(); ++i){
            if(check[i]) continue;

            check[i]=true;
            permutation[k]=i;
            bruteForce_permutation(k+1,check,permutation,mnCost);
            check[i]=false;//이거 때문에 디버깅 너무 오래걸림 ㅠㅠ
        }

    }


    static int calcCost(Point p1, Point p2){
        return Math.abs(p1.row-p2.row) +Math.abs(p1.col-p2.col);
    }

    private static void input() {
        for(int i=0; i<5; ++i){
            String s= sc.next();
            map[i]=s.toCharArray();
            for(int j=0; j<5; ++j){
                if(map[i][j]=='*'){
                    star.add(new Point(i,j));
                }
            }
        }
        selected=new int[star.size()];
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
