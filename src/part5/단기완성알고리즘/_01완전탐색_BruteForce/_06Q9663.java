package part5.단기완성알고리즘._01완전탐색_BruteForce;

import java.util.*;
import java.io.*;

/**
 * ans가 int로 감당 되는지 생각을 했어야함
 * 만약 ans가 21억을 넘는다면 경우의수가 21억이 넘는다는거니까 시간초과임. 그래서 int 로 감당된다는것을 유추할수 있음.
 * 격자에서 대각선을 나타낼때 행-열  행+열 을 항상 생각하자
 */
public class _06Q9663 {

    static FastReader sc = new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N;
    static boolean[][] map;
    static int ans;

    public static void main(String[] args){

        solve1();
    }

    static void solve1(){
        N= sc.nextInt();

        map= new boolean[N][N];

        rec_func(0);
        System.out.print(ans);
    }

    static void rec_func(int j){
        if(j==N){
            ++ans;
            return;
        }

        for(int i=0; i<N; ++i){

            if(!isUnderAttack(i,j)){
                map[i][j] =true;
                rec_func(j+1);
                map[i][j]=false;
            }
        }
    }

    static boolean isUnderAttack(int row,int col){ //이것을 행+열 행-열 로 바꿔보자

        //가로 왼쪽
        for(int i=1; col-i>=0; ++i){
            if(map[row][col-i]){
                return true;
            }
        }

        //왼쪽 위 대각선
        for(int i=1; row-i>=0 && col-i>=0 ; ++i){
            if(map[row-i][col-i]){
                return true;
            }
        }

        //왼쪽 아래 대각선
        for(int i=1; row+i<N && col-i >=0 ; ++i){
            if(map[row+i][col-i]){
                return true;
            }
        }
        return false;
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null ||!st.hasMoreElements()){
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
