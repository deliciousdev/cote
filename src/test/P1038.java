package test;

import java.util.*;
import java.io.*;

/**
 * 어떤 조건을 만족하는 수들을 여러개 구한후, 이것을 모와서 정렬 시켜버리면 몇번째인지 알 수 있음.
 * Collections.addAll() : 전부 추가할때
 * constructor(Collection) : 전부 추가할때
 * 백트래킹시 직전스택에대한 결과에 접근할려하면 이 결과를 파라미터로 넘겨줄지 전역변수로 할지 잘 따져봐야함.
 */
public class P1038 {

    static FastReader sc= new FastReader();

    static int N;

    static int[][] dp;

    static ArrayList<Long> nums= new ArrayList<>();
    static ArrayList<Long> results = new ArrayList<>();
    public static void main(String[] args){
//        solve1();//dp로 뭔가 해볼려다가 아니다 싶음....
//        solve2();//bfs
        solve3();//dfs
    }

    static void solve3(){
        N=sc.nextInt();
        for(int i=0; i<=9; ++i){
            results.add((long)i);
            dfs(i,i);
        }

        Collections.sort(results);

        if(N>results.size()-1){
            System.out.print(-1);
            System.exit(0);
        }
        System.out.print(results.get(N));
    }

    static void dfs(int s,long number){

        for(int i=s-1; i>=0; --i){
//            long num=results.get(results.size()-1); //이런식으로 직전 스택에 접근하다보면 백트래킹이기 때문에 틀린 로직임 ->파라미터로 넘겨줘야함
//            results.add(num*10+i);

            long newNumber= number*10+i;
            results.add(newNumber);
            dfs(i,newNumber);
        }
    }

    static void solve2(){
        N=sc.nextInt();
        for(long i=0; i<=9; ++i){
            nums.add(i);
        }
        bfs();

        if(N>nums.size()-1){
            System.out.print(-1);
            System.exit(0);
        }

        Collections.sort(nums);

        System.out.print(nums.get(N));
    }

    static void bfs(){

        Queue<Long> q = new LinkedList<>();
        for(long i=1; i<=9; ++i){
            q.add(i);
        }

        while(!q.isEmpty()){
            long current= q.poll();
            long lastDigit= current%10;
            for(long i=lastDigit-1; i>=0; --i){
                long newNumber= current*10+i;
                nums.add(newNumber);
                q.add(newNumber);
            }
        }
    }



    static void solve1(){
        N=sc.nextInt();
        dp= new int[7+1][9+1];
        for(int i=0; i<=9; ++i){
            dp[1][i]=i+1;
        }

        for(int i=2; i<=7; ++i){
            for(int j=1; j<=9; ++j){
                if(j==1){
                    dp[i][j]=dp[i-1][9]+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=dp[i][j-1]+dp[i-1][j-1];
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
