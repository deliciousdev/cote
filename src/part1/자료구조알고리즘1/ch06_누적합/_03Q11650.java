package part1.자료구조알고리즘1.ch06_누적합;


import java.util.*;
import java.io.*;

/**
 * 행 단위로 누적을 하기,
 * 2차원 단위로 누적하기
 */

public class _03Q11650 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N,M;
    static int[][] acc;
    public static void main(String[] args){
        N=sc.nextInt();
        M= sc.nextInt();
        acc= new int[N+1][N+1];

        //누적합
        for(int i=1; i<=N ; ++i){
            for(int j=1; j<=N; ++j){
                acc[i][j]= acc[i-1][j]+acc[i][j-1]-acc[i-1][j-1]+sc.nextInt();
            }
        }

        //구간합
        int m= M;
        while(m-->0){
            int x1 =sc.nextInt();
            int y1= sc.nextInt();
            int x2= sc.nextInt();
            int y2= sc.nextInt();
            int ans = acc[x2][y2]-acc[x2][y1-1]-acc[x1-1][y2]+acc[x1-1][y1-1];
            sb.append(ans).append("\n");
        }
        System.out.print(sb.toString());
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st==null||!st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
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
    }
}
