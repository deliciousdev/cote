package part5.단기완성알고리즘._09동적프로그래밍;

import java.util.*;
import java.io.*;

/**
 * 다이내믹테이블을 정의할때, 일반적으로는 시작을 고정하고 끝을 움직이는 식이지만, 이것은 시작도 움직이고 끝도 움직임.
 * 테이블을 채우는 순서도 중요함.
 * 테이블을 채울때 대각선으로 채워야하는데, 이것을 구현하는 방법
 * 다이나믹 테이블에서 i,j(시작,끝) 이 정의 되어있으면, 테이블을 채우는 순서가 중요하다.
 */
public class _05Q11066 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int T, K;
    static int[] volumes;
    static int[] frontAcc;
    static int[] backAcc;
    static int[][] d;

    public static void main(String[] args) {

        int t = T = sc.nextInt();
        while (t-- > 0) {
            K = sc.nextInt();
            volumes = new int[K+1];
            frontAcc= new int[K+1];
            backAcc= new int[K+2];
            d= new int[K+1][K+1];
            for (int i = 1; i <= K; ++i) {
                volumes[i]=sc.nextInt();
            }
            setAcc();

            int ans = solve1();
            sb.append(ans).append("\n");
        }
        System.out.print(sb.toString().trim());
    }

    static void setAcc(){
        for(int i=1; i<=K; ++i){
            frontAcc[i]=frontAcc[i-1]+volumes[i];
            backAcc[K+1-i]=backAcc[K+2-i]+volumes[K+1-i];
        }
    }
   static int solve1(){
        for(int i=1; i<=K; ++i){
            d[i][i]=0;
        }
        int row=1;
        int col=2;
        for(int i=0; i<=K-2; ++i){
            row=1;
            col=2+i;
            while(col<=K){

                d[row][col]=calcSum(row,col)+d[row][row]+d[row+1][col];
                for(int mid=row+1; mid<=col-1; ++mid){
                    int temp=calcSum(row,col)+d[row][mid]+d[mid+1][col];
                    d[row][col]=Math.min(d[row][col],temp);
                }
                ++row;
                ++col;
            }
        }

        return d[1][K];
   }

   static int calcSum(int i,int j){
        int total=frontAcc[K];
        return total - frontAcc[i-1]-backAcc[j+1];
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
