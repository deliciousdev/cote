package part1.자료구조알고리즘1.ch06_누적합;


import java.util.*;
import java.io.*;

/**
 * 매 시간마다 누적합을 구해두면, 배열을 탐색하면서 합을 구하지않아도됨
 * 배열을 반복적으로 탐색 해야될때, 구간합을 한번 구해놓으면 반복적인 배열 탐색을 안해도된다.
 */

public class _05Q17232 {


    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N,M,T;
    static int K,a,b;
    static int acc[][];
    static int arr[][];

    public static void main(String[] args){
        input();

        acc = new int[N+1][M+1];

        int t= T;
        while(t-->0){
            setAcc();
            for(int i=1; i<=N; ++i){
                for(int j=1; j<=M;++j){
                    int cnt= count(acc,i,j,K);
                    if(arr[i][j]==1){
                        if(0<=cnt && cnt<a || cnt>b){
                            arr[i][j]=0;
                        }
                    }
                    else{
                        if(a+1<=cnt && cnt<=b){
                            arr[i][j]=1;
                        }
                    }
                }
            }
        }

        print();
    }

    static int count(int[][]acc, int i, int j, int k){
        int r1= Math.max(1,i-k);
        int r2= Math.min(N,i+k);
        int c1= Math.max(1,j-k);
        int c2= Math.min(M,j+k);

        int cnt= acc[r2][c2] - acc[r2][c1-1]-acc[r1-1][c2] +acc[r1-1][c1-1]-arr[i][j];
        return cnt;
    }

    static void print(){
        for(int i=1; i<=N; ++i){
            for(int j=1; j<=M; ++j){
                sb.append( arr[i][j]==1? "*":".");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    static void setAcc(){
        for(int i=1; i<=N; ++i){
            for (int j=1;j<=M; ++j){
                acc[i][j] = acc[i-1][j] +acc[i][j-1]-acc[i-1][j-1]+arr[i][j];
            }
        }
    }
    static void input(){
        N= sc.nextInt();
        M= sc.nextInt();
        T= sc.nextInt();
        K= sc.nextInt();
        a= sc.nextInt();
        b= sc.nextInt();

        arr= new int[N+1][M+1];
        for(int i=1; i<=N; ++i){
            String str = sc.nextLine();
            for(int j=1; j<=M; ++j){
                char c = str.charAt(j-1);
                if(c=='*'){
                    arr[i][j]=1;
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
            while(st==null || !st.hasMoreElements()){
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
