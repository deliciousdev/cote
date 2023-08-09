package test;

import java.util.*;
import java.io.*;

/**
 * 주사위 전개도 인접한거 탐색하는 스킬
 */
public class P1041 {

    static FastReader sc = new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N;
    static int[] arr=new int[6];

    static long ans=Long.MAX_VALUE;

    static int[][] adj={
            {3,1,2,4,3},
            {3,5,2,0,3},
            {0,1,5,4,0},
            {5,1,0,4,5},
            {3,0,2,5,3},
//            {3,5,2,1,3}, //이거 4해야하는데 5로 잘못해서 계쏙 틀림뜸;;
            {3,4,2,1,3},
    };

    public static void main(String[] args){
        solve1();
    }

    static void solve1(){
        N=sc.nextInt();
        int mn=Integer.MAX_VALUE;
        int mx=Integer.MIN_VALUE;
        for(int i=0; i<6; ++i){
            arr[i]=sc.nextInt();
            mn=Math.min(arr[i],mn);
            mx= Math.max(arr[i],mx);
        }

        if(N==1){
            System.out.print(Arrays.stream(arr).sum()-mx);
            System.exit(0);//이렇게 예외처리를 해줄때 꼭 exit 를 해주자.......
        }

        int mnSelect3 = calcMinSelect3();
        int mnSelect2 = calcMinSelect2();
        int mnSelect1 = mn;

        long num3= 4;
        long num2= 8L*N-12;
        long num1=(5L*N-6)*(N-2);

        ans= num3*mnSelect3 + num2*mnSelect2 + num1*mnSelect1;

        System.out.print(ans);
    }

    static int calcMinSelect3(){
        int mn=Integer.MAX_VALUE;

        for(int i=0; i<=5; ++i){
            for(int j=0; j<=adj[i].length-2; ++j){
                int sum=arr[i];
                sum+=arr[adj[i][j]]+arr[adj[i][j+1]];
                mn= Math.min(sum,mn);
            }
        }
        return mn;
    }
    static int calcMinSelect2(){
        int mn=Integer.MAX_VALUE;

        for(int i=0; i<=5;++i ){
            for(int j=0; j<=adj[i].length-2; ++j){
                int sum=arr[i];
                sum+=arr[adj[i][j]];
                mn=Math.min(sum,mn);
            }
        }
        return mn;
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
