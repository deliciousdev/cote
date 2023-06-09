package part1.자료구조알고리즘1.ch04_2시뮬;

import java.io.*;
import java.util.StringTokenizer;

public class P02Q1233 {

    static StringBuilder sb= new StringBuilder() ;
    static FastReader sc = new FastReader();

    static int S1, S2, S3;
    static int cnt[];
    static int ans;

    public static void main(String[] args) {
        init();

        int mxCnt=0;
        for(int i=1; i<=S1; ++i){
            for(int j=1; j<=S2; ++j){
                for(int k= 1; k<=S3; ++k){
                    int sum= i+j+k;
                    ++cnt[sum];
                    if(cnt[sum]>mxCnt){
                        mxCnt=cnt[sum];
                        ans= sum;
                    }
                    else if(cnt[sum]==mxCnt){
                        ans=Math.min(ans,sum);
                    }
                }
            }
        }

        System.out.println(ans);
    }

    public static void init(){
        S1 = sc.nextInt();
        S2 = sc.nextInt();
        S3 = sc.nextInt();

        int maxInput=Math.max(S3,Math.max(S1,S2));
        cnt= new int[3*maxInput+1];
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next(){
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

        Long nextLong(){
            return Long.parseLong(next());
        }

        double nextDouble(){
            return Double.parseDouble(next());
        }

        String nextLine(){
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
