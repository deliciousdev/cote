package part5.단기완성알고리즘._09동적프로그래밍;

import java.util.*;
import java.io.*;

/**
 * dp 테이블에 점수최대값에 대한 정보뿐 아니라 지금까지 어떤 경로로 왔는지에 대한 정보도 필요함.
 * 포인트 dp 테이블에 부족한 정보가 없는지 확인해야함( 특별한 조건이 붙어 있는경우 이에 대한 정보가 필요함)
 * 동적 프로그래밍 백트래킹(역추적) : 실제 경로를 어떻게 해야 이런 최대값을 얻을 수 있을까?
 */
public class _03Q2579 {

    static FastReader sc= new FastReader();
    static StringBuilder sb= new StringBuilder();

    static int N;
    static int[] score= new int[300+1];

    static int[][] dp= new int[300+1][3]; //dp[1] : 1로 올라오는 경우, dp[2] : 2로 올라오는경우
    static int[] maxAccScore= new int[300+1];

    static boolean[] used1 = new boolean[300+1];
    static boolean[] used2= new boolean[300+1];

    static ArrayList<Integer> path = new ArrayList<>();


    public static void main(String[] args){
//        solve1();//연속 11을 고려 안했음.
//        solve2();//잘못된풀이
//        solve3();//모범답안
//        solve4();//잘못된 백트래킹
        solve5();//백트래킹 : dp테이블과 같이 기록해두고 dp결과를 시작으로 역추적해간다
    }

    static void solve5(){
        N=sc.nextInt();
        for(int i=1; i<=N; ++i){
            score[i]=sc.nextInt();
        }
        Path[][] come=new Path[300+1][3];
        dp[1][1]=score[1];
        dp[2][1]=score[1]+score[2];
        dp[2][2]=score[2];
        come[2][1]=new Path(1,1);
        come[2][2]=new Path(0,0);
        for(int i=3; i<=N; ++i){
            dp[i][1]=dp[i-1][2]+score[i];
            dp[i][2]=Math.max(dp[i-2][1],dp[i-2][2])+score[i];

            come[i][1]=new Path(i-1,2);
            if(dp[i-2][1]>dp[i-2][2]){
                come[i][2]=new Path(i-2,1);
            }
            else{
                come[i][2]=new Path(i-2,2);
            }
        }

        int ans=Math.max(dp[N][1],dp[N][2]);
        System.out.println(ans);

        //백트래킹 테이블 없이 추적
        path.add(N);
        int point=N;
        while(point>0){
            if(dp[point][1]>dp[point][2]){
                path.add(point-1);
                --point;
            }
            else{
                path.add(point-2);
                point-=2;
            }
        }
        for(int i=path.size()-1; i>=0; --i){
            sb.append(path.get(i)).append(" ");
        }
        System.out.println(sb.toString().trim());

        sb.setLength(0);


        //백트래킹 테이블을 추적
        path.clear();

        point=N;
        path.add(point);
        Path prev;
        prev= dp[N][1]>dp[N][2] ? come[N][1] : come[N][2];

        while(prev!=null){
            path.add(prev.p);
            prev=come[prev.p][prev.step];
        }

        for(int i=path.size()-1; i>=0; --i){
            sb.append(path.get(i)).append(" ");
        }
        System.out.print(sb.toString().trim());


    }
    static void solve4(){
        N=sc.nextInt();
        for(int i=1; i<=N; ++i){
            score[i]=sc.nextInt();
        }

        dp[1][1]=score[1];
        dp[2][1]=score[1]+score[2];
        dp[2][2]=score[2];
        path.add(0);
        for(int i=3; i<=N; ++i){
            dp[i][1]=dp[i-1][2]+score[i];
            dp[i][2]=dp[i][2]=Math.max(dp[i-2][1],dp[i-2][2])+score[i];
            int last= path.get(path.size()-1);
            if(dp[i][1]>dp[i][2]){//한칸으로 올라간경우
                path.add(last+1);
            }
            else{
                path.add(last+2);
            }
        }

        int ans=Math.max(dp[N][1],dp[N][2]);
        System.out.print(ans);
    }
    static void solve3(){
        N=sc.nextInt();
        for(int i=1; i<=N; ++i){
            score[i]=sc.nextInt();
        }

        dp[1][1]=score[1];
        dp[2][1]=score[1]+score[2];
        dp[2][2]=score[2];

        for(int i=3; i<=N; ++i){
            dp[i][1]=dp[i-1][2]+score[i];
            dp[i][2]=Math.max(dp[i-2][1],dp[i-2][2])+score[i];
        }

        int ans= Math.max(dp[N][1],dp[N][2]);
        System.out.print(ans);
    }

    static void solve2(){
        N=sc.nextInt();
        for(int i=1; i<=N; ++i){
            score[i]=sc.nextInt();
        }
        maxAccScore[1]=score[1];
        used1[1]=true;

        maxAccScore[2]=maxAccScore[1]+score[2];
        used1[2]=true;
        for(int i=3; i<=N; ++i){
            if(!used1[i-2]&&!used1[i-1]&&maxAccScore[i-1]>maxAccScore[i-2]){
                used1[i]=true;
                maxAccScore[i]=maxAccScore[i-1]+score[i];
            }
            else{
                used2[i]=true;
                maxAccScore[i]=maxAccScore[i-2]+score[i];
            }
        }
        System.out.print(maxAccScore[N]);
    }

    static void solve1(){
        N= sc.nextInt();
        for(int i=1; i<=N; ++i){
            score[i]=sc.nextInt();
        }
        maxAccScore[1]=score[1];
        maxAccScore[2]=score[2];
        for(int i=3; i<=N; ++i){
            maxAccScore[i]= Math.max(maxAccScore[i-1],maxAccScore[i-2])+score[i];
        }
        System.out.print(maxAccScore[N]);
    }

    static class Path{
        int p;
        int step;
        Path(int p, int step){
            this.p =p;
            this.step= step;
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
